package x.o;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StartGamePage extends Pane {

    protected final ImageView imageView;
    protected final Reflection reflection;
    protected final Button playNow;
    protected final InnerShadow innerShadow;
    protected final Button records;
    protected final InnerShadow innerShadow0;
    protected final Button aboutUs;
    protected final InnerShadow innerShadow1;
    protected final Button exit;
    protected final InnerShadow innerShadow2;

    public StartGamePage(Stage stage) {

        imageView = new ImageView();
        reflection = new Reflection();
        playNow = new Button();
        innerShadow = new InnerShadow();
        records = new Button();
        innerShadow0 = new InnerShadow();
        aboutUs = new Button();
        innerShadow1 = new InnerShadow();
        exit = new Button();
        innerShadow2 = new InnerShadow();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(414.0);
        setPrefWidth(717.0);

        imageView.setFitHeight(190.0);
        imageView.setFitWidth(162.0);
        imageView.setLayoutX(44.0);
        imageView.setLayoutY(34.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setStyle("-fx-rotate: -25;");
        imageView.setImage(new Image(getClass().getResource("media/paneback.jpeg").toExternalForm()));

        imageView.setEffect(reflection);

        playNow.setLayoutX(405.0);
        playNow.setLayoutY(58.0);
        playNow.setMnemonicParsing(false);
        playNow.setPrefHeight(55.0);
        playNow.setPrefWidth(236.0);
        playNow.setText("Play Now");

        //innerShadow.setColor(javafx.scene.paint.Color.#5b4848);
        innerShadow.setHeight(39.66);
        innerShadow.setRadius(20.884999999999998);
        innerShadow.setWidth(45.88);
        playNow.setEffect(innerShadow);
        
        playNow.setOnAction((ActionEvent event) -> {

            stage.getScene().setRoot(new PlayingModes(stage));

        });

        records.setLayoutX(404.0);
        records.setLayoutY(139.0);
        records.setMnemonicParsing(false);
        records.setPrefHeight(55.0);
        records.setPrefWidth(236.0);
        records.setText("Records");

        //innerShadow0.setColor(javafx.scene.paint.Color.#5b4848);
        innerShadow0.setHeight(39.66);
        innerShadow0.setRadius(20.884999999999998);
        innerShadow0.setWidth(45.88);
        records.setEffect(innerShadow0);
        
        records.setOnAction((ActionEvent event) -> {
            stage.getScene().setRoot(new RecordGames(stage));
        });

        aboutUs.setLayoutX(405.0);
        aboutUs.setLayoutY(217.0);
        aboutUs.setMnemonicParsing(false);
        aboutUs.setPrefHeight(55.0);
        aboutUs.setPrefWidth(236.0);
        aboutUs.setText("About Us");
        
        aboutUs.setOnAction((ActionEvent event) -> {
            stage.getScene().setRoot(new AboutScreen(stage));
        });

        //innerShadow1.setColor(javafx.scene.paint.Color.#5b4848);
        innerShadow1.setHeight(39.66);
        innerShadow1.setRadius(20.884999999999998);
        innerShadow1.setWidth(45.88);
        aboutUs.setEffect(innerShadow1);

        exit.setLayoutX(404.0);
        exit.setLayoutY(294.0);
        exit.setMnemonicParsing(false);
        exit.setPrefHeight(55.0);
        exit.setPrefWidth(236.0);
        exit.setText("Exit");
        exit.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });

        //innerShadow2.setColor(javafx.scene.paint.Color.#5b4848);
        innerShadow2.setHeight(39.66);
        innerShadow2.setRadius(20.884999999999998);
        innerShadow2.setWidth(45.88);
        exit.setEffect(innerShadow2);

        getChildren().add(imageView);
        getChildren().add(playNow);
        getChildren().add(records);
        getChildren().add(aboutUs);
        getChildren().add(exit);
        stage.setResizable(false);
    }
}
