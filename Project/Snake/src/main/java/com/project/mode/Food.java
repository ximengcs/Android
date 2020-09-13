package com.project.mode;

import java.util.Random;

public class Food {

    private int x;
    private int y;

    public void next() {
        Random random = new Random();
        x = random.nextInt(10)+1;
        y = random.nextInt(8)+1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
