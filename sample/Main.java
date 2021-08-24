package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
    private Button btnHello;
    static Stage primaryStage = new Stage();
    @Override
    public void start(Stage primaryStage1) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        Circle circle = new Circle();
//        circle.set
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
//
//        btnHello = new Button();
//        btnHello.setText("Say Hello");
//        btnHello.setOnAction(evt -> System.out.println("Hello World!"));
//        StackPane root1 = new StackPane();
//        root1.getChildren().add(btnHello);
//        Scene scene = new Scene(root1, 300, 100);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Hello");
//        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
