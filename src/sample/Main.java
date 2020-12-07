package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Diet Maker");
<<<<<<< Updated upstream
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(root, 1200, 600));
        primaryStage.show();
=======
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 774, 525));
        primaryStage.show();//mostrar
>>>>>>> Stashed changes
    }


    public static void main(String[] args) {
        launch(args);
    }
}
