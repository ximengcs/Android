package com.project.assignment;

import android.annotation.SuppressLint;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.option);
        final Button button = findViewById(R.id.confirm);
        final TextView textView = findViewById(R.id.display);

        ArrayList<String> list = new ArrayList<String>();
        list.add(getString(R.string.option1));
        list.add(getString(R.string.option2));
        list.add(getString(R.string.option3));
        list.add(getString(R.string.option4));
        list.add(getString(R.string.option5));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item
        ,list);

        spinner.setAdapter(adapter);
        spinner.setSelection(3);


        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String text = (String)spinner.getSelectedItem();
                textView.setText(text);
                if ( text.equals(getString(R.string.option1)) ) {
                    textView.setTextColor(Color.RED);
                } else if( text.equals(getString(R.string.option2) ) ) {
                    textView.setTextColor(Color.parseColor("#ec7c26"));
                } else if( text.equals(getString(R.string.option3) ) ) {
                    textView.setTextColor(Color.YELLOW);
                } else if( text.equals(getString(R.string.option4) ) ) {
                    textView.setTextColor(Color.GREEN);
                } else if( text.equals(getString(R.string.option5) ) ) {
                    textView.setTextColor(Color.CYAN);
                }
            }
        });
        button.callOnClick();
    }
}
