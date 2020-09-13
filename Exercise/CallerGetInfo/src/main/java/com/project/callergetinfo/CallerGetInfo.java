package com.project.callergetinfo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.getinfoservice.ISearchContact;
import com.project.getinfoservice.MyContact;

public class CallerGetInfo extends AppCompatActivity {

    private Handler handler = new Handler();

    private TextView display = null;
    private EditText input = null;
    private Button search = null;

    private ISearchContact iSearchContact = null;

    private MyContact myContact = null;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Toast.makeText(CallerGetInfo.this, "远程服务绑定成功", Toast.LENGTH_SHORT).show();
            iSearchContact = ISearchContact.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private void updateUI() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (myContact.name.equals("notFind"))
                    display.setText("姓名不存在");
                else
                    display.setText(myContact.name + "\n" + myContact.phone);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        display = findViewById(R.id.display);
        input = findViewById(R.id.input);
        search = findViewById(R.id.search);

        final Intent intent = new Intent("com.project.getinfoservice.GetInfo");
        intent.setPackage("com.project.getinfoservice");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        search.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (myContact != null) {
                                    try {
                                        myContact = iSearchContact.SearchContact(input.getText().toString());
                                    } catch (RemoteException e) {
                                        e.printStackTrace();
                                    }
                                    updateUI();
                                } else
                                    myContact = new MyContact("请打开权限", "");
                            }
                        }).start();
                    }
                }
        );
    }
}
