/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.o;

/**
 *
 * @author Fatma
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public  class Users extends SplitPane {

    protected final AnchorPane anchorPane;
    protected final ListView listView;
    protected final AnchorPane anchorPane0;
    private ObservableList<String> items = FXCollections.observableArrayList();
    private ImageView imageView = new ImageView();

    //private final Image RedLED = new Image("C:\\Users\\Fatma\\Desktop\\80387600_991797001185054_8482131157683535872_n.jpg");
    //private final Image GreenLED = new Image("/images/LEDGreen.png");
      
    // private final Image[] listOfImages = { GreenLED};

    public Users(Stage stage) throws SQLException {

        anchorPane = new AnchorPane();
        listView = new ListView();
        anchorPane0 = new AnchorPane();

        setDividerPositions(0.29797979797979796);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(160.0);
        anchorPane.setPrefWidth(100.0);

        AnchorPane.setBottomAnchor(listView, 0.0);
        AnchorPane.setLeftAnchor(listView, 0.0);
        AnchorPane.setRightAnchor(listView, 0.0);
        AnchorPane.setTopAnchor(listView, 0.0);
        listView.setLayoutX(-39.0);
        listView.setLayoutY(-9.0);
        listView.setPrefHeight(398.0);
        listView.setPrefWidth(175.0);

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(160.0);
        anchorPane0.setPrefWidth(100.0);

        anchorPane.getChildren().add(listView);
        anchorPane0.getChildren().add(new OneToPc());
        anchorPane0.setDisable(true);
        getItems().add(anchorPane);
        getItems().add(anchorPane0);
     

 
       Connection Conn = null;
       ResultSet rs = null;

       
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/xo", "root", "ashraf");
            
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
            Statement stmt = conn.createStatement();

       try {
           rs = stmt.executeQuery("select * from users where state='online'");
             listView.setItems(items);

           while (rs.next()) {
               items.add(rs.getString(2));
               //imageView.setImage(GreenLED);
              // setGraphic(imageView);
               System.out.println(rs.getString(2));
           }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"data not found");
       }

   }

   

    
}
