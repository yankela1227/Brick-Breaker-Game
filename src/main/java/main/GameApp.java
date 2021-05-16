package main;
import controller.Game;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameApp extends Application {
    @Override
    public void start(Stage primaryStage)
    {
        Game game = new Game();
        game.run(primaryStage);
    }
}
