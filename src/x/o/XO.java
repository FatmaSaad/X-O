package x.o;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class XO extends Application {    
    @Override
    public void start(Stage stage) throws Exception {
        
        // Change any Line
        Parent root = new PlayingModes(stage);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}