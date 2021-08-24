package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class test {

        @FXML
        private Button buttonBlock;
        private Stage primaryStage = new Stage();
        @FXML
        void click(MouseEvent event) {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("test1.fxml"));
            } catch (IOException e) {
                System.out.println("error");
            }

            Scene scene = new Scene(root);
            test1.primaryStage.setScene(scene);
            Main.primaryStage.hide();
            test1.primaryStage.show();
        }



}
