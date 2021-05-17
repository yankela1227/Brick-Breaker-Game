package brickbreaker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BallTest {

    private Ball ballUnderTest;

    @BeforeEach
    void setUp() {
        ballUnderTest = new Ball();
        ballUnderTest.xPos = 0;
        ballUnderTest.yPos = 0;
        ballUnderTest.xSize = 0;
        ballUnderTest.ySize = 0;
        ballUnderTest.free = false;
        ballUnderTest.left = 0;
        ballUnderTest.right = 0;
        ballUnderTest.up = 0;
        ballUnderTest.down = 0;
        ballUnderTest.xVec = 0;
        ballUnderTest.yVec = 0;
        ballUnderTest.maxSpeed = 0;
        ballUnderTest.optSpeed = 0;
    }


    @Test
    void testYDelta() {
        // Setup
        final Paddle player = new Paddle();

        // Run the test
        final boolean result = ballUnderTest.yDelta(player);

        // Verify the results
        assertFalse(result);
    }

    @Test
    void testDelta() {
        // Setup
        final Paddle player = new Paddle();

        // Run the test
        final boolean result = ballUnderTest.Delta(player, false);

        // Verify the results
        assertFalse(result);
    }
}
