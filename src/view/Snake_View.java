package view;

import javax.swing.JFrame;

public class Snake_View {


    private int width;
    private int height;
    private JFrame frame;

    private SnakeGame_View snakeGame;

    public Snake_View (){
        initialize();
    }

    private void initialize() {
        height=600;
        width=600;

        frame = new JFrame();
        frame.setTitle("Snake");
        frame.setVisible(true);
        frame.setSize(height, width);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        snakeGame = new SnakeGame_View(height, width);
        snakeGame.setVisible(true);
        frame.add(snakeGame);
        frame.pack();
        snakeGame.requestFocus();
    }

    public SnakeGame_View getSnakeGame() {
        return snakeGame;
    }
}
