package x.o;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ReplayRecord extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView1;
    protected final Label label;
    protected final Label label0;
    protected final Label player2name;
    protected final Label player1name;
    protected final Label win2;
    protected final Label win1;
    protected final Button[] p = new Button[9];

    protected final Button button;
    protected final Line linex1;
    protected final Line linex2;
    protected final Line line1;
    protected final Line line2;
    protected final Line line3;
    protected final Line linev1;
    protected final Line linev2;
    protected final Line linev3;
    protected final Button button0;
  protected final Button button2;

    protected final MediaView mediaView;

    
    /**
     *declaration variable wich needed in function but declared here
     * to be visual by all function in the class TwoPlayr.java 
     * first for  score1,2 for assigning the score of first player and second player 
     * lable wich visualed in the heighst of gui board of x,o game\
     * and the flag one for making swaping between user whch play with x mode or O mode 
     * if user chose true the user play with x value other casrr play with o value
     * flagplayer used to score the value of flag to the owner
     * and save it in all game but it is used in check winnner to know who final winner 
     * instead the flag wich changed from game turn to another
     * 
     * STRING {AA} string aa which recive the string value of the button text
     * to check the state of winner using function of checkwinner()
     * 
     * String record used to record all actions done over buttons to 
     * recieve it it also declared in every button and make an contanetane with delimetr 
     * 
     * media for media declarate video effect
     * 
     */
    int score1;
    int score2;
    boolean flag = true;

    boolean flagplayer;
    String mm = "";
   

    String[][] aa = {
        {"", "", ""},
        {"", "", ""},
        {"", "", ""}
    };

    String record = flag + ",";
    Media media;
    MediaPlayer mediaPlayer;

    Media media2;
    MediaPlayer mediaPlayer2;
    int count =1;
