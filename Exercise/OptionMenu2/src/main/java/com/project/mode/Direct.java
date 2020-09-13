package com.project.mode;

public class Direct {
    public final static String UP = "UP";
    public final static String DOWN = "DOWN";
    public final static String LEFT = "LEFT";
    public final static String RIGHT = "RIGHT";

    private String current;

    public Direct( String current ) {
        this.current = current;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }
}
