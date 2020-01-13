package x.o;

import java.io.File;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JOptionPane;
//[123] [123][123]]
public  class TwoPlayer extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final Label label0;
    protected final Label player2name;
    protected final Label player1name;
    protected final Label win2;
    protected final Label win1;
   protected final Button[] p=new Button[9];
    
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

       protected final MediaView mediaView;

    
    int score1;
            int score2;
    /**
     * 
     */

boolean flag=true;

boolean flagplayer;
String mm="";

 String  [][]aa={
                    {"","",""},
                      {"","",""},
                       {"","",""}
                  };

 
  Media media;
   MediaPlayer mediaPlayer;
   
    Media media2;
   MediaPlayer mediaPlayer2;
 
        
         
          
    public TwoPlayer(String s1,String s2,int sc1,int sc2) {

         media = new Media(new File("C:\\Users\\ahmed\\Desktop\\iti\\java\\apps\\taskone\\video\\src\\video\\v.mp4").toURI().toString());  
             mediaPlayer = new MediaPlayer(media);
              media2 = new Media(new File("C:\\Users\\ahmed\\Desktop\\X-O\\src\\x\\o\\v2.mp4").toURI().toString());  
             mediaPlayer2 = new MediaPlayer(media2);
             
        score1=sc1;
        score2=sc2;
        
         mediaView = new MediaView();
          mediaView.setFitHeight(450.0);
        mediaView.setFitWidth(750.0);
        mediaView.setLayoutX(-17.0);
        mediaView.setLayoutY(0.0);
        
        

        imageView = new ImageView();
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
        p[4 ]= new Button();
        p[6 ]= new Button();
        p[8 ]= new Button();
        p[7 ]= new Button();
        button = new Button();
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
        button.setText("Back");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#c6ff0c"));

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
        button0.setText("Back");
        button0.setTextFill(javafx.scene.paint.Color.valueOf("#c6ff0c"));
        button0.setVisible(false);

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
         flagplayer=flag;
       
        /*   new Thread (){
          public void   run(){
                while(true)
                {
                 System.out.println("heeloo worled");
                 /*   try {
                          sleep(1200);
                         p[0].setDisable(true);
                        sleep(1200); 
                        p[0].setDisable(false);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
         
             /*    if  (checkWinner ().equals("X"))
                 {
                     
                     for(int i=0;i<9;i++)
                     {
                         p[i].setDisable(true);
                     }
                   
                    
                        ////////////
                        if(flagplayer)
                        {
                            System.out.println(".run()");
                            JOptionPane.showMessageDialog(null, "myxxx;lkjhgfhtxxxxx");
                        }else{
                             JOptionPane.showMessageDialog(null, "oppnetxxxxx");
                        System.out.println(".run()lkmnkjbjhcvchg");
                        }
                            this.stop();
                        
                        /////
                         if  (checkWinner ().equals("O"))
                 {
                     
                     for(int i=0;i<9;i++)
                     {
                         p[i].setDisable(true);
                     }
                   
                        this.stop();
                        ////////////
                        if(flagplayer)
                        {
                            JOptionPane.showMessageDialog(null, "onexxxxx");
                        }else
                             JOptionPane.showMessageDialog(null, "oppnetxxxxx");
                         this.stop();
                        
                 }
                        
                 } */
             /*            if  (!checkWinner().equals(""))
                 {
                     
                     for(int i=0;i<9;i++)
                     {
                         p[i].setDisable(true);
                     }
                   if(checkWinner().equals("X")&&flagplayer)
                   {
                    String winner = "Winner is: " + checkWinner();
                    score1++;
                     win1.setText(String.valueOf(score1));
                    JOptionPane.showMessageDialog(null, winner);
                   
                   }else
                        if(checkWinner().equals("O")&&!flagplayer)
                   {
                    String winner = "Winner is: " + checkWinner();
                    score1++;
                       win1.setText(String.valueOf(score1));
                     
                    JOptionPane.showMessageDialog(null, winner);
                   }else
                        {
                    
                         score1++;
                            System.out.println(score1);
                         //   win1.setText(String.valueOf(55));
                                win1.setText(String.valueOf(5));
                             //  JOptionPane.showMessageDialog(null, "opponet");
                      // win1.setText(String.valueOf(score1));
                        }
                            this.stop();
                        
                        /////
                        
                        
                 } 
                    }
                
            }
        }.start();*/
     
             /*
             Media media = new Media(new File("C:\\Users\\ahmed\\Desktop\\iti\\java\\apps\\taskone\\video\\src\\video\\vv.mp4").toURI().toString());  
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            mediaPlayer.setAutoPlay(true);  
             */
        setplayer(s1, s2);
        
        
         buttonsevents();
     
           button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              
                           for(int i=0;i<9;i++)
                     {
                         p[i].setDisable(false);
                         p[i].setText("");
                         
                     }
                           for(int k=0;k<3;k++)
                           {
                             for(int m=0;m<3;m++)
                           {
                              aa[k][m]=""; 
                           }
                           
                           }
                             line1.setVisible(false);
                                 line2.setVisible(false);
                                 line3.setVisible(false);
                                 linev1.setVisible(false);
                                  linev2.setVisible(false);
                                 linev3.setVisible(false);
                                  linex1.setVisible(false);
                                 linex2.setVisible(false);
                                 flag=flagplayer;

                                         
                    mediaView.setVisible(false);
                    mediaPlayer.setAutoPlay(false);
                    mediaPlayer.stop();
                     mediaPlayer2.setAutoPlay(false);
                            mediaPlayer2.stop();
                    

            }
        });
                 
                 

       
    }
    public void  setplayer (String s1, String s2)
    {
        player1name.setText(s1);
        player2name.setText(s2);
        
    }
    
    public void checkWinner ()
    {
  /*  String  [][]aa={
                    {p[0].getText(),p[1].getText(),p[2].getText()},
                      {p[3].getText(),p[4].getText(),p[5].getText()},
                       {p[6].getText(),p[7].getText(),p[8].getText()}
                  }; */
        
       aa[0][0]=            p[0].getText();
       aa[0][1]=            p[1].getText();
       aa[0][2]=            p[2].getText();
                                
       aa[1][0]=            p[3].getText();
       aa[1][1]=            p[4].getText();
       aa[1][2]=            p[5].getText();
                                              
       aa[2][0]=            p[6].getText();
       aa[2][1]=            p[7].getText();
       aa[2][2]=            p[8].getText();
    
    
    
                    if(aa[0][0].equals(aa[0][1])&&aa[0][2].equals(aa[0][1])&&!aa[0][1].equals(""))
                    {
           
               line1.setVisible(true);
                        System.out.println(aa[0][0]);
                  mm= aa[0][0];
          
                   //  JOptionPane.showMessageDialog(null, "the winner is ");
                    }
                    if( aa[1][0].equals(aa[1][1])&&aa[1][2].equals(aa[1][1])&&!aa[1][1].equals(""))
                        {
                             line2.setVisible(true);
                              score1++;
                     win1.setText(String.valueOf(score1));
                                 mm= aa[1][0];
                    }
                        
                        
                         if( aa[2][0].equals(aa[2][1])&&aa[2][2].equals(aa[2][1])&&!aa[2][1].equals(""))
                            {
                                 line3.setVisible(true);
                                  mm = aa[2][0];
                            }
                            
                            
                            
                            
                  if(aa[0][0].equals(aa[1][0])&&aa[2][0].equals(aa[1][0])&&!aa[1][0].equals(""))
                    {
                         linev1.setVisible(true);
                         mm= aa[0][0];
                    }
                if( aa[0][1].equals(aa[1][1])&&aa[2][1].equals(aa[1][1])&&!aa[1][1].equals(""))
                    {
                         linev2.setVisible(true);
                      mm= aa[0][1];
                    }
                        if( aa[0][2].equals(aa[1][2])&&aa[2][2].equals(aa[1][2])&&!aa[1][2].equals(""))
                            {
                                 linev3.setVisible(true);
                                    mm=  aa[0][2];
                    }
                            if( aa[0][0].equals(aa[1][1])&&aa[2][2].equals(aa[1][1])&&!aa[1][1].equals(""))
                            {
                                 linex2.setVisible(true);
                                   mm= aa[0][0];
                    }
                      if( aa[0][2].equals(aa[1][1])&&aa[2][0].equals(aa[1][1])&&!aa[1][1].equals(""))
                            {
                                 linex1.setVisible(true);
                                    mm=  aa[0][2];
                    }  
                      
                        if  (!mm.equals(""))
                 {
                     
                     for(int i=0;i<9;i++)
                     {
                         p[i].setDisable(true);
                     }

                   if((mm.equals("X")&&flagplayer)||(mm.equals("O")&&!flagplayer))

                   {
                    String winner = "Winner is: " + mm+"owner";
                    score1++;
                     win1.setText(String.valueOf(score1));    

                       mediaView.setMediaPlayer(mediaPlayer);
           mediaView.setVisible(true);
            mediaPlayer.setAutoPlay(true);  
                   }
                   /*else if(mm.equals("O")&&!flagplayer)

                      JOptionPane.showMessageDialog(null, winner);
                   }else if(mm.equals("O")&&!flagplayer)
>>>>>>> 2d6940f07a4675744c564bdbf7136eb567bd6f2c
                   {
                    String winner = "Winner is: " + mm+"owner";
                    score1++;
                       win1.setText(String.valueOf(score1));
                     
                    JOptionPane.showMessageDialog(null, winner);
<<<<<<< HEAD
                   }*/else

                        {
                    
                         score2++;
                            System.out.println(score2);
                         //   win1.setText(String.valueOf(55));
                                win2.setText(String.valueOf(score2));

                                mediaView.setMediaPlayer(mediaPlayer2);
           mediaView.setVisible(true);
            mediaPlayer2.setAutoPlay(true); 

                      // win1.setText(String.valueOf(score1));
                        }
                            mm="";
    
        System.out.println(aa[0][0].equals(aa[0][1])&&aa[0][2].equals(aa[0][1]));
    
    }
    }
    
    /**
      
     
     */
    public void buttonsevents(){
         p[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                                           

          if(flag==true)
          {
           
                  p[0].setText("X");
           flag=!flag;
           
           p[0].setDisable(true);
           
          }else
          {
                 p[0].setText("O");
           flag=!flag;
           p[0].setDisable(true);
          }
             checkWinner();
            }
        });
         p[1].setOnAction(new EventHandler<ActionEvent>() {
            @ Override
            public void handle(ActionEvent event) {
          if(flag==true)
          {
           p[1].setText("X");
           flag=!flag;
           
           p[1].setDisable(true);
          }else
          {
                 p[1].setText("O");
           flag=!flag;
           p[1].setDisable(true);
          }
       checkWinner();
            }
        });
          p[2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          if(flag==true)
          {
           p[2].setText("X");
           flag=!flag;
           
           p[2].setDisable(true);
          }else
          {
                 p[2].setText("O");
           flag=!flag;
           p[2].setDisable(true);
     
          }
         checkWinner();
            }
        });
           p[3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          if(flag==true)
          {
           p[3].setText("X");
           flag=!flag;
           
           p[3].setDisable(true);
          }else
          {
                 p[3].setText("O");
           flag=!flag;
           p[3].setDisable(true);
          }
             checkWinner();
            }
        });
            p[4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          if(flag==true)
          {
           p[4].setText("X");
           flag=!flag;
           
           p[4].setDisable(true);
          }else
          {
                 p[4].setText("O");
           flag=!flag;
           p[4].setDisable(true);
          }
            checkWinner();   
            }
        }); p[5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          if(flag==true)
          {
           p[5].setText("X");
           flag=!flag;
           
           p[5].setDisable(true);
          }else
          {
                 p[5].setText("O");
           flag=!flag;
           p[5].setDisable(true);
          }
               checkWinner();   
            }
            
        });
         p[6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          if(flag==true)
          {
           p[6].setText("X");
           flag=!flag;
           
           p[6].setDisable(true);
          }else
          {
                 p[6].setText("O");
           flag=!flag;
           p[6].setDisable(true);
          }
              checkWinner();       
            }
        });
          p[7].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          if(flag==true)
          {
           p[7].setText("X");
           flag=!flag;
           
           p[7].setDisable(true);
          }else
          {
                 p[7].setText("O");
           flag=!flag;
           p[7].setDisable(true);
          }
               checkWinner();
            }
        });
           p[8].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          if(flag==true)
          {
           p[8].setText("X");
           flag=!flag;
           
           p[8].setDisable(true);
          }else
          {
                 p[8].setText("O");
             
           flag=!flag;
           p[8].setDisable(true);
          }
            
 checkWinner();
            }
        });
           
    }
}