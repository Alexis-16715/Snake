package main;


import controller.SnakeGame_Controller;
import view.Snake_View;

public class Main_Snake {

    public static void main(String[] args) {

        Snake_View view = new Snake_View();
        SnakeGame_Controller controller = new SnakeGame_Controller(view);
        view.getSnakeGame().addKeyListener(controller);
    }


}
