package brickbreaker;

import javafx.scene.paint.Color;
public class Brick
{
    /**
     * Variables
     */
    public static int score = 0;
    int xPos;
    int yPos;
    int health;
    int sizeX = 40;
    int sizeY = 20;
    int lower;
    int left;
    int right;
    int top;
    Color shade;
    boolean notBroke = true;

    /**
     * Constructor
     * @param x position on x
     * @param y position on y
     * @param health health of the brick
     */
    public Brick(int x,int y, int health)
    {
        this.xPos = x;
        this.yPos = y;
        this.health = health;
        top = yPos;
        lower = yPos+sizeY;
        right = xPos;
        left = xPos + sizeX;

    }

    /**
     * Gives the brick a color depending on how many times it has been hit
     * @return the color of the brick
     */
    Color getShade()
    {
        if(health == 1)
        {
            shade = Color.DEEPPINK;
        }
        else if(health ==2)
        {
            shade = Color.CRIMSON;
        }
        else if(health ==3)
        {
            shade = Color.BROWN;
        }
        return shade;
    }

    /**
     * Hit method to decrease the bricks health.
     * @return true if the brick has broken
     */
    boolean hit()
    {
        health --;
        if(health <= 0)
        {
            score += 5;
            health = 0;
            notBroke = false;
            return true;
        }
        return false;
    }

    /**
     * Method to detect if the brick has been hit.
     * @param ball the game ball
     * @return hit if the brick has been hit
     */
    boolean detect(Ball ball)
    {
        if(notBroke)
        {
            //detect top or bottom
            if(ball.xPos <left &&ball.xPos >right)
            {
                if(ball.yPos ==lower)
                {
                    //the ball is attacking from below
                    //System.out.println("attack");
                    ball.reflectY();
                    return hit();
                }
                else if(ball.yPos ==top )
                {
                    //the ball is attacking from above
                    ball.reflectY();
                    return hit();
                }
            }
            //detect left or right
            else if(ball.yPos < lower && ball.yPos>top)
            {
                if(ball.xPos ==right)
                {
                    //ball is attacking from the right
                    ball.reflectX();
                    return hit();
                }
                else if (ball.xPos == left)
                {
                    //ball is attacking from the right
                    ball.reflectX();
                    return hit();
                }
            }
        }
        return false;
    }

    /**
     * Method to kill the brick
     */
    void kill()
    {
        this.health = 0;
        this.notBroke = false;
    }

}