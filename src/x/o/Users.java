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
<<<<<<< HEAD
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
=======
//import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.SocketSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
>>>>>>> 9e50b258823a3e02baeed8f98eb30d7e4fe465d3
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.print.PrintColor;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.stage.Stage;
<<<<<<< HEAD
=======
import static javax.management.Query.value;
import javax.net.ssl.SSLServerSocket;
import javax.swing.JOptionPane;
>>>>>>> 9e50b258823a3e02baeed8f98eb30d7e4fe465d3

public  class Users extends SplitPane {

    protected final AnchorPane anchorPane;
    protected final ListView listView;
    protected final AnchorPane anchorPane0;
    private ObservableList<String> items = FXCollections.observableArrayList();
    private ImageView imageView = new ImageView();
    public  int id = 0;
    //private final Image RedLED = new Image("C:\\Users\\Fatma\\Desktop\\80387600_991797001185054_8482131157683535872_n.jpg");
    //private final Image GreenLED = new Image("/images/LEDGreen.png");
      
    // private final Image[] listOfImages = { GreenLED};

<<<<<<< HEAD
    public Users(Stage stage, PrintStream ps, DataInputStream dis){

=======
    public Users(Stage stage) throws SQLException {
        
>>>>>>> 9e50b258823a3e02baeed8f98eb30d7e4fe465d3
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
      
        
         Connection Conn = null;
       ResultSet rs = null;

       
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/xo", "root", "root");
            
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
            Statement stmt = conn.createStatement();

        
        
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                PrintStream ps = null;
                DataInputStream dis = null;
                 //ServerSocket myServerSocket;
                 Socket s = null;
                try {
                    s = new Socket("127.0.0.1",5005);
                } catch (IOException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    //System.out.println("clicked on " + listView.getSelectionModel().getSelectedItem());
                   //  myServerSocket = new ServerSocket(5005);
                   // s= myServerSocket.accept();
                    ps = new PrintStream(s.getOutputStream());
                    dis = new DataInputStream(s.getInputStream());
                    Statement stm = conn.createStatement();
                    ResultSet set = stm.executeQuery("select * from users where id ="+id);
                    
                    ps.println(id);
                    System.out.println(id);
                    
                } catch (IOException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        dis.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        
     
        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(160.0);
        anchorPane0.setPrefWidth(100.0);

        anchorPane.getChildren().add(listView);
        anchorPane0.getChildren().add(new OneToPc());
        anchorPane0.setDisable(true);
        getItems().add(anchorPane);
        getItems().add(anchorPane0);

<<<<<<< HEAD
       ps.println("requestUsers");
       listView.setItems(items);
        String arr[];
        String online;
        try {
            String readOnlineUsers = dis.readLine();
            
            arr = readOnlineUsers.split(",");
            online = arr[0];

            if(online.compareTo("onlineUsers") == 0)
            {
                System.out.println(arr[1]);
                //items.add(arr[1]);
            }
        } catch (IOException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }                           
            
            
            /*
            while (rs.next()) {
            items.add(rs.getString(2));
            //imageView.setImage(GreenLED);
            // setGraphic(imageView);
            System.out.println(rs.getString(2));
            }
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"data not found");
            }
        */      
        }
=======
 
      
       try {
           rs = stmt.executeQuery("select * from users where state='online'");
             listView.setItems(items);

           while (rs.next()) {
               items.add(rs.getString(2));
               id=(rs.getInt(1));
               
               //imageView.setImage(GreenLED);
              // setGraphic(imageView);
               System.out.println(rs.getString(2));
           }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"data not found");
       }

   }

   

    
>>>>>>> 9e50b258823a3e02baeed8f98eb30d7e4fe465d3
}
