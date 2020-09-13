package com.project.seven;

import android.Manifest;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Seven extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mian);
        requestPermissions(new String[]{
            Manifest.permission.READ_CONTACTS
        },0);

        TextView textView = findViewById(R.id.text);

        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        ,null,null,null,null);
        if(cursor!=null) {
            while(cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String num = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER));
                textView.setText(textView.getText()+name + num+"\n");
            }
        }
    }
}
