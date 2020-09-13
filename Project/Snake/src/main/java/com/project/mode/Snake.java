package com.project.mode;

public class Snake {

    private Head head;
    private int length;

    private long speed;


    private boolean exit = false;

    public Snake(Head head) {
        this.head = head;
        speed = 200;
        length = 2;
    }

    public boolean testEat(Food food) {
        boolean e = false;
        int x = head.getX();
        int y = head.getY();

        switch (head.getDirect()) {
            case Direct.DOWN:
                y = head.getY() + 1;
                break;
            case Direct.UP:
                y = head.getY() - 1;
                break;
            case Direct.LEFT:
                x = head.getX() - 1;
                break;
            case Direct.RIGHT:
                x = head.getX() + 1;
                break;
        }

        if( x == food.getX() && y == food.getY() )
            e = true;

        return e;
    }

    public void eat(Food food) {
        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Body newBody = new Body(head.getX(),head.getY(),head.getNext());
        head.setX(food.getX());
        head.setY(food.getY());
        head.setNext(newBody);
        length++;

        System.out.println(length);
    }


    public Body advance() {

        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Body ret = new Body( head.getLastBody().getX(), head.getLastBody().getY(), null);

        Body tmp = new Body(head.getX(), head.getY(), head.getNext());

        Body lastTmp = head.getLastBody();

        switch (head.getDirect()) {
            case Direct.DOWN:
                head.setY(head.getY() + 1);
                break;
            case Direct.UP:
                head.setY(head.getY() - 1);
                break;
            case Direct.LEFT:
                head.setX(head.getX() - 1);
                break;
            case Direct.RIGHT:
                head.setX(head.getX() + 1);
                break;
        }
        // set second last null
        Body setNull = head.getNext();

        if (setNull.getNext() != null) {
            while (setNull.getNext().getNext() != null) {
                setNull = setNull.getNext();
            }

            setNull.setNext(null);
        }

        head.setLastBody(setNull);



        // the last body move to head behind
        head.setNext(lastTmp);
        head.getNext().setX(tmp.getX());
        head.getNext().setY(tmp.getY());
        if( length > 2 )
            head.getNext().setNext(tmp.getNext());
        die();


        try {
            Thread.currentThread().sleep(getSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ret;

    }

    public Head getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public void show() {
        System.out.println("{head:" + head.getX() + "," + head.getY()
        + "" + head.getDirect() + "\n");
        Body tmp = head.getNext();
        while( tmp != null ) {
            System.out.println( "\nx:" + tmp.getX() + "\ny:" + tmp.getY());
            tmp = tmp.getNext();
        }
        System.out.println("}");
    }

    private void die() {
        if( head.getX()<1 || head.getY()<1 ||
                head.getX()>10 || head.getY()>9) {
            exit = true;
        }
        else
            exit = false;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
