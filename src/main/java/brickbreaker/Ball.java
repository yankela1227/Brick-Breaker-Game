package brickbreaker;
/**
 * Class representing the Ball of the game.
 */


public class Ball {
    //variables
    int xPos;
    int yPos;
    int xSize;
    int ySize;
    boolean free = false;
    int left;
    int right;
    int up;
    int down;

    //vetor
    int xVec;
    int yVec;
    //speed
    int maxSpeed=20;
    int optSpeed=5;

    /**
     * Constructors
     */
    public Ball()
    {
        this.xPos = 500;
        this.yPos = 300;
        this.xSize = 15;
        this.ySize = 15;
        this.xVec = -optSpeed;
        this.yVec = optSpeed;
    }
    /**
     * Initializes the ball's variables
     */
    void init()
    {//initializes the ball's variables
        this.left = xPos;
        this.right = xPos + xSize;
        this.up = yPos;
        this.down = yPos + ySize;
    }
    /**
     * Changes the ball's position align the x axis
     */
    void xDelta()
    {
        xPos += xVec;
        if(xPos <0)
        {
            xPos = 0;
            reflectX();
        }
        else if(xPos >1346)
        {
            xPos = 1346;
            reflectX();
        }
    }

    /**
     * Changes the position along the y axis
     * @param player player
     * @return
     */
    boolean yDelta(Paddle player)
    {
        yPos += yVec;
        if(yPos <0)
        {
            yPos = 0;
            reflectY();
            return false;
        }
        else if( (xPos >player.xPos) &&(xPos <player.xPos +player.xSize)&& (yPos == player.yPos-ySize))
        {

            reflectY();
            return false;
        }
        else if(yPos> 760)
        {
            yPos = 760;
            reflectY();
            return true;
        }

        return false;
    }

    /**
     *
     * @param player
     * @param onPaddle
     * @return
     */
    boolean Delta(Paddle player, Boolean onPaddle)
    {
        if(onPaddle)
        {
            this.xPos = player.xPos + (player.xSize/2) -(this.xSize/2);
            this.yPos = player.yPos - 20;
            return false;
        }
        else
        {
            xDelta();
            return yDelta(player);
        }

    }
    void normalizeX()
    {
        if(xVec < optSpeed)
        {
            xVec = optSpeed;
        }
        else if(xVec > optSpeed)
        {
            xVec--;
        }
    }
    void normalizeY()
    {
        if(yVec < optSpeed)
        {
            yVec = optSpeed;
        }
        else if(yVec >optSpeed)
        {
            yVec--;
        }
    }
    void normalize()
    {
        normalizeX();
        normalizeY();
    }
    void limitVec()
    {
        if(xVec >maxSpeed)
        {
            xVec=maxSpeed;
        }
        if(yVec>maxSpeed)
        {
            yVec = maxSpeed;
        }
    }
    void check()
    {
        limitVec();
        normalize();
    }
    void reflectX()
    {
        xVec = xVec*-1;
    }
    void reflectY()
    {
        yVec = yVec*-1;
    }
    void toggleFree()
    {
        this.free = !free;
    }
}
