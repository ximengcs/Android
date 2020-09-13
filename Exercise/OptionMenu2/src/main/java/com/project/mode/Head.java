package com.project.mode;

public class Head {

    private int x;
    private int y;

    private Body lastBody;
    private Body next;

    private String direct;

    public Head( int x, int y, String direct ) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.next = new Body(6,5,null);
        lastBody = next;
    }

    public Body getNext() {
        return next;
    }

    public void setNext(Body next) {
        this.next = next;
    }

    public Body getLastBody() {
        return lastBody;
    }

    public void setLastBody(Body lastBody) {
        this.lastBody = lastBody;
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

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }
}
