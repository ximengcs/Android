package com.project.listener;

import android.view.View;

import com.project.mode.Head;

public class DirectListener implements View.OnClickListener {

    private Head head;
    private String direct;
    public DirectListener(Head head, String direct  ) {
        this.head = head;
        this.direct = direct;
    }
    @Override
    public void onClick(View v) {
        head.setDirect(direct);
    }
}
