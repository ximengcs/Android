package com.project.number;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.project.Listener.ChangeListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        run();
    }

    public void run() {

        Spinner raw = (Spinner)findViewById(R.id.raw);
        Spinner dest = (Spinner)findViewById(R.id.dest);

        EditText number = (EditText)findViewById(R.id.number);

        TextView result = (TextView)findViewById(R.id.result);

        Button change = (Button)findViewById(R.id.change);

        init(raw,dest,number,result,change);

        Calculate calculate = new Calculate(raw, dest, number);

        ChangeListener changeListener = new ChangeListener(calculate, result);

        change.setOnClickListener(changeListener);


    }

    private void init(Spinner raw, Spinner dest, EditText number,
            TextView result, Button change) {
        //Spinner
        ArrayList<String> list = new ArrayList<String>();
        for( int i = 2; i < 17; i++ ) {
            list.add(i + "");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,list);

        raw.setAdapter(adapter);
        dest.setAdapter(adapter);


    }
}
