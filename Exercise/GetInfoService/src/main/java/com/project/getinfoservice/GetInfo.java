package com.project.getinfoservice;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.ContactsContract;

import java.util.HashMap;

public class GetInfo extends Service {

    private HashMap<String,String> info = new HashMap<>();

    private boolean can = false;

    private MyContact contact = null;

    private final IBinder iBinder = new ISearchContact.Stub() {
        @Override
        public MyContact SearchContact(String contactName) throws RemoteException {
            if(can) {
                find(contactName);
                return contact;
            }else
                return null;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        initial();
        return iBinder;
    }

    private void find(String name) {
        if( info.get(name) != null ) {
            contact = new MyContact(name,info.get(name));
        }else
            contact = new MyContact("notFind","0");
    }

    private void initial() {
        if (checkSelfPermission(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            can = true;
            Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                    info.put(name,number);
                }
            }
        }
    }
}
