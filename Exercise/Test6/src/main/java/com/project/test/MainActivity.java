package com.project.test;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);

        String[] adapter = getResources().getStringArray(R.array.test2);

        spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, adapter));




        //final TextView test = findViewById(R.id.test);

        //final int[] i = {0};
        /*Handler handler = new Handler();
        while(true) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    test.setText("test"+i);
                }
            },1000);
        }*/

        //test.postDelayed()

        /*new Thread(new Runnable() {

            int l = 0;
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("reach");
                test.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        test.setText("test"+ l);
                    }
                },1000);
                l++;
            }
        }).start();*/
    }
}
