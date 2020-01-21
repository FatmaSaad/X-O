package x.o;

import java.io.DataInputStream;
import java.io.PrintStream;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OnlineBoard extends Pane {

    protected final ImageView imageXo;
    protected final Button btn1;
    protected final Button btn2;
    protected final Button btn3;
    protected final Button btn6;
    protected final Button btn5;
    protected final Button btn4;
    protected final Button btn7;
    protected final Button btn8;
    protected final Button btn9;
    protected final Label labelplayer2;
    protected final Label labelplayer1;
    protected final Label player1score;
    protected final Label player2score;
    protected final Button btnBack;
    protected final Button btnReplay;
    protected final Button btnRecord;
    int playRole;
    public String myPhone;
    public String oppositePhone;

    //Button[] buttons = new Button[9];
    //Button[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
    public OnlineBoard(int _playRole,Stage stage, PrintStream ps, DataInputStream dis, String phone, String phoneOther) {
        
        playRole = _playRole;
        myPhone = phone;
        oppositePhone = phoneOther;
        
        imageXo = new ImageView();
        btn1 = new Button();
        btn2 = new Button();
        btn3 = new Button();
        btn6 = new Button();
        btn5 = new Button();
        btn4 = new Button();
        btn7 = new Button();
        btn8 = new Button();
        btn9 = new Button();
        
        Button[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        
        labelplayer2 = new Label();
        labelplayer1 = new Label();
        player1score = new Label();
        player2score = new Label();
        btnBack = new Button();
        btnReplay = new Button();
        btnRecord = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(414.0);
        setPrefWidth(715.0);

        imageXo.setFitHeight(426.0);
        imageXo.setFitWidth(733.0);
        imageXo.setLayoutX(-8.0);
        imageXo.setLayoutY(-7.0);
        imageXo.setPickOnBounds(true);
        imageXo.setPreserveRatio(true);
        imageXo.setImage(new Image(getClass().getResource("media/backgroundImg.jpg").toExternalForm()));

        btn1.setLayoutX(155.0);
        btn1.setLayoutY(109.0);
        btn1.setMnemonicParsing(false);
        btn1.setPrefHeight(98.0);
        btn1.setPrefWidth(135.0);
        btn1.setStyle("-fx-background-color: none;");
        btn1.setTextFill(javafx.scene.paint.Color.WHITE);
        btn1.setCursor(Cursor.HAND);

        Platform.runLater(new Runnable(){
                @Override public void run() {
                    for(int i=1;i<=9;i++)
                        buttons[i].setText("");
                }
            });
        String playChar;
        if(playRole % 2 != 0)
            playChar = "X";
        else
            playChar = "O";
        
        //playRole % 2 != 0 ? playChar = "X" : playChar = "O";
      
        btn1.setOnAction((ActionEvent event) -> {
            
            if((btn1.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",1");
                btn1.setText(playChar);
            }
           // btn1.setDisable(true);
            playRole++;
        });
      
        btn2.setLayoutX(297.0);
        btn2.setLayoutY(109.0);
        btn2.setMnemonicParsing(false);
        btn2.setPrefHeight(98.0);
        btn2.setPrefWidth(120.0);
        btn2.setStyle("-fx-background-color: none;");
        btn2.setTextFill(javafx.scene.paint.Color.WHITE);
        btn2.setCursor(Cursor.HAND);
        
        btn2.setOnAction((ActionEvent event) -> {
            
            if((btn2.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",2");
                btn1.setText(playChar);
            }
           // btn1.setDisable(true);
            playRole++;
        });
        
        btn3.setLayoutX(431.0);
        btn3.setLayoutY(119.0);
        btn3.setMnemonicParsing(false);
        btn3.setPrefHeight(88.0);
        btn3.setPrefWidth(113.0);
        btn3.setStyle("-fx-background-color: none;");
        btn3.setTextFill(javafx.scene.paint.Color.WHITE);
        btn3.setCursor(Cursor.HAND);
        
        btn3.setOnAction((ActionEvent event) -> {
            
            if((btn3.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",3");
                btn1.setText(playChar);
            }
           // btn1.setDisable(true);
            playRole++;
        });
        
        btn6.setLayoutX(437.0);
        btn6.setLayoutY(215.0);
        btn6.setMnemonicParsing(false);
        btn6.setPrefHeight(98.0);
        btn6.setPrefWidth(113.0);
        btn6.setStyle("-fx-background-color: none;");
        btn6.setTextFill(javafx.scene.paint.Color.WHITE);
        btn6.setCursor(Cursor.HAND);
        
        btn6.setOnAction((ActionEvent event) -> {
            
            if((btn6.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",6");
                btn1.setText(playChar);
            }
           // btn1.setDisable(true);
            playRole++;
        });
        btn5.setLayoutX(303.0);
        btn5.setLayoutY(220.0);
        btn5.setMnemonicParsing(false);
        btn5.setPrefHeight(88.0);
        btn5.setPrefWidth(120.0);
        btn5.setStyle("-fx-background-color: none;");
        btn5.setTextFill(javafx.scene.paint.Color.WHITE);
        btn5.setCursor(Cursor.HAND);
        
        btn5.setOnAction((ActionEvent event) -> {
            
            if((btn5.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",5");
                btn1.setText(playChar);
            }
           // btn1.setDisable(true);
            playRole++;
        });
        
        btn4.setLayoutX(159.0);
        btn4.setLayoutY(220.0);
        btn4.setMnemonicParsing(false);
        btn4.setPrefHeight(88.0);
        btn4.setPrefWidth(135.0);
        btn4.setStyle("-fx-background-color: none;");
        btn4.setTextFill(javafx.scene.paint.Color.WHITE);
        btn4.setCursor(Cursor.HAND);
        
        btn4.setOnAction((ActionEvent event) -> {
            
            if((btn4.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",4");
                btn1.setText(playChar);
            }
           // btn1.setDisable(true);
            playRole++;
        });
        
        btn7.setLayoutX(168.0);
        btn7.setLayoutY(315.0);
        btn7.setMnemonicParsing(false);
        btn7.setPrefHeight(80.0);
        btn7.setPrefWidth(127.0);
        btn7.setStyle("-fx-background-color: none;");
        btn7.setTextFill(javafx.scene.paint.Color.WHITE);
        btn7.setCursor(Cursor.HAND);
        
        btn7.setOnAction((ActionEvent event) -> {
            
            if((btn7.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",7");
                btn1.setText(playChar);
            }
           // btn1.setDisable(true);
            playRole++;
        });
        
        
        btn8.setLayoutX(310.0);
        btn8.setLayoutY(315.0);
        btn8.setMnemonicParsing(false);
        btn8.setPrefHeight(80.0);
        btn8.setPrefWidth(113.0);
        btn8.setStyle("-fx-background-color: none;");
        btn8.setTextFill(javafx.scene.paint.Color.WHITE);
        btn8.setCursor(Cursor.HAND);
        
        btn8.setOnAction((ActionEvent event) -> {
            
            if((btn8.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",8");
                btn1.setText(playChar);
            }
           // btn1.setDisable(true);
            playRole++;
        });
        
        btn9.setLayoutX(441.0);
        btn9.setLayoutY(315.0);
        btn9.setMnemonicParsing(false);
        btn9.setPrefHeight(80.0);
        btn9.setPrefWidth(107.0);
        btn9.setStyle("-fx-background-color: none;");
        btn9.setTextFill(javafx.scene.paint.Color.WHITE);
        btn9.setCursor(Cursor.HAND);
        
        btn9.setOnAction((ActionEvent event) -> {
            
            if((btn9.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",9");
                btn1.setText(playChar);
            }
           // btn1.setDisable(true);
            playRole++;
        });
        
        labelplayer2.setAlignment(javafx.geometry.Pos.CENTER);
        labelplayer2.setLayoutX(509.0);
        labelplayer2.setLayoutY(11.0);
        labelplayer2.setPrefHeight(44.0);
        labelplayer2.setPrefWidth(127.0);
        labelplayer2.setText("player2");
        labelplayer2.setTextFill(javafx.scene.paint.Color.WHITE);
        labelplayer2.setFont(new Font("Bauhaus 93", 24.0));

        labelplayer1.setAlignment(javafx.geometry.Pos.CENTER);
        labelplayer1.setLayoutX(51.0);
        labelplayer1.setLayoutY(8.0);
        labelplayer1.setPrefHeight(44.0);
        labelplayer1.setPrefWidth(127.0);
        labelplayer1.setText("player1");
        labelplayer1.setTextFill(javafx.scene.paint.Color.WHITE);
        labelplayer1.setFont(new Font("Bauhaus 93", 24.0));

        player1score.setAlignment(javafx.geometry.Pos.CENTER);
        player1score.setLayoutX(92.0);
        player1score.setLayoutY(54.0);
        player1score.setPrefHeight(32.0);
        player1score.setPrefWidth(45.0);
        player1score.setStyle("-fx-background-color: ;");
        player1score.setText("0");
        player1score.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player1score.setTextFill(javafx.scene.paint.Color.WHITE);
        player1score.setFont(new Font("Bauhaus 93", 24.0));

        player2score.setAlignment(javafx.geometry.Pos.CENTER);
        player2score.setLayoutX(552.0);
        player2score.setLayoutY(53.0);
        player2score.setPrefHeight(32.0);
        player2score.setPrefWidth(45.0);
        player2score.setStyle("-fx-background-color: none;");
        player2score.setText("0");
        player2score.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player2score.setTextFill(javafx.scene.paint.Color.WHITE);
        player2score.setFont(new Font("Bauhaus 93", 24.0));

        btnBack.setLayoutX(32.0);
        btnBack.setLayoutY(345.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(53.0);
        btnBack.setPrefWidth(90.0);
        btnBack.setStyle("-fx-background-color: none; -fx-border-color: white;");
        btnBack.setText("Back");
        btnBack.setTextFill(javafx.scene.paint.Color.WHITE);
        btnBack.setFont(new Font("Bauhaus 93", 18.0));
        btnBack.setCursor(Cursor.HAND);

        btnReplay.setLayoutX(312.0);
        btnReplay.setLayoutY(26.0);
        btnReplay.setMnemonicParsing(false);
        btnReplay.setPrefHeight(53.0);
        btnReplay.setPrefWidth(90.0);
        btnReplay.setStyle("-fx-background-color: none; -fx-border-color: white;");
        btnReplay.setText("Replay");
        btnReplay.setTextFill(javafx.scene.paint.Color.WHITE);
        btnReplay.setFont(new Font("Bauhaus 93", 18.0));
        btnReplay.setCursor(Cursor.HAND);

        btnRecord.setLayoutX(600.0);
        btnRecord.setLayoutY(342.0);
        btnRecord.setMnemonicParsing(false);
        btnRecord.setPrefHeight(53.0);
        btnRecord.setPrefWidth(90.0);
        btnRecord.setStyle("-fx-background-color: none; -fx-border-color: white;");
        btnRecord.setText("Record");
        btnRecord.setTextFill(javafx.scene.paint.Color.WHITE);
        btnRecord.setFont(new Font("Bauhaus 93", 18.0));
        btnRecord.setCursor(Cursor.HAND);

        getChildren().add(imageXo);
        getChildren().add(btn1);
        getChildren().add(btn2);
        getChildren().add(btn3);
        getChildren().add(btn6);
        getChildren().add(btn5);
        getChildren().add(btn4);
        getChildren().add(btn7);
        getChildren().add(btn8);
        getChildren().add(btn9);
        getChildren().add(labelplayer2);
        getChildren().add(labelplayer1);
        getChildren().add(player1score);
        getChildren().add(player2score);
        getChildren().add(btnBack);
        getChildren().add(btnReplay);
        getChildren().add(btnRecord);
        
    }
    
     
    // Listen from stream..    
    public void playGameListen(int btnNumber ,String playChar)
        {
            switch(btnNumber)
            {
                case 1: 
                    System.out.println("recieved");
                    Platform.runLater(new Runnable(){
                        @Override public void run() {
                            btn1.setText(playChar);
                            btn1.setDisable(true);
                        }
                    });
                    
                    break;
                case 2: 
                    Platform.runLater(new Runnable(){
                        @Override public void run() {
                            btn2.setText(playChar);
                            btn2.setDisable(true);
                        }
                    });
                    break;
                case 3: 
                    Platform.runLater(new Runnable(){
                        @Override public void run() {
                            btn3.setText(playChar);
                            btn3.setDisable(true);
                        }
                    });
                    break;
                case 4: 
                    Platform.runLater(new Runnable(){
                        @Override public void run() {
                            btn4.setText(playChar);
                            btn4.setDisable(true);
                        }
                    });
                    break;
                case 5: 
                    Platform.runLater(new Runnable(){
                        @Override public void run() {
                            btn5.setText(playChar);
                            btn5.setDisable(true);
                        }
                    });
                    break;
                case 6: 
                    Platform.runLater(new Runnable(){
                        @Override public void run() {
                            btn6.setText(playChar);
                            btn6.setDisable(true);
                        }
                    });
                    break;
                case 7: 
                    Platform.runLater(new Runnable(){
                        @Override public void run() {
                            btn7.setText(playChar);
                            btn7.setDisable(true);
                        }
                    });
                    break;
                case 8: 
                    Platform.runLater(new Runnable(){
                        @Override public void run() {
                            btn8.setText(playChar);
                            btn8.setDisable(true);
                        }
                    });
                    break;
                case 9: 
                    Platform.runLater(new Runnable(){
                        @Override public void run() {
                            btn9.setText(playChar);
                            btn9.setDisable(true);
                        }
                    });
                    break;
            }
            
            playRole++;
        }
    
//    public void playGameSend(int btnNumber)
//    {
//        
//    
//    }
}
