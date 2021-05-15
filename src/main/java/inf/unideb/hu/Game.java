package inf.unideb.hu;

//=====================imports==================================================
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
//====================body======================================================
public class Game
{
    //variables
    public boolean running = true;//informs the game that it is running
    public int tickCount = 0;//tells the number of logic updates since start
    public int width = 1370;//gives width of screen
    public int height = 768;//gives height of screen
    Input input;
    LevelOperator levelOperator = new LevelOperator();
    //constructors

    //methods
    public void run(Stage primaryStage)
    {
        //================================
        //Staging block and initialization
        //================================
        primaryStage.setTitle("Brick-Breaker game");
        Group root = new Group();
        Scene scene = new Scene(root);
        input = new Input(scene);
        primaryStage.setScene(scene);
        Canvas canvas = new Canvas(width,height);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);
        primaryStage.show();

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
                    System.out.println("Frames:" + frames + "  Ticks:" + ticks + " || " + input.space);

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