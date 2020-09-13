package com.project.snake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.project.control.Controller;
import com.project.mode.Direct;
import com.project.mode.Food;
import com.project.mode.Head;

public class Snake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        com.project.mode.Snake snake = new com.project.mode.Snake(new Head(5,5, Direct.LEFT));

        Food food = new Food();
        View view = new View(this, snake,food );
        final Controller controller = new Controller(snake,view,food);
        new Thread(new Runnable() {
            @Override
            public void run() {
                controller.run();
            }
        }).start();
    }
}