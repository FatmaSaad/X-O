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
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.stage.Stage;

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
    public Users(Stage stage, PrintStream ps, DataInputStream dis){

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
              
        /*listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                
               

            }
        });*/
        
     
        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(160.0);
        anchorPane0.setPrefWidth(100.0);

        anchorPane.getChildren().add(listView);

        anchorPane0.getChildren().add(new Board());

        anchorPane0.setDisable(true);
        getItems().add(anchorPane);
        getItems().add(anchorPane0);

        
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
                for (int i = 0; i < arr.length; i++) {
                    items.add(arr[i]);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }                              
        }

}
