package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.輔助.*; 
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLogicTest {

    @Test
    public void testBallMovement() {
        GameLogic logic = new GameLogic();
        int initialX = logic.getBallX();
        
        logic.moveBall();
        
        // Verifies that the ball actually moves positions
        assertEquals(initialX - 2, logic.getBallX());
    }

    @Test
    public void testWallCollision() {
        GameLogic logic = new GameLogic();
        // Force ball to top wall
        logic.setBallPosition(250, -1);
        
        logic.checkWallCollision(500, 400);
        
        // Moving ball again should move it down now, instead of up
        logic.moveBall();
        assertEquals(2, logic.getBallY()); 
    }
}