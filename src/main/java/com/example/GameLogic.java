package com.example;

public class GameLogic {
    private int ballX = 250;
    private int ballY = 250;
    private int ballXDir = -2;
    private int ballYDir = -3;

    public void moveBall() {
        ballX += ballXDir;
        ballY += ballYDir;
    }

    public void checkWallCollision(int width, int height) {
        // Top and bottom walls
        if (ballY < 0 || ballY > height - 30) {
            reverseY();
        }
    }

    public void reverseX() { ballXDir = -ballXDir; }
    public void reverseY() { ballYDir = -ballYDir; }

    // Getters and Setters for testing
    public int getBallX() { return ballX; }
    public int getBallY() { return ballY; }
    public void setBallPosition(int x, int y) { this.ballX = x; this.ballY = y; }
}