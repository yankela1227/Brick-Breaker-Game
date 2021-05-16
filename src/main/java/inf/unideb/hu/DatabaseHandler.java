package inf.unideb.hu;

import brickbreaker.Brick;
import controller.Game;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Update;


public class DatabaseHandler {
    static Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    static public void createTable() {
        try (Handle handle = jdbi.open()) {
            handle.execute(
                    "CREATE TABLE highscores ("+
                    	"username VARCHAR PRIMARY KEY,"+
                    	"score INTEGER NOT NULL"+
                    ")"
            );
        }
    }
    static public void insertTable() {
        try (Handle handle = jdbi.open()) {
            Update insert = handle.createUpdate("INSERT INTO highscores VALUES (:username, :score)");
            insert.bind("username", Game.username)
                    .bind("score", Brick.score)
                    .execute();
            var numOfLegoSets = handle.createQuery("SELECT * FROM highscores");
            //System.out.println(numOfLegoSets);
        }
    }

}