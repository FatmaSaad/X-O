package x.o;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public  class Profile extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final Label label0;
    protected final Circle circle;

    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label email;
    protected final Label gender;
    protected final Label name;
    protected final Label id;
    protected final Label phone;
    protected final Button button;
    protected final TextArea pass;
    protected final Button bpass;
    
    
    
    
    /////////////////////
    PreparedStatement pst;
     boolean flag=true;

    public Profile( Connection conn) throws SQLException {

        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        circle = new Circle();
  
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        email = new Label();
        gender = new Label();
        name = new Label();
        id = new Label();
        phone = new Label();
        button = new Button();
        pass = new TextArea();
        bpass = new Button();

        setId("AnchorPane");
        setPrefHeight(394.0);
        setPrefWidth(564.0);

        imageView.setFitHeight(394.0);
        imageView.setFitWidth(688.0);
        imageView.setLayoutY(10.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("nn.gif").toExternalForm()));

        label.setLayoutX(14.0);
        label.setLayoutY(22.0);
        label.setText("ID:");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#aaff00"));
        label.setFont(new Font("System Bold Italic", 32.0));

        label0.setLayoutX(12.0);
        label0.setLayoutY(60.0);
        label0.setText("Name:");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#fffb00"));
        label0.setFont(new Font("System Bold Italic", 31.0));

        circle.setFill(javafx.scene.paint.Color.DODGERBLUE);
        circle.setLayoutX(564.0);
        circle.setLayoutY(109.0);
        circle.setRadius(100.0);
        circle.setStroke(javafx.scene.paint.Color.BLACK);
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

    
                       Image d= new Image(getClass().getResource("ff.png").toExternalForm());
                       circle.setFill(new ImagePattern(d));
        label1.setLayoutX(1.0);
        label1.setLayoutY(109.0);
        label1.setText("Gender:");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#ddff00"));
        label1.setFont(new Font("System Bold Italic", 31.0));

        label2.setLayoutX(6.0);
        label2.setLayoutY(157.0);
        label2.setText("PhoneNo:");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#95ff00"));
        label2.setFont(new Font("System Bold Italic", 31.0));

        label3.setLayoutX(11.0);
        label3.setLayoutY(217.0);
        label3.setText("Email:");
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#a1ff09"));
        label3.setFont(new Font("System Bold Italic", 31.0));

        email.setLayoutX(103.0);
        email.setLayoutY(217.0);
        email.setText("-");
        email.setTextFill(javafx.scene.paint.Color.WHITE);
        email.setFont(new Font("System Bold Italic", 31.0));

        gender.setLayoutX(153.0);
        gender.setLayoutY(109.0);
        gender.setText("-");
        gender.setTextFill(javafx.scene.paint.Color.valueOf("#f5eded"));
        gender.setFont(new Font("System Bold Italic", 31.0));

        name.setLayoutX(123.0);
        name.setLayoutY(60.0);
        name.setText("-");
        name.setTextFill(javafx.scene.paint.Color.WHITE);
        name.setFont(new Font("System Bold Italic", 31.0));

        id.setLayoutX(77.0);
        id.setLayoutY(23.0);
        id.setText("-");
        id.setTextFill(javafx.scene.paint.Color.WHITE);
        id.setFont(new Font("System Bold Italic", 31.0));

        phone.setLayoutX(148.0);
        phone.setLayoutY(157.0);
        phone.setText("-");
        phone.setTextFill(javafx.scene.paint.Color.WHITE);
        phone.setFont(new Font("System Bold Italic", 31.0));

        button.setLayoutX(445.0);
        button.setLayoutY(291.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(70.0);
        button.setPrefWidth(69.0);
        button.setStyle("-fx-background-color: rgba(0,0,0,.5); -fx-background-radius: 50; -fx-border-color: white;");
        button.setText("Button");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#e2ff06"));

        pass.setLayoutX(36.0);
        pass.setLayoutY(268.0);
        pass.setPrefHeight(47.0);
        pass.setPrefWidth(200.0);
        pass.setStyle("-fx-background-color: yellow;");
        pass.setVisible(false);
        
        bpass.setLayoutX(36.0);
        bpass.setLayoutY(326.0);
        bpass.setMnemonicParsing(false);
        bpass.setPrefHeight(25.0);
        bpass.setPrefWidth(200.0);
        bpass.setStyle("-fx-background-color: rgba(0,0,0,.2); -fx-background-radius: 50; -fx-border-color: white;");
        bpass.setText("Change-passwd");
        bpass.setTextFill(javafx.scene.paint.Color.valueOf("#d8f51c"));
       

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(circle);
      
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(email);
        getChildren().add(gender);
        getChildren().add(name);
        getChildren().add(id);
        getChildren().add(phone);
        getChildren().add(button);
        getChildren().add(pass);
        getChildren().add(bpass);
///////////////////////////////////////////////////////
/**
 * this code program for displayin the all profile player information:"
 * like id , name , pic , also ,data ,
 * using  making conection in start method then
 * the conection bassing to the constructor of java containing design apps the 
 * whole program depend on selectinng quereies from daTA base to get information using 
 *  Using Prepared Statement instead of Statement has the following benefits:
 * 
 * 
 Easy to use when we need to execute the same query many times but
* with different values for the where conditions.
 We will not do tedious string concatenations for the query string.
 Minimizes the query analyzing overhead.
* 
  example___>>
  * 
* PreparedStatement pst = con.prepareStatement("select * from Employee where gender = ? AND salary > ?");
pst.setString (1, "male"); pst.setFloat(2, 500);
ResultSet rs = pst.executeQuery() ; // ResultSet executeQuery (String SQL);
// pst.executeUpdate(); // int executeUpdate (String SQL); 
 */

int idd  =1;
id.setText(String.valueOf(idd));
 pst = conn.prepareStatement("SELECT `username` FROM `xo`.`users` WHERE `id` = ? ");
 pst.setInt(1, idd);
 ResultSet rs = pst.executeQuery() ; 
 rs.first();
    name.setText(rs.getString(1));
    
    pst = conn.prepareStatement("SELECT `email` FROM `xo`.`users` WHERE `id` = ? ");
 pst.setInt(1, idd);
 rs = pst.executeQuery() ; 
 rs.first();
    email.setText(rs.getString(1));
    
      pst = conn.prepareStatement("SELECT `gender` FROM `xo`.`users` WHERE `id` = ? ");
 pst.setInt(1, idd);
  rs = pst.executeQuery() ; 
 rs.first();
    gender.setText(rs.getString(1));
    
      pst = conn.prepareStatement("SELECT `phone` FROM `xo`.`users` WHERE `id` = ? ");
 pst.setInt(1, idd);
  rs = pst.executeQuery() ; 
 rs.first();
    phone.setText(rs.getString(1));
    /**
     * 
     * second for makin update on password we need to make action 
     * respond to the fire that habbend to the button then we need 
     * to make the text area that the user neeed to but the new valye of pass word 
     * writen visible and the value text of button changed ot save 
     * 
     */
    
  //  bpass.onActionProperty()
 
  
                 bpass.setOnAction(new EventHandler<ActionEvent>() {
            @Override
              public void handle(ActionEvent event) {
                  if(flag)
                  {
                        pass.setVisible(true);
                        bpass.setText("save");
                        flag=false;
                  }else
                  {
                        pass.setVisible(false);
                        bpass.setText("change pass word");
                        
                        flag=true;
                        
                      try {
                          /**
                           * saving the new pass word need string to save value
                           * then make pPreparedStatement Use it when you plan to use the SQL statements many times.
                           * The PreparedStatement interface accepts input parameters at runtime.
                           */
                          pst=conn.prepareStatement("UPDATE `xo`.`users` SET `password` = ?  WHERE `id` = ?");
                          pst.setString(1,pass.getText());
                          pst.setInt(2, idd);
                          pst.executeUpdate();
                          
                      } catch (SQLException ex) {
                          Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
              
                
                
            }
 
                 });
 
 
    }

}
