package main.java.Controller;


import main.java.Model.Randomize;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class HomePage {

    public JFXButton browser;
    public JFXTextField textFieldFolder;

    public JFXButton play;
    public JFXTextField textFieldFile;

    public JFXTextField typeInput;

    public JFXButton generate;

    private Stage primaryStage;

    private String filePath;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    public void generateOnMouseClicked(MouseEvent mouseEvent) {
        String path = textFieldFolder.getText();
        try {
            Path output = Randomize.makeRandom(path,typeInput.getText());
            filePath = output.toString();
            textFieldFile.setText(output.getFileName().toString());
        }catch (Exception e){}
    }

    public void browserOnMouseClicked(MouseEvent mouseEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(primaryStage);
        textFieldFolder.setText(selectedDirectory.getAbsolutePath());
    }

    public void playOnMouseClicked(MouseEvent mouseEvent) {
        if (filePath!=null && new File(filePath).isFile())
            excCommand(filePath);
    }

    private static void excCommand(String new_dir){
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(new String[]{"cmd.exe","/c",new_dir});
        } catch (IOException e) {}
    }
}
