package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class test1 {

    @FXML
    private Button backButton;
    static Stage primaryStage = new Stage();
    @FXML
    void clickBack(MouseEvent event) {
//        Parent root = null;
//        try {
//            root = FXMLLoader.load(getClass().getResource("test.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
        primaryStage.hide();
        Main.primaryStage.show();
    }

}