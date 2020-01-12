package x.o;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PlayingModes extends Pane {

    protected final Button singleMode;
    protected final Button multiMode;
    protected final Button playingOnline;

    public PlayingModes(Stage stage) {

        singleMode = new Button();
        multiMode = new Button();
        playingOnline = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        singleMode.setId("singleMode");
        singleMode.setLayoutX(159.0);
        singleMode.setLayoutY(82.0);
        singleMode.setMnemonicParsing(false);
        singleMode.setPrefHeight(67.0);
        singleMode.setPrefWidth(251.0);
        singleMode.setText("Single Mode");
        singleMode.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        singleMode.setCursor(Cursor.HAND);
        
        singleMode.setOnAction((ActionEvent event) -> {
            stage.getScene().setRoot(new OneToPc());
        });

        multiMode.setId("multiMode");
        multiMode.setLayoutX(156.0);
        multiMode.setLayoutY(179.0);
        multiMode.setMnemonicParsing(false);
        multiMode.setPrefHeight(67.0);
        multiMode.setPrefWidth(251.0);
        multiMode.setText("Mutli Mode");
        multiMode.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        multiMode.setCursor(Cursor.HAND);
        
        multiMode.setOnAction((ActionEvent event) -> {
            stage.getScene().setRoot(new TwoPlayer());
        });

        playingOnline.setId("playingOnline");
        playingOnline.setLayoutX(159.0);
        playingOnline.setLayoutY(276.0);
        playingOnline.setMnemonicParsing(false);
        playingOnline.setPrefHeight(67.0);
        playingOnline.setPrefWidth(251.0);
        playingOnline.setText("Playing Online");
        playingOnline.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playingOnline.setCursor(Cursor.HAND);
        
        playingOnline.setOnAction((ActionEvent event) -> {
            stage.getScene().setRoot(new Login(stage));
        });

        getChildren().add(singleMode);
        getChildren().add(multiMode);
        getChildren().add(playingOnline);

    }
}
