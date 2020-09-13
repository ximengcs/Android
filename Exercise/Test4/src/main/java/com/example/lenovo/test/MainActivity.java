package com.example.lenovo.test;

import android.media.Image;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView view = findViewById(R.id.test);
        view.setlistener
        /*new Handler().postDelayed(new Runnable(){
            public void run() {

                ImageView test = findViewById(R.id.test);
                test.setBackgroundResource(R.drawable.black);
                //execute the task
            }
        }, 1000);

        new Handler().postDelayed(new Runnable(){
            public void run() {

                ImageView test = findViewById(R.id.test);
                test.setBackgroundResource(R.drawable.test);
                //execute the task
            }
        }, 2000);*/

        /*TestThread test = new TestThread(this);
        test.start();*/
    }


/*
    void test3() {
        CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkbox);
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.checkbox2);
        RadioButton radioButton =
                (RadioButton)findViewById(R.id.RadioButton1);
        RadioButton radioButton2 =
                (RadioButton)findViewById(R.id.RadioButton2);

        CheckBox.OnClickListener checkboxListener = new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
        checkBox1.setOnClickListener(checkboxListener);
        checkBox2.setOnClickListener(checkboxListener);

        RadioButton.OnClickListener radioButtonListener = new RadioButton.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        };

        radioButton.setOnClickListener(radioButtonListener);
        radioButton2.setOnClickListener(radioButtonListener);
    }*/
}


