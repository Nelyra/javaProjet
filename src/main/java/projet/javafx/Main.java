package projet.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Vue administateur");

        TextArea textArea = new TextArea();
        textArea.setText("Vue administateur");
        textArea.setEditable(false);
        textArea.setStyle("-fx-font-size: 40px;");



        StackPane root = new StackPane();
        root.getChildren().add(textArea);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}