package com.project.control;


import com.project.mode.Body;
import com.project.mode.Food;
import com.project.mode.Snake;
import com.project.show.View;

public class Controller {

    private Snake snake;
    private View view;

    private Food food;

    public Controller(Snake snake, View view, Food food) {
        this.snake = snake;
        this.view = view;
        this.food = food;
        food.next();
    }

    public void run() {

        Body b;
        while (true) {
            if (snake.isExit()) {
                System.out.println("exit");
                break;
            }
            b = null;
            if( snake.testEat(food) == false ) {

                b = snake.advance();

                if( b != null )
                    view.reflesh(b);

            }
            else
            {
                snake.eat(food);
                food.next();
                view.reflesh(null);
            }

            snake.show();
        }
    }
}
