/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.o;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class Board extends AnchorPane {

    protected final Label label;
    protected final Label label0;
    protected final Label player2name;
    protected final Label player1name;
    protected final Label win2;
    protected final Label win1;
    
     protected final Button[] p=new Button[9];
 //   protected final Button p0;
//    protected final Button p3;
   // protected final Button p2;
  //  protected final Button p1;
 //   protected final Button p5;
//    protected final Button p4;
    //protected final Button p6;
  //  protected final Button p8;
  //  protected final Button p7;
    protected final Button button;

    
    
         boolean flag =true; 
    public Board() {

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

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: Red;");

        label.setLayoutX(348.0);
        label.setLayoutY(11.0);
        label.setPrefHeight(52.0);
        label.setPrefWidth(238.0);
        label.setStyle("-fx-alignment: center; -fx-background-color: Blue; -fx-font-size: 30;");
        label.setText("Player One");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#c3cd0d"));

        label0.setLayoutX(14.0);
        label0.setLayoutY(14.0);
        label0.setPrefHeight(52.0);
        label0.setPrefWidth(228.0);
        label0.setStyle("-fx-alignment: center; -fx-background-color: Blue; -fx-font-size: 35;");
        label0.setText("Player Two");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#a9d714"));

        player2name.setLayoutX(14.0);
        player2name.setLayoutY(76.0);
        player2name.setPrefHeight(0.0);
        player2name.setPrefWidth(228.0);
        player2name.setStyle("-fx-alignment: center; -fx-font-size: 35;");
        player2name.setText("yomna");
        player2name.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player2name.setTextFill(javafx.scene.paint.Color.valueOf("#a9d714"));

        player1name.setLayoutX(348.0);
        player1name.setLayoutY(76.0);
        player1name.setPrefHeight(52.0);
        player1name.setPrefWidth(228.0);
        player1name.setStyle("-fx-alignment: center; -fx-font-size: 35;");
        player1name.setText("ahmed");
        player1name.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player1name.setTextFill(javafx.scene.paint.Color.valueOf("#a9d714"));

        win2.setAlignment(javafx.geometry.Pos.BASELINE_CENTER);
        win2.setLayoutX(242.0);
        win2.setLayoutY(84.0);
        win2.setPrefHeight(36.0);
        win2.setPrefWidth(28.0);
        win2.setStyle("-fx-font-size: 30;");
        win2.setText("0");

        win1.setAlignment(javafx.geometry.Pos.BASELINE_CENTER);
        win1.setLayoutX(320.0);
        win1.setLayoutY(84.0);
        win1.setPrefHeight(36.0);
        win1.setPrefWidth(28.0);
        win1.setStyle("-fx-font-size: 30;");
        win1.setText("0");

        p[0].setLayoutX(157.0);
        p[0].setLayoutY(127.0);
        p[0].setMnemonicParsing(false);
        p[0].setPrefHeight(85.0);
        p[0].setPrefWidth(85.0);
        p[0].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25;");

        p[3].setLayoutX(157.0);
        p[3].setLayoutY(212.0);
        p[3].setMnemonicParsing(false);
        p[3].setPrefHeight(85.0);
        p[3].setPrefWidth(85.0);
        p[3].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25;");

        p[2].setLayoutX(356.0);
        p[2].setLayoutY(127.0);
        p[2].setMnemonicParsing(false);
        p[2].setPrefHeight(85.0);
        p[2].setPrefWidth(85.0);
        p[2].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25;");

        p[1].setLayoutX(258.0);
        p[1].setLayoutY(127.0);
        p[1].setMnemonicParsing(false);
        p[1].setPrefHeight(85.0);
        p[1].setPrefWidth(85.0);
        p[1].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25;");

        p[5].setLayoutX(356.0);
        p[5].setLayoutY(212.0);
        p[5].setMnemonicParsing(false);
        p[5].setPrefHeight(85.0);
        p[5].setPrefWidth(85.0);
        p[5].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25;");

        p[4].setLayoutX(258.0);
        p[4].setLayoutY(212.0);
        p[4].setMnemonicParsing(false);
        p[4].setPrefHeight(85.0);
        p[4].setPrefWidth(85.0);
        p[4].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25;");

        p[6].setLayoutX(157.0);
        p[6].setLayoutY(297.0);
        p[6].setMnemonicParsing(false);
        p[6].setPrefHeight(85.0);
        p[6].setPrefWidth(85.0);
        p[6].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25;");

        p[8].setLayoutX(356.0);
        p[8].setLayoutY(297.0);
        p[8].setMnemonicParsing(false);
        p[8].setPrefHeight(85.0);
        p[8].setPrefWidth(85.0);
        p[8].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25;");

        p[7].setLayoutX(258.0);
        p[7].setLayoutY(297.0);
        p[7].setMnemonicParsing(false);
        p[7].setPrefHeight(85.0);
        p[7].setPrefWidth(85.0);
        p[7].setStyle("-fx-font-family: Papyrus; -fx-font-size: 25;");

        button.setLayoutX(506.0);
        button.setLayoutY(348.0);
        button.setMnemonicParsing(false);
        button.setStyle("-fx-background-color: red;");
        button.setText("Back");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(player2name);
        getChildren().add(player1name);
        getChildren().add(win2);
        getChildren().add(win1);
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
        //////////////////////
   
        setplayer("XXXX", "OOOO");
        
        p[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(flag==true)
                {
                    p[0].setText("X");
                }
                else
                {
                    p[0].setText("O");
                }
                flag=!flag;
                p[0].setDisable(true);
                checkWinner ();
            }
        });
        
         p[1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
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
          checkWinner ();
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
          checkWinner ();
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
          checkWinner ();
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
          checkWinner ();
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
          checkWinner ();
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
          checkWinner ();
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
         checkWinner ();
            }
        });
           
           button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
         checkWinner();
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
    String  [][]aa={
                    {p[0].getText(),p[1].getText(),p[2].getText()},
                      {p[3].getText(),p[4].getText(),p[5].getText()},
                       {p[6].getText(),p[7].getText(),p[8].getText()}
                  }; 
    
    
                    if(aa[0][0].equals(aa[0][1])&&aa[0][2].equals(aa[0][1])&&!aa[0][1].equals("")||
                       aa[1][0].equals(aa[1][1])&&aa[1][2].equals(aa[1][1])&&!aa[1][1].equals("")||
                       aa[2][0].equals(aa[2][1])&&aa[2][2].equals(aa[2][1])&&!aa[2][1].equals("")
                            )
                    {
                        JOptionPane.showMessageDialog(null, "the winner is ");
                    }
    
        System.err.println(aa[0][0].equals(aa[0][1])&&aa[0][2].equals(aa[0][1]));
    }
    
}