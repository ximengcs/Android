package com.project.sevenservice;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.ContactsContract;

public class SevenService extends Service {

    private final IBinder iBinder = new ISeven.Stub() {
        @Override
        public String getInfo() throws RemoteException {
            StringBuilder result = new StringBuilder();
            if (checkSelfPermission(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                        String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        result.append(name);
                        result.append("!");
                        result.append(number);
                        result.append("\n");
                    }
                }
            } else
                return "~~~";

            return result.toString();
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return false;
    }
}
