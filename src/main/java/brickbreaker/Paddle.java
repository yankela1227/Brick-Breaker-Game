package brickbreaker;

public class Paddle
{
    /**
     * Dimensions of the paddle and its location on space
     */
    int xPos;
    int yPos;
    int xSize;
    int ySize;
    /**
     * Sets the bounds of the stage where the paddle is allowed to go
     */
    int xLimRight;
    int xLimLeft;


    /**
     * Vector variables
     */
    int xVec=0;
    int yVec =0;
    int maxSpeed =20;
    int minSpeed = -20;

    /**
     * Constructor
     */
    //constructor
    public Paddle()
    {
        xPos = 0;
        yPos = 600;
        xSize = 250;
        ySize = 10;
        xLimRight = 1116;
        xLimLeft = 0;

    }

    //methods
    //=================
    //DELTA BLOCK
    //================
    void xDelta()
    {//moves player along the x axis
        xPos += xVec;
        if(xPos<0)
        {
            xPos=0;
        }
        if((xPos > 1116))
        {
            xPos=1116;
        }
    }


    void increaseXVec()
    {//increases movment if the momvemt is below max speed
        if(xVec<maxSpeed)
        {
            xVec++;
        }
    }

    void decreaseXVec()
    {//decreases the x veleocity
        if(xVec > minSpeed)
        {
            xVec-=2;
        }
    }

    void normalizeX()
    {// this applies friction to the paddle if called, slowing it's movment to
        //zero
        if(xVec<0)
        {
            xVec++;
        }
        else if(xVec >0)
        {
            xVec--;
        }
    }

}