package com.project.Listener;

import android.view.View;

import android.view.View.OnClickListener;
import android.widget.TextView;

import com.project.number.Calculate;

public class ChangeListener implements OnClickListener {

    private Calculate calculate;
    private TextView result;

    public ChangeListener(Calculate calculate, TextView result) {
        this.calculate = calculate;
        this.result = result;
    }

    @Override
    public void onClick(View v) {
        calculate.run();
        result.setText(calculate.getResult().toString());
    }
}
