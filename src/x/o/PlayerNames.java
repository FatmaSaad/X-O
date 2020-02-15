package x.o;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
    

public  class PlayerNames extends AnchorPane {

    protected final ImageView imageView;
    protected final Button back;
    protected final Button start;
    protected final TextArea player3;
    protected final TextArea player1;
    protected final ImageView imageView0;
    protected final Label label;
    protected final CheckBox record;
    protected final Label pc;
    protected final Label label0;
    protected final Label label1;
    protected final RadioButton h1;
    protected final ToggleGroup tag;
    protected final RadioButton h11;
    protected final ToggleGroup group ;
      boolean flagXO ,flagRecord;

    public PlayerNames(Stage stage,boolean  flagmode) {
        
        group = new ToggleGroup();
        imageView = new ImageView();
        back = new Button();
        start = new Button();
        player3 = new TextArea();
        player1 = new TextArea();
        imageView0 = new ImageView();
        label = new Label();
        record = new CheckBox();
        pc = new Label();
        label0 = new Label();
        label1 = new Label();
        h1 = new RadioButton();
        tag = new ToggleGroup();
        h11 = new RadioButton();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(414.0);
        setPrefWidth(717.0);
        setStyle("-fx-background-color: white;");

        imageView.setFitHeight(112.0);
        imageView.setFitWidth(168.0);
        imageView.setLayoutX(136.0);
        imageView.setLayoutY(71.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("media/ff.png").toExternalForm()));

        back.setLayoutX(25.0);
        back.setLayoutY(337.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(38.0);
        back.setPrefWidth(112.0);
        back.setText("Back");
        back.setFont(new Font(24.0));
        
        back.setOnAction((ActionEvent event) -> {
            stage.getScene().setRoot(new PlayingModes(stage));
        });

        start.setLayoutX(298.0);
        start.setLayoutY(275.0);
        start.setMnemonicParsing(false);
        start.setPrefHeight(38.0);
        start.setPrefWidth(185.0);
        start.setText("Strat");
        start.setFont(new Font(24.0));

        player3.setLayoutX(88.0);
        player3.setLayoutY(222.0);
        player3.setPrefHeight(38.0);
        player3.setPrefWidth(200.0);
        player3.setPromptText("player2");

        player1.setLayoutX(477.0);
        player1.setLayoutY(217.0);
        player1.setPrefHeight(10.0);
        player1.setPrefWidth(200.0);
        player1.setPromptText("player 1");

        imageView0.setFitHeight(112.0);
        imageView0.setFitWidth(168.0);
        imageView0.setLayoutX(521.0);
        imageView0.setLayoutY(72.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("media/ff.png").toExternalForm()));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(305.0);
        label.setLayoutY(75.0);
        label.setPrefHeight(93.0);
        label.setPrefWidth(136.0);
        label.setText("VS");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#3700ff"));
        label.setFont(new Font(64.0));

        record.setLayoutX(305.0);
        record.setLayoutY(337.0);
        record.setMnemonicParsing(false);
        record.setText("Record Game");

        pc.setLayoutX(160.0);
        pc.setLayoutY(202.0);
        pc.setPrefHeight(79.0);
        pc.setPrefWidth(81.0);
        pc.setText("PC");
        pc.setTextFill(javafx.scene.paint.Color.valueOf("#0059ff"));
        pc.setVisible(false);
        pc.setFont(new Font(48.0));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setLayoutX(478.0);
        label0.setPrefHeight(93.0);
        label0.setPrefWidth(213.0);
        label0.setText("Player1");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#3700ff"));
        label0.setFont(new Font(36.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setLayoutX(72.0);
        label1.setPrefHeight(93.0);
        label1.setPrefWidth(230.0);
        label1.setText("Player2");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#3700ff"));
        label1.setFont(new Font(36.0));

      

                
        h1.setLayoutX(318.0);
        h1.setLayoutY(184.0);
        h1.setMnemonicParsing(false);
        h1.setPrefHeight(29.0);
        h1.setPrefWidth(90.0);
       h1.setText("Play By -->X");
        h1.setToggleGroup(group);
        h1.fire();
        

       h11.setFocusTraversable(true);
      h11.setLayoutX(318.0);
        h11.setLayoutY(207.0);
        h11.setMnemonicParsing(false);
       h11.setPrefHeight(29.0);
        h11.setPrefWidth(90.0);
        h11.setText("Play By -->O");
      h11.setToggleGroup(group);
        


        getChildren().add(imageView);
        getChildren().add(back);
        getChildren().add(start);
        getChildren().add(player3);
        getChildren().add(player1);
        getChildren().add(imageView0);
        getChildren().add(label);
        getChildren().add(record);
        getChildren().add(pc);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(h1);
        getChildren().add(h11);
        
        
        if(flagmode)
        {
            player3.setVisible(false);
            pc.setVisible(true);
        }
     
 
            start.setOnAction(new EventHandler<ActionEvent>() {
            @ Override
            public void handle(ActionEvent event) {
                 if(h1.isSelected())
       {
           flagXO=true;
           System.out.println("xxxxxxxxxx");
       }else  {
           flagXO=false;
           System.out.println("0000000000");
          
       }
        
                  String ply1=player1.getText();
           String ply2=player3.getText();
           if (record.isSelected())
           {
               flagRecord=true;
           }else flagRecord=false;
           if(flagmode)
           {
               stage.getScene().setRoot(new PlayGame(ply1,"Computer", flagXO,flagRecord, true, stage));
           }else
                stage.getScene().setRoot(new PlayGame(ply1,ply2, flagXO,flagRecord, false, stage));
          
           
            }
            
            });

    }
}
