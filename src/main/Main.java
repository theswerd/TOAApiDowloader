package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    private static Stage currentStage;
    private static Controller controller;

    @Override
    public void start(Stage primaryStage){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        try {
            Parent root = loader.load();
            primaryStage.setTitle("TOA API Tester");
            primaryStage.setScene(new Scene(root, 300, 500));
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/app_ico.png")));
            primaryStage.show();

            Main.currentStage = primaryStage;
            Main.controller = (Controller) loader.getController();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Stage getCurrentStage() {
        return currentStage;
    }

    public static Controller getController() {
        return controller;
    }

    public static void main(String[] args) {
        launch(args);
    }


}
