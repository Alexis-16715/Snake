package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import model.Title;
import view.SnakeGame_View;
import view.Snake_View;

public class SnakeGame_Controller implements ActionListener, KeyListener {

    @SuppressWarnings("unused")
    private Snake_View view;

    private SnakeGame_View snakeGame;

    Timer gameLoop;

    private int velocityY;

    private int velocityX;

    private Title snake;
    private Title food;


    private boolean gameOver = false;

    private ArrayList<Title> snakeBody;

    private Random random;

    public SnakeGame_Controller(Snake_View view){
        this.view = view;
        this.snakeGame = view.getSnakeGame();
        gameLoop = new Timer(100, this);

        random = new Random();
        placeFood();


        velocityX = 0;
        velocityY = 0;

        
        gameLoop.start();
        snakeGame.addKeyListener(this);
    }


    public void actionPerformed(ActionEvent e){
        move();
        snakeGame.repaint();
        if(gameOverCondictions()){
            gameLoop.stop();
        }
    }


    private boolean gameOverCondictions(){

        for (int i = 0; i < snakeBody.size(); i++){
            Title snakePart = snakeBody.get(i);

            if(collision(snake, snakePart)){
                gameOver = true;
            }
        }
        return gameOver;
    }

    private void move() {

        snake = snakeGame.getSnake();
        food = snakeGame.getFood();
        snakeBody = snakeGame.getSnakeBody();

        if(collision(snake, food)){
            snakeBody.add(new Title(food.getX(), food.getY()));
            placeFood();
        }

        //Snake Head

        for(int i = snakeBody.size()-1; i >= 0 ; i--){
            Title snakeParts =  snakeBody.get(i);
            if(i == 0){
                snakeParts.setX(snake.getX());
                snakeParts.setY(snake.getY());
            } else{
                Title preSnakeParts =  snakeBody.get(i-1);

                snakeParts.setX(preSnakeParts.getX());
                snakeParts.setY(preSnakeParts.getY());
            }
        }

        snakeGame.setSnakeBody(snakeBody);
        snake.setX(snake.getX() + velocityX);
        snake.setY(snake.getY() + velocityY);
    }

    private boolean collision (Title object, Title object2){
        return object.getX() == object2.getX() && object.getY() == object2.getY();
    } 

    private void placeFood() {
        food = snakeGame.getFood();
        food.setX(random.nextInt(snakeGame.getWidth()/snakeGame.getTitleSize()));
        food.setY(random.nextInt(snakeGame.getHeight()/snakeGame.getTitleSize()));

    }


    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP && velocityY != 1) {
            velocityX = 0;
            velocityY = -1;

        }
        else 
        if (key == KeyEvent.VK_DOWN && velocityY != -1) {
            velocityX = 0;
            velocityY = 1;
        }
        else 
        if (key == KeyEvent.VK_RIGHT && velocityX != -1) {
            velocityX = 1;
            velocityY = 0;
        } 
        else 
        if (key == KeyEvent.VK_LEFT && velocityX != 1) {
            velocityX = -1;
            velocityY = 0;
        } 

        

    }
    public void keyReleased(KeyEvent e) {}

}
