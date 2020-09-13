package com.project.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(
                                "com.project.myapplication.IMyAidlInterface.aidl");
                        intent.setPackage(getPackageName());
                        bindService(intent,connection,Context.BIND_AUTO_CREATE);
                    }
                }
        );
    }

    private ServiceConnection connection =
            new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    Log.i("onservice","onservice");
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    Log.i("ondisservice","ondisservice");
                }
            };
}
