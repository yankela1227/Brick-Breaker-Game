package brickbreaker;

/**
 * Class to create the bricks
 */
public class BrickArray
{

    int cross = 27;
    int down = 5;
    Brick[][] bricks = new Brick[down][cross];

    /**
     * Initializer
     */
    public BrickArray()
    {
        init();
    }
    /**
     * Initializer
     */
    void init()
    {
        for(int i =0; i < down;i++)
        {
            for(int j = 0; j <cross;j++)
            {
                bricks[i][j] = new Brick((j * 50)+15,(i *50)+10,3);
            }
        }
    }

    /**
     * Increases the number of destroyed bricks
     * @param ball ball
     * @return number of destroyed bricks
     */
    int checkAll(Ball ball)
    {
        int numberKilled = 0;
        for(int i =0; i <down;i++)
        {
            for(int j=0; j<cross;j++)
            {
                if(bricks[i][j].detect(ball))
                {
                    numberKilled++;
                }

            }
        }
        return numberKilled;
    }

}