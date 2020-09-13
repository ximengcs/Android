package com.project.test7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

public class Test7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView textView = findViewById(R.id.text);
        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.stop);

        /**
         * 显示启动
         */
        final Intent serviceIntent = new Intent(this,RandomService.class);

        /**
         * 隐身启动
         * (当所调用的intent不在同一个应用程序中时，必须使用隐式启动)
         */
        /*
        Intent serviceIntent2 = new Intent();
        serviceIntent2.setAction("RandomService");
        */

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("1","reach");
                        startService(serviceIntent);
                    }
                }
        );

        button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopService(serviceIntent);
                    }
                }
        );
    }
}