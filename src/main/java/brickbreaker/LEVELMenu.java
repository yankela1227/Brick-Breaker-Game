package brickbreaker;

import controller.Game;
import controller.Input;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import main.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LEVELMenu
{
    //variables
    private static final Logger logger = LogManager.getLogger(Main.class);
    boolean isPlaySelected = true;
    boolean isActive;

    boolean shouldExit = false;
    boolean toggle = true;
    //constructor

    //methods

    public void render(GraphicsContext gc, double time)
    {//renders the scene
        //Black Background
        if(isActive){


            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, 1366, 768);
            //Render Title
            gc.setFill(Color.CRIMSON);
            gc.setFont(new Font( 50));
            gc.setTextAlign(TextAlignment.CENTER);

            gc.fillText("Jankelic Ivan Brick Breaker", 670, 140);

            gc.setFill(Color.WHITE);
            gc.setFont(new Font( 50));
            gc.setTextAlign(TextAlignment.CENTER);

            gc.fillText("Username: "+ Game.username, 670, 340);


            //renders play and exit signs
            gc.setFont(new Font(50));
            //colors the active choice yellow
            if(isPlaySelected)
            {
                gc.setFill(Color.YELLOW);
            }
            else
            {
                gc.setFill(Color.RED);
            }
            gc.fillText("Play", 400, 500);

            if(isPlaySelected)
            {
                gc.setFill(Color.RED);
            }
            else
            {
                gc.setFill(Color.YELLOW);
            }
            gc.fillText("Exit", 940, 500);

            if(isPlaySelected)
            {
                gc.setFill(Color.YELLOW);
                gc.fillRect(350, 520, 100, 10);

            }
            else
            {
                gc.setFill(Color.YELLOW);
                gc.fillRect(890, 520, 100, 10);
            }

        }






    }

    public void tick(Input input)
    {//this is for controlling the cursor that selects which level to display
        if(this.isActive){
            if(input.left && toggle)
            {//select should play
                isPlaySelected = true;
                toggle = false;

            }
            else if(input.right && toggle)
            {
                isPlaySelected = false;
                toggle = false;
            }
            else if(input.space)
            {
                logger.info("exit");
                //System.out.println("exit");
                shouldExit = true;

            }
            else if(!input.right && !input.left)
            {
                toggle = true;
            }
        }

    }


    public boolean exit()
    {//determines if the level should exit or not to ask the
        //level operator which level to load next, if destination is zero
        // then it should close the application
        //as the value of level zero represent an end to the game
        return shouldExit;
    }

    public int destination()
    {
        if(isPlaySelected)
        {//case:The player wishes to play and the menu is exited to the game
            return 2;
        }
        else{//case: The player wishes to quit and the application is
            //given the command to close
            return 0;
        }
    }
    public void activate()
    {
        this.isActive = true;
        if(shouldExit = true)
        {

            this.shouldExit = false;
        }
    }
    public void deactivate()
    {
        this.isActive = false;
    }

}