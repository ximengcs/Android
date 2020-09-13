package com.project.sevenclient;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.sevenservice.ISeven;

import java.util.HashMap;

public class SevenClient extends AppCompatActivity {

    private HashMap<String, String> map = new HashMap<String, String>();

    ISeven iSeven = null;

    TextView textView = null;

    EditText input = null;

    private ServiceConnection serviceConnection
            = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            if (iSeven == null) {
                Toast.makeText(SevenClient.this, "绑定", Toast.LENGTH_SHORT).show();
                iSeven = ISeven.Stub.asInterface(service);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = findViewById(R.id.text);

        input = findViewById(R.id.input);

        requestPermissions(new String[]{
                Manifest.permission.READ_CONTACTS
        }, 0);

        Intent intent = new Intent("com.project.sevenservice.SevenService");
        intent.setPackage("com.project.sevenservice");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        findViewById(R.id.search).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (iSeven != null) {
                            try {
                                dispose(iSeven.getInfo());
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        );
    }

    private void dispose(String string) {
        if (string.equals("~~~")) {
            textView.setText("请打开联系人权限");
        } else {
            String[] str = string.split("\n");
            for( int i = 0; i < str.length; i++ ) {
                String[] tpm = str[i].split("!");
                map.put(tpm[0],tpm[1]);
            }
            find();
        }
    }

    private void find() {
        String name = input.getText().toString();
        String num = map.get(name);
        if( num != null )
            textView.setText("姓名:"+name+"\n"+"电话:"+num);
        else
            textView.setText("姓名不存在");
    }
}
