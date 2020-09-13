package com.project.treadrandomservice;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThreadRandomService extends AppCompatActivity {

    private static Handler handler = new Handler();
    private static TextView label=null;
    private static double random;

    public static void UpdateGUI( double refreshDouble ) {
        random = refreshDouble;
        handler.post(refresh);
    }

    private static Runnable refresh = new Runnable() {
        @Override
        public void run() {
            label.setText(String.valueOf(random));
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
