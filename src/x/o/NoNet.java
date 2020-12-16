package x.o;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public  class NoNet extends AnchorPane {

    protected final ImageView imageView;
    protected final Button menu;
    protected final Button close;
    protected final ImageView imageView0;
    protected final Label label;

    public NoNet(Stage stage) {

        imageView = new ImageView();
        menu = new Button();
        close = new Button();
        imageView0 = new ImageView();
        label = new Label();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(509.0);
        setStyle("-fx-background-color: white;");

        imageView.setFitHeight(120.0);
        imageView.setFitWidth(242.0);
        imageView.setLayoutX(127.0);
        imageView.setLayoutY(177.0);
        imageView.setImage(new Image(getClass().getResource("media/nonet.jpg").toExternalForm()));

        menu.setLayoutX(35.0);
        menu.setLayoutY(315.0);
        menu.setMnemonicParsing(false);
        menu.setPrefHeight(35.0);
        menu.setPrefWidth(157.0);
        menu.setText("Go Menu");

        close.setLayoutX(274.0);
        close.setLayoutY(315.0);
        close.setMnemonicParsing(false);
        close.setPrefHeight(35.0);
        close.setPrefWidth(157.0);
        close.setText("Close");

        imageView0.setFitHeight(177.0);
        imageView0.setFitWidth(200.0);
        imageView0.setLayoutX(169.0);
        imageView0.setImage(new Image(getClass().getResource("media/nonet.gif").toExternalForm()));

        label.setLayoutX(295.0);
        label.setLayoutY(175.0);
        label.setPrefHeight(84.0);
        label.setPrefWidth(409.0);
        label.setStyle("-fx-rotate: 60;");
        label.setText("plz conect  !!");
        label.setFont(new Font("Berlin Sans FB Demi Bold", 64.0));

        getChildren().add(imageView);
        getChildren().add(menu);
        getChildren().add(close);
        getChildren().add(imageView0);
        getChildren().add(label);

        
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
                
            }
        });
        
        menu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.getScene().setRoot(new StartGamePage(stage));
            }
        });
            }
    }

/*
 stage.getScene().setRoot(new NoNet(stage));
                                  break;


*/