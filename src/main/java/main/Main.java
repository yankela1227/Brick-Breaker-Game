package main;

import inf.unideb.hu.DatabaseHandler;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        DatabaseHandler.createTable();
        Application.launch(GameApp.class, args);
    }

}
