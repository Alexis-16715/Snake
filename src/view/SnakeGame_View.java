package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JPanel;

import model.Title;

public class SnakeGame_View extends JPanel {
    private int height;

    private int width;

    private int titleSize = 25;

    private Title snake;

    private Title food;


    private ArrayList<Title> snakeBody;


    //gamelogic
    Timer gameLoop;
    
    public SnakeGame_View(int height, int width){
        this.height = height;
        this.width = width;
        initialize();
    }

    private void initialize() {
        setPreferredSize(new Dimension (width, height));
        setBackground(Color.BLACK);

        snake = new Title(5, 5);
        food = new Title(10, 10);

        snakeBody = new ArrayList<Title>();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        //grid
        for(int i = 0; i < width/titleSize; i++){
            // g.setColor(Color.ORANGE);
            g.drawLine(i*titleSize, 0, i*titleSize, width);
            g.drawLine(0, i*titleSize, width, i*titleSize);

        }

        
        //Snake
        g.setColor(Color.GREEN);
        g.fillRect(snake.getX() *titleSize, snake.getY()*titleSize, titleSize, titleSize);

        //SnakeBody

        for(int i = 0; i < snakeBody.size(); i++){
            Title snakePart = snakeBody.get(i);
            g.fillRect(snakePart.getX() * titleSize, snakePart.getY() * titleSize, titleSize, titleSize);
        }


        //food
        g.setColor(Color.RED);
        g.fillRect(food.getX() *titleSize, food.getY()*titleSize, titleSize, titleSize);

    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getTitleSize() {
        return titleSize;
    }

    public Title getFood() {
        return food;
    }


    public Title getSnake() {
        return snake;
    }

    public ArrayList<Title> getSnakeBody() {
        return snakeBody;
    }

    public void setSnakeBody(ArrayList<Title> snakeBody) {
        this.snakeBody = snakeBody;
    }

}
