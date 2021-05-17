package brickbreaker;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrickTest {

    private Brick brickUnderTest;

    @BeforeEach
    void setUp() {
        brickUnderTest = new Brick(0, 0, 3);
    }

    @Test
    void testGetShade() {
        // Setup
        final Color expectedResult = Color.BROWN;

        // Run the test
        final Color result = brickUnderTest.getShade();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testHit() {
        // Setup

        // Run the test
        final boolean result = brickUnderTest.hit();

        // Verify the results
        assertFalse(result);
    }

    @Test
    void testDetect() {
        // Setup
        final Ball ball = new Ball();

        // Run the test
        final boolean result = brickUnderTest.detect(ball);

        // Verify the results
        assertFalse(result);
    }

}