String fullpath;
    /**
     * 
     * @param s1
     * s1 for get the strin g of name fo first player that passes from login page
     * 
     * @param s2
     * s1 for get the strin g of name fo second  player that passes from login page
     * @param sc1
     * s1 for get the integer  g of score  for first player that passes from login page
     * @param sc2 
     *      * s1 for get the integer  g of score  for second  player that passes from login page

     */
    public ReplayRecord (String s1,String s2,boolean flagplayerR,String _fullpath) {

        media = new Media(new File("E:\\I.T.I\\LastVersion\\src\\x\\o\\media\\winner.mp4").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        media2 = new Media(new File("E:\\I.T.I\\LastVersion\\src\\x\\o\\media\\winner.mp4").toURI().toString());
        mediaPlayer2 = new MediaPlayer(media2);

        score1 = 0;
        score2 = 0;
          
        mediaView = new MediaView();
        mediaView.setFitHeight(420.0);
        mediaView.setFitWidth(400.0);
        mediaView.setLayoutX(180.0);
        mediaView.setLayoutY(100.0);

        imageView = new ImageView();
        
        imageView1 = new ImageView();
        label = new Label();
        label0 = new Label();
        player2name = new Label();
        player1name = new Label();
        win2 = new Label();
        win1 = new Label();
        p[0] = new Button();
        p[3] = new Button();
        p[2] = new Button();
        p[1] = new Button();
        p[5] = new Button();
        p[4] = new Button();
        p[6] = new Button();
        p[8] = new Button();
        p[7] = new Button();
        button = new Button();
        button2 = new Button();
        linex1 = new Line();
        linex2 = new Line();
        line1 = new Line();
        line2 = new Line();
        line3 = new Line();
        linev1 = new Line();
        linev2 = new Line();
        linev3 = new Line();
        button0 = new Button();

        setId("AnchorPane");
        setPrefHeight(200);
        setPrefWidth(320);

          imageView1.setFitHeight(477.0);
        imageView1.setFitWidth(741.0);
        imageView1.setLayoutX(-17.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        
        imageView.setFitHeight(477.0);
        imageView.setFitWidth(741.0);
        imageView.setLayoutX(-17.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("nn.gif").toExternalForm()));

        label.setLayoutX(374.0);
        label.setLayoutY(44.0);
        label.setPrefHeight(52.0);
        label.setPrefWidth(238.0);
        label.setStyle("-fx-alignment: center; -fx-background-color: #5d6bbb; -fx-font-size: 30; -fx-background-radius: 50;");
        label.setText("Player One");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#d5ff02"));

        label0.setLayoutX(44.0);
        label0.setLayoutY(44.0);
        label0.setPrefHeight(52.0);
        label0.setPrefWidth(228.0);
        label0.setStyle("-fx-alignment: center; -fx-background-color: #5d6bbb; -fx-font-size: 35; -fx-background-radius: 20;");
        label0.setText("Player Two");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#c3ff00"));

        player2name.setLayoutX(46.0);
        player2name.setLayoutY(95.0);
        player2name.setPrefHeight(0.0);
        player2name.setPrefWidth(228.0);
        player2name.setStyle("-fx-alignment: center; -fx-font-size: 35;");
        player2name.setText("yomna");
        player2name.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player2name.setTextFill(javafx.scene.paint.Color.WHITE);

        player1name.setLayoutX(374.0);
        player1name.setLayoutY(95.0);
        player1name.setPrefHeight(52.0);
        player1name.setPrefWidth(228.0);
        player1name.setStyle("-fx-alignment: center; -fx-font-size: 35;");
        player1name.setText("ahmed");
        player1name.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player1name.setTextFill(javafx.scene.paint.Color.WHITE);

        win2.setAlignment(javafx.geometry.Pos.BASELINE_CENTER);
        win2.setLayoutX(274.0);
        win2.setLayoutY(84.0);
        win2.setPrefHeight(36.0);
        win2.setPrefWidth(28.0);
        win2.setStyle("-fx-font-size: 50;");
        win2.setText(String.valueOf(score2));
        win2.setTextFill(javafx.scene.paint.Color.WHITE);

        win1.setAlignment(javafx.geometry.Pos.BASELINE_CENTER);
        win1.setLayoutX(339.0);
        win1.setLayoutY(84.0);
        win1.setPrefHeight(36.0);
        win1.setPrefWidth(28.0);
        win1.setStyle("-fx-font-size: 50;");
        win1.setText(String.valueOf(score1));
        win1.setTextFill(javafx.scene.paint.Color.WHITE);

        p[0].setLayoutX(187.0);
        p[0].setLayoutY(157.0);
        p[0].setMnemonicParsing(false);
        p[0].setPrefHeight(85.0);
        p[0].setPrefWidth(85.0);
        p[0].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25; -fx-background-color: rgba(0,0,0,.5); -fx-border-color: white; -fx-border-radius: 50;");
        p[0].setTextFill(javafx.scene.paint.Color.WHITE);

        p[3].setLayoutX(187.0);
        p[3].setLayoutY(242.0);
        p[3].setMnemonicParsing(false);
        p[3].setPrefHeight(85.0);
        p[3].setPrefWidth(85.0);
        p[3].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25; -fx-background-color: rgba(0,0,0,.5); -fx-border-color: white; -fx-border-radius: 50;");
        p[3].setTextFill(javafx.scene.paint.Color.WHITE);

        p[2].setLayoutX(386.0);
        p[2].setLayoutY(157.0);
        p[2].setMnemonicParsing(false);
        p[2].setPrefHeight(85.0);
        p[2].setPrefWidth(85.0);
        p[2].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25; -fx-background-color: rgba(0,0,0,.5); -fx-border-color: white; -fx-border-radius: 50;");
        p[2].setTextFill(javafx.scene.paint.Color.WHITE);

        p[1].setLayoutX(289.0);
        p[1].setLayoutY(157.0);
        p[1].setMnemonicParsing(false);
        p[1].setPrefHeight(85.0);
        p[1].setPrefWidth(85.0);
        p[1].setStyle("-fx-font-family: Papyrus; -fx-font-size: 30; -fx-background-color: rgba(0,0,0,.6); -fx-border-color: white; -fx-border-radius: 50;");
        p[1].setTextFill(javafx.scene.paint.Color.WHITE);

        p[5].setLayoutX(386.0);
        p[5].setLayoutY(242.0);
        p[5].setMnemonicParsing(false);
        p[5].setPrefHeight(85.0);
        p[5].setPrefWidth(85.0);
        p[5].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25; -fx-background-color: rgba(0,0,0,.5); -fx-border-color: white; -fx-border-radius: 50;");
        p[5].setTextFill(javafx.scene.paint.Color.WHITE);

        p[4].setLayoutX(289.0);
        p[4].setLayoutY(242.0);
        p[4].setMnemonicParsing(false);
        p[4].setPrefHeight(85.0);
        p[4].setPrefWidth(85.0);
        p[4].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25; -fx-background-color: rgba(0,0,0,.5); -fx-border-color: white; -fx-border-radius: 50;");
        p[4].setTextFill(javafx.scene.paint.Color.WHITE);

        p[6].setLayoutX(187.0);
        p[6].setLayoutY(327.0);
        p[6].setMnemonicParsing(false);
        p[6].setPrefHeight(85.0);
        p[6].setPrefWidth(85.0);
        p[6].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25; -fx-background-color: rgba(0,0,0,.5); -fx-border-color: white; -fx-border-radius: 50;");
        p[6].setTextFill(javafx.scene.paint.Color.WHITE);

        p[8].setLayoutX(386.0);
        p[8].setLayoutY(327.0);
        p[8].setMnemonicParsing(false);
        p[8].setPrefHeight(85.0);
        p[8].setPrefWidth(85.0);
        p[8].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25; -fx-background-color: rgba(0,0,0,.5); -fx-border-color: white; -fx-border-radius: 50;");
        p[8].setTextFill(javafx.scene.paint.Color.WHITE);

        p[7].setLayoutX(288.0);
        p[7].setLayoutY(327.0);
        p[7].setMnemonicParsing(false);
        p[7].setPrefHeight(85.0);
        p[7].setPrefWidth(85.0);
        p[7].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25; -fx-background-color: rgba(0,0,0,.5); -fx-border-color: white; -fx-border-radius: 50;");
        p[7].setTextFill(javafx.scene.paint.Color.WHITE);

        button.setLayoutX(573.0);
        button.setLayoutY(343.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(66.0);
        button.setPrefWidth(78.0);
        button.setStyle("-fx-border-color: white; -fx-background-color: rgba(0,0,0,0); -fx-border-width: 8; -fx-border-radius: 50;");
        button.setText("Backll");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#c6ff0c"));
        button.setVisible(true);
        
        linex1.setEndX(356.0);
        linex1.setEndY(-45.0);
        linex1.setLayoutX(104.0);
        linex1.setLayoutY(212.0);
        linex1.setStartX(94.0);
        linex1.setStartY(189.0);
        linex1.setStroke(javafx.scene.paint.Color.valueOf("#e8ff00"));
        linex1.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        linex1.setStrokeWidth(15.0);
        linex1.setVisible(false);

        linex2.setDisable(true);
        linex2.setEndX(344.0);
        linex2.setEndY(180.0);
        linex2.setLayoutX(114.0);
        linex2.setLayoutY(222.0);
        linex2.setStartX(83.0);
        linex2.setStartY(-54.0);
        linex2.setStroke(javafx.scene.paint.Color.valueOf("#eef00e"));
        linex2.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        linex2.setStrokeWidth(15.0);
        linex2.setVisible(false);

        line1.setEndX(342.0);
        line1.setEndY(-24.0);
        line1.setLayoutX(114.0);
        line1.setLayoutY(222.0);
        line1.setStartX(85.0);
        line1.setStartY(-24.0);
        line1.setStroke(javafx.scene.paint.Color.valueOf("#dfee0a"));
        line1.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        line1.setStrokeWidth(15.0);
        line1.setVisible(false);

        line2.setEndX(332.0);
        line2.setEndY(55.0);
        line2.setLayoutX(124.0);
        line2.setLayoutY(232.0);
        line2.setStartX(76.0);
        line2.setStartY(55.0);
        line2.setStroke(javafx.scene.paint.Color.valueOf("#d5ff05"));
        line2.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        line2.setStrokeWidth(15.0);
        line2.setVisible(false);

        line3.setEndX(326.0);
        line3.setEndY(126.0);
        line3.setLayoutX(134.0);
        line3.setLayoutY(242.0);
        line3.setStartX(68.0);
        line3.setStartY(126.0);
        line3.setStroke(javafx.scene.paint.Color.valueOf("#f2ff00"));
        line3.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        line3.setStrokeWidth(15.0);
        line3.setVisible(false);

        linev1.setEndX(100.0);
        linev1.setEndY(162.0);
        linev1.setLayoutX(134.0);
        linev1.setLayoutY(242.0);
        linev1.setStartX(100.0);
        linev1.setStartY(-77.0);
        linev1.setStroke(javafx.scene.paint.Color.valueOf("#eeff00"));
        linev1.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        linev1.setStrokeWidth(15.0);
        linev1.setVisible(false);

        linev2.setEndX(187.0);
        linev2.setEndY(149.0);
        linev2.setLayoutX(144.0);
        linev2.setLayoutY(252.0);
        linev2.setStartX(187.0);
        linev2.setStartY(-86.0);
        linev2.setStroke(javafx.scene.paint.Color.valueOf("#eef200"));
        linev2.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        linev2.setStrokeWidth(15.0);
        linev2.setVisible(false);

        linev3.setEndX(287.0);
        linev3.setEndY(154.0);
        linev3.setLayoutX(144.0);
        linev3.setLayoutY(252.0);
        linev3.setStartX(287.0);
        linev3.setStartY(-86.0);
        linev3.setStroke(javafx.scene.paint.Color.valueOf("#e3fc01"));
        linev3.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        linev3.setStrokeWidth(15.0);
        linev3.setVisible(false);

        button0.setLayoutX(573.0);
        button0.setLayoutY(262.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(66.0);
        button0.setPrefWidth(78.0);
        button0.setStyle("-fx-border-color: white; -fx-background-color: rgba(0,0,0,0); -fx-border-width: 8; -fx-border-radius: 50;");
        button0.setText("P-REC");
        button0.setTextFill(javafx.scene.paint.Color.valueOf("#c6ff0c"));
        button0.setVisible(true);
        
        button2.setLayoutX(573.0);
        button2.setLayoutY(200.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(66.0);
        button2.setPrefWidth(78.0);
        button2.setStyle("-fx-border-color: white; -fx-background-color: rgba(0,0,0,0); -fx-border-width: 8; -fx-border-radius: 50;");
        button2.setText("Back");
        button2.setTextFill(javafx.scene.paint.Color.valueOf("#c6ff0c"));
        button2.setVisible(true);

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(player2name);
        getChildren().add(player1name);
        getChildren().add(win2);
        getChildren().add(win1);
        getChildren().add(mediaView);
        getChildren().add(p[0]);
        getChildren().add(p[3]);
        getChildren().add(p[2]);
        getChildren().add(p[1]);
        getChildren().add(p[5]);
        getChildren().add(p[4]);
        getChildren().add(p[6]);
        getChildren().add(p[8]);
        getChildren().add(p[7]);
         getChildren().add(imageView1);
        getChildren().add(button);
        getChildren().add(linex1);
        getChildren().add(linex2);
        getChildren().add(line1);
        getChildren().add(line2);
        getChildren().add(line3);
        getChildren().add(linev1);
        getChildren().add(linev2);
        getChildren().add(linev3);
        getChildren().add(button0);

        //////////////////////////////
       
 flagplayer=flag=flagplayerR;
      fullpath=_fullpath;
        setplayer(s1, s2);
        
//calling function 
for(int i =0;i<9;i++)
{
    buttonsevents(i);
}
        
//button reset
/**
 * button two for reset thw value of keys and all strings such as aa for displaying record and check winner 
 * and makin =g disable false to make abiliry of user to play again
 * and closing all values of lines wiith zero 
 * and also close the video game
 */
        button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                     try {
                     FileInputStream   save = new    FileInputStream(fullpath);
                 DataInputStream dis =new DataInputStream (save);
                 String one =dis.readUTF();
                  String [] tsplit =one.split(",");
                  for(int i=0;i<tsplit.length;i++)
                     System.out.println(tsplit[i]);
                 dis.close();
                 if(tsplit[0].compareTo("true") == 0)
                 {
                     flag=true;
                 }else 
                     flag=false;
   PauseTransition pause =new PauseTransition(Duration.seconds(1));
      pause.setOnFinished((e) -> {
            for(int ii=count;ii<tsplit.length;)
          {
               int i= Integer.parseInt(tsplit[ii]); 
               p[i].fire();
               count++;
               break;
           
      }
            pause.playFromStart();
      });
      pause.play();
      
                   //   TimeUnit.SECONDS.sleep(8);
                 
                 
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ReplayRecord.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ReplayRecord.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
                
         button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("close close");
                 System.exit(0);
            }
      });
                

    }
/**
 * 
 * @param s1
 * for passing the value of s1 and s2 from constructor 
 * to the lable of the board gamefor player one
 * @param s2 
 * for passing the value of s1 and s2 from constructor 
 * to the lable of the board gamefor player two
 */
    public void setplayer(String s1, String s2) {
        player1name.setText(s1);
        player2name.setText(s2);

    }
/**
 * checkwoinner function 
 * at first get the values of keys and save it to the 2D array of string 
 * to make condition of all cases that user play with it
 * and final thing that the array of record will save the data in new file created then make it printed on console 
 * then save the pase with append it to another  file created before it is name records
 * then making condition opening video for winner or looser after making check in 
 * if value of mm if not equal space and check in if x and flag must be true 
 * or o and flag must be false and third case for making the opponent wins
 */
    public void checkWinner() {
       
        aa[0][0] = p[0].getText();
        aa[0][1] = p[1].getText();
        aa[0][2] = p[2].getText();

        aa[1][0] = p[3].getText();
        aa[1][1] = p[4].getText();
        aa[1][2] = p[5].getText();

        aa[2][0] = p[6].getText();
        aa[2][1] = p[7].getText();
        aa[2][2] = p[8].getText();

        if (aa[0][0].equals(aa[0][1]) && aa[0][2].equals(aa[0][1]) && !aa[0][1].equals("")) {

            line1.setVisible(true);
            System.out.println(aa[0][0]);
            mm = aa[0][0];

        }
        if (aa[1][0].equals(aa[1][1]) && aa[1][2].equals(aa[1][1]) && !aa[1][1].equals("")) {
            line2.setVisible(true);
            score1++;
            win1.setText(String.valueOf(score1));
            mm = aa[1][0];
        }

        if (aa[2][0].equals(aa[2][1]) && aa[2][2].equals(aa[2][1]) && !aa[2][1].equals("")) {
            line3.setVisible(true);
            mm = aa[2][0];
        }

        if (aa[0][0].equals(aa[1][0]) && aa[2][0].equals(aa[1][0]) && !aa[1][0].equals("")) {
            linev1.setVisible(true);
            mm = aa[0][0];
        }
        if (aa[0][1].equals(aa[1][1]) && aa[2][1].equals(aa[1][1]) && !aa[1][1].equals("")) {
            linev2.setVisible(true);
            mm = aa[0][1];
        }
        if (aa[0][2].equals(aa[1][2]) && aa[2][2].equals(aa[1][2]) && !aa[1][2].equals("")) {
            linev3.setVisible(true);
            mm = aa[0][2];
        }
        if (aa[0][0].equals(aa[1][1]) && aa[2][2].equals(aa[1][1]) && !aa[1][1].equals("")) {
            linex2.setVisible(true);
            mm = aa[0][0];
        }
        if (aa[0][2].equals(aa[1][1]) && aa[2][0].equals(aa[1][1]) && !aa[1][1].equals("")) {
            linex1.setVisible(true);
            mm = aa[0][2];
        }
        /**
         * for checking winner for every player by making if condition to check
         * flag to detect if user play with x or O
         */
        
                     if(!isMovesLeft(aa))
                {
                  
                      System.out.println("hena fe t3adooooooooooooooooooooooooool");
                       JOptionPane.showMessageDialog(null, "t3adool");
                }               
        if (!mm.equals("")) {

            for (int i = 0; i < 9; i++) {
                p[i].setDisable(true);
            }

            if ((mm.equals("X") && flagplayer) || (mm.equals("O") && !flagplayer)) {
                String winner = "Winner is: " + mm + "owner";
                score1++;
                win1.setText(String.valueOf(score1));

                mediaView.setMediaPlayer(mediaPlayer);
                mediaView.setVisible(true);
                mediaPlayer.setAutoPlay(true);
            }
            else {

                score2++;
                System.out.println(score2);
                //   win1.setText(String.valueOf(55));
                win2.setText(String.valueOf(score2));

                mediaView.setMediaPlayer(mediaPlayer2);
                mediaView.setVisible(true);
                mediaPlayer2.setAutoPlay(true);

                // win1.setText(String.valueOf(score1));
            }
            mm = "";
      
        }
    }

    
    
      Boolean isMovesLeft(String board[][]) 
{ 
	for (int i = 0; i < 3; i++) 
		for (int j = 0; j < 3; j++) 
			if (board[i][j] == "") 
				return true; 
	return false; 
}  
   /**
    * 
    * @param y 
    * passing the value for which action of i wich have an button evvent must happen 
    * the function call other function like ceckwinner ()
    * and action handle wich containing the all important parts
    */
    
    public void buttonsevents(int y) {
        p[y].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                actionHandle(y);
                checkWinner();
            }
        });
   

    }
    public void actionHandle (int q)
    {
         record = record + q+ ",";
                if (flag == true) {

                    p[q].setText("X");
                    flag = !flag;

                    p[q].setDisable(true);

                } else {
                    p[q].setText("O");
                    flag = !flag;
                    p[q].setDisable(true);
                }
    }
}
