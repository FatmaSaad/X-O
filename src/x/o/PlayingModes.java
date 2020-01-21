package x.o;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PlayingModes extends Pane {

    protected final Button singleMode;
    protected final InnerShadow innerShadow;
    protected final Button multiMode;
    protected final InnerShadow innerShadow0;
    protected final Button playingOnline;
    protected final InnerShadow innerShadow1;
    protected final ImageView imageView;
    protected final Reflection reflection;
    protected final Button button;

    public PlayingModes(Stage stage) {

        singleMode = new Button();
        innerShadow = new InnerShadow();
        multiMode = new Button();
        innerShadow0 = new InnerShadow();
        playingOnline = new Button();
        innerShadow1 = new InnerShadow();
        imageView = new ImageView();
        reflection = new Reflection();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(414.0);
        setPrefWidth(717.0);

        singleMode.setId("singleMode");
        singleMode.setLayoutX(363.0);
        singleMode.setLayoutY(82.0);
        singleMode.setMnemonicParsing(false);
        singleMode.setPrefHeight(67.0);
        singleMode.setPrefWidth(251.0);
        singleMode.setText("Single Mode");
        singleMode.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        singleMode.setCursor(Cursor.HAND);

        singleMode.setEffect(innerShadow);
        singleMode.setCursor(Cursor.HAND);
        
        singleMode.setOnAction((ActionEvent event) -> {
            //PlayerNames
            stage.getScene().setRoot(new PlayerNames(stage, true));
        });
        
        multiMode.setId("multiMode");
        multiMode.setLayoutX(360.0);
        multiMode.setLayoutY(179.0);
        multiMode.setMnemonicParsing(false);
        multiMode.setPrefHeight(67.0);
        multiMode.setPrefWidth(251.0);
        multiMode.setText("Mutli Mode");
        multiMode.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        multiMode.setCursor(Cursor.HAND);

        multiMode.setEffect(innerShadow0);
        multiMode.setOnAction((ActionEvent event) -> {

            stage.getScene().setRoot(new PlayerNames(stage, false));

        });
        
        playingOnline.setId("playingOnline");
        playingOnline.setLayoutX(363.0);
        playingOnline.setLayoutY(276.0);
        playingOnline.setMnemonicParsing(false);
        playingOnline.setPrefHeight(67.0);
        playingOnline.setPrefWidth(251.0);
        playingOnline.setText("Playing Online");
        playingOnline.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playingOnline.setCursor(Cursor.HAND);

        playingOnline.setEffect(innerShadow1);
        playingOnline.setOnAction((ActionEvent event) -> {
            stage.getScene().setRoot(new Login(stage));
        });
        
        imageView.setFitHeight(177.0);
        imageView.setFitWidth(263.0);
        imageView.setLayoutX(96.0);
        imageView.setLayoutY(71.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setStyle("-fx-rotate: -20;");
        imageView.setImage(new Image(getClass().getResource("media/play.png").toExternalForm()));

        imageView.setEffect(reflection);

        button.setLayoutX(23.0);
        button.setLayoutY(357.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(33.0);
        button.setPrefWidth(92.0);
        button.setText("Back");
        button.setOnAction((ActionEvent event) -> {

            stage.getScene().setRoot(new StartGamePage(stage));

        });
        getChildren().add(singleMode);
        getChildren().add(multiMode);
        getChildren().add(playingOnline);
        getChildren().add(imageView);
        getChildren().add(button);

    }
}
