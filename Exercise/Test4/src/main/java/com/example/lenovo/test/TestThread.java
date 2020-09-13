package com.example.lenovo.test;

import android.os.SystemClock;
import android.widget.ImageView;
import android.widget.TextView;

public class TestThread extends Thread {

    private MainActivity main;
    public TestThread( MainActivity main ) {
        this.main = main;
    }

    @Override
    public void run() {
        super.run();

        ImageView test = main.findViewById(R.id.test);

        TextView text = main.findViewById(R.id.text);
       //test.setBackgroundResource(R.drawable.black);

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        text.setText("text1");
        //SystemClock.sleep(1000);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        text.setText("text2");
       //test.setBackgroundResource(R.drawable.white);
        //SystemClock.sleep(1000);
       // test.setImageResource(R.drawable.test);




    }
}
