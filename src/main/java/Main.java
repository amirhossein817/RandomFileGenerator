package main.java;

import main.java.Controller.HomePage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("view/home_page.fxml"));
        Parent root = loader.load();
        HomePage homePage = loader.getController();
        homePage.setPrimaryStage(primaryStage);
        Scene scene = new Scene(root);
        primaryStage.setOnCloseRequest(event -> {
            primaryStage.close();
            System.exit(0);
        } );
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
