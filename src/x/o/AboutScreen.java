package x.o;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AboutScreen extends Pane {

    protected final ImageView imageView;
    protected final ImageView hazemImg;
    protected final Label label;
    protected final ImageView imageView0;
    protected final Label label0;
    protected final ImageView imageView1;
    protected final Label label1;
    protected final ImageView imageView2;
    protected final Label label2;
    protected final Button button;

    public AboutScreen(Stage stage) {

        imageView = new ImageView();
        hazemImg = new ImageView();
        label = new Label();
        imageView0 = new ImageView();
        label0 = new Label();
        imageView1 = new ImageView();
        label1 = new Label();
        imageView2 = new ImageView();
        label2 = new Label();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(414.0);
        setPrefWidth(717.0);

        imageView.setFitHeight(388.0);
        imageView.setFitWidth(295.0);
        imageView.setLayoutX(208.0);
        imageView.setLayoutY(13.0);
        imageView.setOpacity(0.27);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setRotate(20.0);
        imageView.setImage(new Image(getClass().getResource("media/paneback.jpeg").toExternalForm()));

        hazemImg.setFitHeight(148.0);
        hazemImg.setFitWidth(118.0);
        hazemImg.setLayoutX(404.0);
        hazemImg.setLayoutY(12.0);
        hazemImg.setPickOnBounds(true);
        hazemImg.setPreserveRatio(true);
        hazemImg.setImage(new Image(getClass().getResource("media/hazem.jpeg").toExternalForm()));
        hazemImg.setCursor(Cursor.HAND);

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(500.0);
        label.setLayoutY(143.0);
        label.setPrefHeight(26.0);
        label.setPrefWidth(189.0);
        label.setText("Ahmed Hazem");
        label.setFont(new Font("Britannic Bold", 15.0));

        imageView0.setFitHeight(150.0);
        imageView0.setFitWidth(140.0);
        imageView0.setLayoutX(198.0);
        imageView0.setLayoutY(16.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("media/pp.jpg").toExternalForm()));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setLayoutX(49.0);
        label0.setLayoutY(160.0);
        label0.setPrefHeight(26.0);
        label0.setPrefWidth(189.0);
        label0.setText("Ashraf Amer");
        label0.setFont(new Font("Bauhaus 93", 15.0));

        imageView1.setFitHeight(133.0);
        imageView1.setFitWidth(118.0);
        imageView1.setLayoutX(396.0);
        imageView1.setLayoutY(187.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("media/nora.jpeg").toExternalForm()));

        label1.setLayoutX(514.0);
        label1.setLayoutY(303.0);
        label1.setPrefHeight(26.0);
        label1.setPrefWidth(189.0);
        label1.setText("Nourhan Ahmed Elshahat");
        label1.setFont(new Font("Bauhaus 93", 15.0));

        imageView2.setFitHeight(140.0);
        imageView2.setFitWidth(118.0);
        imageView2.setLayoutX(198.0);
        imageView2.setLayoutY(176.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("media/fatma.jpeg").toExternalForm()));

        label2.setLayoutX(77.0);
        label2.setLayoutY(316.0);
        label2.setPrefHeight(26.0);
        label2.setPrefWidth(146.0);
        label2.setText("Fatma Saad Rezk");
        label2.setFont(new Font("Bauhaus 93", 15.0));

        button.setLayoutX(36.0);
        button.setLayoutY(358.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(42.0);
        button.setPrefWidth(88.0);
        button.setStyle("-fx-background-color: none; -fx-border-color: black;");
        button.setText("Back");
        button.setFont(new Font("Bauhaus 93", 15.0));
        
         button.setOnAction((ActionEvent event) -> {

            stage.getScene().setRoot(new StartGamePage(stage));

        });

        getChildren().add(imageView);
        getChildren().add(hazemImg);
        getChildren().add(label);
        getChildren().add(imageView0);
        getChildren().add(label0);
        getChildren().add(imageView1);
        getChildren().add(label1);
        getChildren().add(imageView2);
        getChildren().add(label2);
        getChildren().add(button);

    }
}
