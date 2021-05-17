package controller;

//=====================imports==================================================
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import main.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//====================body======================================================
public class Game
{
    //variables
    Stage window;
    Scene scene1, scene2;
    public static String username;
    public boolean running = true;//informs the game that it is running
    public int tickCount = 0;//tells the number of logic updates since start
    public int width = 1370;//gives width of screen
    public int height = 768;//gives height of screen
    private static final Logger logger = LogManager.getLogger(Main.class);
    Input input;
    LevelOperator levelOperator = new LevelOperator();
    //constructors

    //methods
    public void run(Stage primaryStage)
    {
        //================================
        //Staging block and initialization
        //================================
        window = primaryStage;
        Label label1 = new Label("Type your username!");
        TextField usernameTextField = new TextField();

        //System.out.println("Username: "+username);
        Button button1 = new Button("Set");
        button1.setOnAction(e -> {
            window.setScene(scene2);
            username = usernameTextField.getText();
        });
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, usernameTextField, button1);
        scene1 = new Scene(layout1,200,200);
        primaryStage.setTitle("Brick-Breaker game");
        Group root = new Group();

        scene2 = new Scene(root);
        input = new Input(scene2);
        primaryStage.setScene(scene2);
        Canvas canvas = new Canvas(width,height);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        window.setScene(scene1);
        window.setTitle("Brick-Breaker Game");
        window.show();
        //primaryStage.setFullScreen(true);
        //primaryStage.setResizable(false);
        //primaryStage.show();

        //================================
        //Rendering and logic block
        //================================
        final long startNanoTime = System.nanoTime();


        new AnimationTimer()
        {
            //==================frame rate detection block
            long lastTime = System.nanoTime();
            double nsPerTick =1000000000D/60D;

            int frames = 0;
            int ticks = 0;

            long lastTimer = System.currentTimeMillis();
            double delta = 0;
            //===================end of frame rate block
            @Override
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                //System.out.println(t);

                tick(input);
                //
                ticks++;
                render(gc,t);
                //
                frames++;
                //
                if(System.currentTimeMillis() - lastTimer >=1000)
                {//this resets the performance timer
                    lastTimer +=1000;
                    logger.info("Frames:" + frames + "  Ticks:" + ticks + " || " + input.space);
                    //System.out.println("Frames:" + frames + "  Ticks:" + ticks + " || " + input.space);

                    frames =0;
                    ticks = 0;
                }
            }
        }.start();
    }
    public void tick(Input input)
    {
        tickCount++;
        levelOperator.levelTick( input, tickCount);



    }
    public void render(GraphicsContext gc, double t)
    {
        levelOperator.levelRender( gc,t);
    }

}