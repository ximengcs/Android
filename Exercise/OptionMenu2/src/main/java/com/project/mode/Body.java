package com.project.mode;

public class Body {

    private int x;
    private int y;

    private Body next;

    public Body( int x, int y, Body next ) {
        this.x = x;
        this.y = y;
        this.next = next;
    }

    public Body getNext() {
        return next;
    }

    public void setNext(Body body) {
        this.next = body;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
