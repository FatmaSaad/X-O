package x.o;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    protected final MediaView mediaView;
    int playRole;
    public String myPhone;
    public String oppositePhone;
    Media winner;
    MediaPlayer winnerMedia;

    Media loser;
    MediaPlayer loserMedia;
    PrintStream ps;
    
    int myScore = 0, oppositeScore = 0;
    
    String record = "false,";
    boolean flagRec = false;
    //Button[] buttons = new Button[9];
    //Button[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
    public OnlineBoard(int _playRole,Stage stage, PrintStream _ps, DataInputStream dis, String phone, String phoneOther) {
        
        playRole = _playRole;
        myPhone = phone;
        oppositePhone = phoneOther;
        ps = _ps;
        
        winner = new Media(new File(System.getProperty("user.dir") + "\\src\\x\\o\\media\\winner.mp4").toURI().toString());
        winnerMedia = new MediaPlayer(winner);
        loser = new Media(new File(System.getProperty("user.dir") + "\\src\\x\\o\\media\\loser.mp4").toURI().toString());
        loserMedia = new MediaPlayer(loser);


        mediaView = new MediaView();
        mediaView.setFitHeight(350);
        mediaView.setFitWidth(650);
        mediaView.setLayoutX(25);
        mediaView.setLayoutY(25);
        
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
        
//        Button[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        
        labelplayer2 = new Label();
        labelplayer1 = new Label();
        player1score = new Label();
        player2score = new Label();
        btnBack = new Button();
        btnReplay = new Button();
        btnRecord = new Button();
        
        btnRecord.setOnAction((ActionEvent event) -> {
            
            record = "true,";
            flagRec = true;
            
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    btnRecord.setDisable(true);
                    btnRecord.setText("Recording...");
                    System.out.println("Start Recording");
                }
            });            
        });

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(350.0);
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
        btn1.setStyle("-fx-background-color: none; -fx-font-size:28px;");
        btn1.setTextFill(javafx.scene.paint.Color.WHITE);
        btn1.setCursor(Cursor.HAND);
        btn1.setText("");
        
        String playChar;
        boolean myTurn;
        if(playRole % 2 != 0)
        {
            playChar = "X";
        }
        else
        {
            playChar = "O";
        }
        
        //playRole % 2 != 0 ? playChar = "X" : playChar = "O";
      
        btn1.setOnAction((ActionEvent event) -> {
            
            if((btn1.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",1");
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        btn1.setText(playChar);
                        btn1.setDisable(true);
                        btnRecord.setDisable(true);
                        record += "1,";
                        setDisabled(true);
                        checkWinner();
                    }
                });
                
            }
           // btn1.setDisable(true);
            
        });
      
        btn2.setLayoutX(297.0);
        btn2.setLayoutY(109.0);
        btn2.setMnemonicParsing(false);
        btn2.setPrefHeight(98.0);
        btn2.setPrefWidth(120.0);
        btn2.setStyle("-fx-background-color: none;  -fx-font-size:28px;");
        btn2.setTextFill(javafx.scene.paint.Color.WHITE);
        btn2.setCursor(Cursor.HAND);
        btn2.setText("");
        
        btn2.setOnAction((ActionEvent event) -> {
            
            if((btn2.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",2");
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        btn2.setText(playChar);
                        btn2.setDisable(true);
                        btnRecord.setDisable(true);
                        record += "2,";
                        setDisabled(true);
                        checkWinner();
                    }
                });
            }
           // btn1.setDisable(true);
            
        });
        
        btn3.setLayoutX(431.0);
        btn3.setLayoutY(119.0);
        btn3.setMnemonicParsing(false);
        btn3.setPrefHeight(88.0);
        btn3.setPrefWidth(113.0);
        btn3.setStyle("-fx-background-color: none; -fx-font-size:28px;");
        btn3.setTextFill(javafx.scene.paint.Color.WHITE);
        btn3.setCursor(Cursor.HAND);
        btn3.setText("");
        
        btn3.setOnAction((ActionEvent event) -> {
            
            if((btn3.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",3");
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        btn3.setText(playChar);
                        btn3.setDisable(true);
                        btnRecord.setDisable(true);
                        record += "3,";
                        setDisabled(true);
                        checkWinner();
                    }
                });
            }
           // btn1.setDisable(true);
            
        });
        
        btn6.setLayoutX(437.0);
        btn6.setLayoutY(215.0);
        btn6.setMnemonicParsing(false);
        btn6.setPrefHeight(98.0);
        btn6.setPrefWidth(113.0);
        btn6.setStyle("-fx-background-color: none; -fx-font-size:28px;");
        btn6.setTextFill(javafx.scene.paint.Color.WHITE);
        btn6.setCursor(Cursor.HAND);
        btn6.setText("");
        
        btn6.setOnAction((ActionEvent event) -> {
            
            if((btn6.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",6");
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        btn6.setText(playChar);
                        btn6.setDisable(true);
                        btnRecord.setDisable(true);
                        record += "6,";
                        setDisabled(true);
                        checkWinner();
                    }
                });
            }
           // btn1.setDisable(true);
            
        });
        btn5.setLayoutX(303.0);
        btn5.setLayoutY(220.0);
        btn5.setMnemonicParsing(false);
        btn5.setPrefHeight(88.0);
        btn5.setPrefWidth(120.0);
        btn5.setStyle("-fx-background-color: none; -fx-font-size:28px;");
        btn5.setTextFill(javafx.scene.paint.Color.WHITE);
        btn5.setCursor(Cursor.HAND);
        btn5.setText("");
        
        btn5.setOnAction((ActionEvent event) -> {
            
            if((btn5.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",5");
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        btn5.setText(playChar);
                        btn5.setDisable(true);
                        btnRecord.setDisable(true);
                        record += "5,";
                        setDisabled(true);
                        checkWinner();
                    }
                });
            }
           // btn1.setDisable(true);
            
        });
        
        btn4.setLayoutX(159.0);
        btn4.setLayoutY(220.0);
        btn4.setMnemonicParsing(false);
        btn4.setPrefHeight(88.0);
        btn4.setPrefWidth(135.0);
        btn4.setStyle("-fx-background-color: none; -fx-font-size:28px;");
        btn4.setTextFill(javafx.scene.paint.Color.WHITE);
        btn4.setCursor(Cursor.HAND);
        btn4.setText("");
        
        btn4.setOnAction((ActionEvent event) -> {
            
            if((btn4.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",4");
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        btn4.setText(playChar);
                        btn4.setDisable(true);
                        btnRecord.setDisable(true);
                        record += "4,";
                        setDisabled(true);
                        checkWinner();
                    }
                });
            }
           // btn1.setDisable(true);
            
        });
        
        btn7.setLayoutX(168.0);
        btn7.setLayoutY(315.0);
        btn7.setMnemonicParsing(false);
        btn7.setPrefHeight(80.0);
        btn7.setPrefWidth(127.0);
        btn7.setStyle("-fx-background-color: none; -fx-font-size:28px;");
        btn7.setTextFill(javafx.scene.paint.Color.WHITE);
        btn7.setCursor(Cursor.HAND);
        btn7.setText("");
        
        btn7.setOnAction((ActionEvent event) -> {
            
            if((btn7.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",7");
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        btn7.setText(playChar);
                        btn7.setDisable(true);
                        btnRecord.setDisable(true);
                        record += "7,";
                        setDisabled(true);
                        checkWinner();
                    }
                });
            }
           // btn1.setDisable(true);
            
        });
        
        
        btn8.setLayoutX(310.0);
        btn8.setLayoutY(315.0);
        btn8.setMnemonicParsing(false);
        btn8.setPrefHeight(80.0);
        btn8.setPrefWidth(113.0);
        btn8.setStyle("-fx-background-color: none; -fx-font-size:28px;");
        btn8.setTextFill(javafx.scene.paint.Color.WHITE);
        btn8.setCursor(Cursor.HAND);
        btn8.setText("");
        
        btn8.setOnAction((ActionEvent event) -> {
            
            if((btn8.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",8");
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        btn8.setText(playChar);
                        btn8.setDisable(true);
                        btnRecord.setDisable(true);
                        record += "8,";
                        setDisabled(true);
                        checkWinner();
                    }
                });
            }
           // btn1.setDisable(true);
            
        });
        
        btn9.setLayoutX(441.0);
        btn9.setLayoutY(315.0);
        btn9.setMnemonicParsing(false);
        btn9.setPrefHeight(80.0);
        btn9.setPrefWidth(107.0);
        btn9.setStyle("-fx-background-color: none; -fx-font-size:28px;");
        btn9.setTextFill(javafx.scene.paint.Color.WHITE);
        btn9.setCursor(Cursor.HAND);
        btn9.setText("");
        
        btn9.setOnAction((ActionEvent event) -> {
            
            if((btn9.getText()).compareTo("") == 0)
            {
                System.out.println("sended");
                ps.println("playing," + myPhone + "," + phoneOther + "," + playChar + ",9");
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        btn9.setText(playChar);
                        btn9.setDisable(true);
                        btnRecord.setDisable(true);
                        record += "9,";
                        setDisabled(true);
                        checkWinner();
                    }
                });
                
            }
           // btn1.setDisable(true);
            
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
        
        btnBack.setOnAction((ActionEvent event) -> {
            //stage.getScene().setRoot(new PlayingModes(stage));
            mediaView.setVisible(false);
            winnerMedia.setAutoPlay(false);
            winnerMedia.stop();
            loserMedia.setAutoPlay(false);
            loserMedia.stop();
        });

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

        btnReplay.setOnAction((ActionEvent event) -> {
            ps.println("replayGame," + myPhone + "," + phoneOther);            
        });
        
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
        getChildren().add(mediaView);
        mediaView.setVisible(false);
        winnerMedia.setAutoPlay(false);
        winnerMedia.stop();
        loserMedia.setAutoPlay(false);
        loserMedia.stop();
        
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
                        record += "1,";
                        setDisabled(false);
                    }
                });

                break;
            case 2: 
                Platform.runLater(new Runnable(){
                    @Override public void run() {
                        btn2.setText(playChar);
                        btn2.setDisable(true);
                        record += "2,";
                        setDisabled(false);
                    }
                });
                break;
            case 3: 
                Platform.runLater(new Runnable(){
                    @Override public void run() {
                        btn3.setText(playChar);
                        btn3.setDisable(true);
                        record += "3,";
                        setDisabled(false);
                    }
                });
                break;
            case 4: 
                Platform.runLater(new Runnable(){
                    @Override public void run() {
                        btn4.setText(playChar);
                        btn4.setDisable(true);
                        record += "4,";
                        setDisabled(false);
                    }
                });
                break;
            case 5: 
                Platform.runLater(new Runnable(){
                    @Override public void run() {
                        btn5.setText(playChar);
                        btn5.setDisable(true);
                        record += "5,";
                        setDisabled(false);
                    }
                });
                break;
            case 6: 
                Platform.runLater(new Runnable(){
                    @Override public void run() {
                        btn6.setText(playChar);
                        btn6.setDisable(true);
                        record += "6,";
                        setDisabled(false);
                    }
                });
                break;
            case 7: 
                Platform.runLater(new Runnable(){
                    @Override public void run() {
                        btn7.setText(playChar);
                        btn7.setDisable(true);
                        record += "7,";
                        setDisabled(false);
                    }
                });
                break;
            case 8: 
                Platform.runLater(new Runnable(){
                    @Override public void run() {
                        btn8.setText(playChar);
                        btn8.setDisable(true);
                        record += "8,";
                        setDisabled(false);
                    }
                });
                break;
            case 9: 
                Platform.runLater(new Runnable(){
                    @Override public void run() {
                        btn9.setText(playChar);
                        btn9.setDisable(true);
                        record += "9,";
                        setDisabled(false);
                    }
                });
                break;
        }
        
        checkWinner();

        
    }
    
    
    public void checkWinner()
    {
        if(
            (btn1.getText()).compareTo(btn2.getText()) == 0 && (btn1.getText()).compareTo(btn3.getText()) == 0 && (btn1.getText()).compareTo("") != 0 || //1,2,3
            (btn1.getText()).compareTo(btn5.getText()) == 0 && (btn1.getText()).compareTo(btn9.getText()) == 0 && (btn1.getText()).compareTo("") != 0 || //1,5,9
            (btn1.getText()).compareTo(btn4.getText()) == 0 && (btn1.getText()).compareTo(btn7.getText()) == 0 && (btn1.getText()).compareTo("") != 0 || //1,4,7
            (btn2.getText()).compareTo(btn5.getText()) == 0 && (btn2.getText()).compareTo(btn8.getText()) == 0 && (btn2.getText()).compareTo("") != 0 || //2,5,8
            (btn3.getText()).compareTo(btn5.getText()) == 0 && (btn3.getText()).compareTo(btn7.getText()) == 0 && (btn3.getText()).compareTo("") != 0 || //3,5,7
            (btn3.getText()).compareTo(btn6.getText()) == 0 && (btn3.getText()).compareTo(btn9.getText()) == 0 && (btn3.getText()).compareTo("") != 0 || //3,6,9
            (btn4.getText()).compareTo(btn5.getText()) == 0 && (btn4.getText()).compareTo(btn6.getText()) == 0 && (btn4.getText()).compareTo("") != 0 || //4,5,6
            (btn7.getText()).compareTo(btn8.getText()) == 0 && (btn7.getText()).compareTo(btn9.getText()) == 0 && (btn7.getText()).compareTo("") != 0 //7,8,9
          )
        {
            System.out.println("Winner");
            ps.println("winner," + myPhone + "," + oppositePhone );
            if(flagRec == true)
            {
                Date date = new Date();
                String dat = date.getTime() + ".txt";
                System.out.println(dat);
                File file = new File(dat);

                try
                {
                    file.createNewFile();
                } 
                catch (IOException ex) {
                    Logger.getLogger(OnlineBoard.class.getName()).log(Level.SEVERE, null, ex);
                }

                try 
                {
                    FileOutputStream save = new FileOutputStream(dat);
                    DataOutputStream dos = new DataOutputStream(save);
                    dos.writeUTF(record);
                    dos.close();
                    System.out.println("Recorded");
                    try
                    {
                        String pathes = dat + ",";
                        Files.write(Paths.get("record.txt"), pathes.getBytes(), StandardOpenOption.APPEND);
                    } 
                    catch (IOException e) {
                        System.err.println("file not found");
                    }

                }
                catch (FileNotFoundException ex) {
                    Logger.getLogger(OnlineBoard.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (IOException ex) {
                    Logger.getLogger(OnlineBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        setDisabled(false);
    }
    
    public void playWinnerVideo()
    {
        mediaView.setMediaPlayer(winnerMedia);
        mediaView.setVisible(true);
        winnerMedia.setAutoPlay(true);
        System.out.println("Winner Video play");
        setDisabled(false);
    }

    public void playLoserVideo()
    {
        mediaView.setMediaPlayer(loserMedia);
        mediaView.setVisible(true);
        loserMedia.setAutoPlay(true);
        System.out.println("Loser Video play");
        setDisabled(false);
    }
    
    public void setNames(String name, String opposite)
    {
        Platform.runLater(new Runnable(){
            @Override public void run() {
                labelplayer1.setText(name);
                labelplayer2.setText(opposite);
            }
        });
    }
    
    public void replayGame()
    {
        Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    btn1.setText("");
                    btn2.setText("");
                    btn3.setText("");
                    btn4.setText("");
                    btn5.setText("");
                    btn6.setText("");
                    btn7.setText("");
                    btn8.setText("");
                    btn9.setText("");
                }
            });
    }
    
    public void setMyScore(int _myScore)
    {
        myScore = _myScore;
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                player1score.setText("" + myScore);
            }
        });
    }
    
    public void setOppositeScore(int _oppositeScore)
    {
        oppositeScore = _oppositeScore;
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                player2score.setText("" + oppositeScore);
            }
        });
    }
    
    public int getMyScore()
    {
        return myScore;
    }
    
    public int getOppositeScore()
    {
        return oppositeScore;
    }
}
