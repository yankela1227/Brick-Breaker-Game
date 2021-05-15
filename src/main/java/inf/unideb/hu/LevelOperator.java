package inf.unideb.hu;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;



public class LevelOperator
{
    //variables
    int levelNumber = 1;


    LEVELMenu menu = new LEVELMenu();
    LEVELOne firstLevel = new LEVELOne();

    //constructors

    //methods
    public void levelRender( GraphicsContext gc, double t)
    {//determines which level will render
        switch(levelNumber)
        {
            case 0:
            {//exit

                break;
            }
            case 1:
            {//Menu
                menu.render(gc, t);
                break;
            }
            case 2:
            {//levelOne
                firstLevel.render(gc,t);
                break;
            }
        }
    }
    public void levelTick( Input input, int tickCount)
    {// tells the game to perform a logic tick and asks if the
        //level should be exited
        switch(levelNumber)
        {
            case 0:
            {//exit application
                Platform.exit();
                break;
            }
            case 1:
            {//opeing menu
                menu.activate();
                menu.tick(input);
                if(menu.exit())
                {
                    menu.deactivate();
                    levelNumber = menu.destination();
                }
                break;
            }
            case 2:
            {//first level
                firstLevel.activate();

                firstLevel.tick(input, tickCount);
                if(firstLevel.exit())
                {
                    firstLevel.deactivate();
                    levelNumber = firstLevel.destination();
                }
                break;

            }


        }
    }

}