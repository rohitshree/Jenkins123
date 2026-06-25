package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PingPongGame extends JPanel implements ActionListener, KeyListener {
    private final GameLogic logic = new GameLogic();
    private int playerPaddleY = 170;
    private int computerPaddleY = 170;
    
    public PingPongGame() {
        Timer timer = new Timer(10, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 400); // Background

        g.setColor(Color.WHITE);
        g.fillRect(10, playerPaddleY, 10, 60); // Player
        g.fillRect(480, computerPaddleY, 10, 60); // Computer
        g.fillOval(logic.getBallX(), logic.getBallY(), 15, 15); // Ball
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logic.moveBall();
        logic.checkWallCollision(500, 400);

        // Simple Paddle Collisions
        if (logic.getBallX() <= 20 && logic.getBallY() >= playerPaddleY && logic.getBallY() <= playerPaddleY + 60) {
            logic.reverseX();
        }
        if (logic.getBallX() >= 465 && logic.getBallY() >= computerPaddleY && logic.getBallY() <= computerPaddleY + 60) {
            logic.reverseX();
        }

        // Dumb AI for computer paddle
        if (logic.getBallY() > computerPaddleY + 30 && computerPaddleY < 300) computerPaddleY += 2;
        if (logic.getBallY() < computerPaddleY + 30 && computerPaddleY > 0) computerPaddleY -= 2;

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && playerPaddleY > 0) playerPaddleY -= 20;
        if (e.getKeyCode() == KeyEvent.VK_DOWN && playerPaddleY < 300) playerPaddleY += 20;
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jenkins Practice Ping-Pong");
        PingPongGame game = new PingPongGame();
        frame.add(game);
        frame.setSize(515, 440);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}