package x.o;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Login extends BorderPane {

    protected final TabPane tabPane;
    protected final Tab tab;
    protected final AnchorPane anchorPane;
    protected final TextField phoneNumber;
    protected final TextField password;
    protected final Button login;
    protected final Label phoneError;
    protected final Label passError;
    protected final Tab tab0;
    protected final AnchorPane anchorPane0;
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    boolean phoneReply = false;
    boolean passReply = false;
    
    public Login(Stage stage) {

        try {
            mySocket = new Socket("localhost", 5005);
            dis = new DataInputStream(mySocket.getInputStream());
            ps=new PrintStream(mySocket.getOutputStream());
            
        } catch (IOException ex) {
            Logger.getLogger(XO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        tabPane = new TabPane();
        tab = new Tab();
        anchorPane = new AnchorPane();
        phoneNumber = new TextField();
        password = new TextField();
        login = new Button();
        phoneError = new Label();
        passError = new Label();
        tab0 = new Tab();
        anchorPane0 = new AnchorPane();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(tabPane, javafx.geometry.Pos.CENTER);
        tabPane.setPrefHeight(200.0);
        tabPane.setPrefWidth(200.0);
        tabPane.setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        tab.setId("logintab");
        tab.setText("Login");

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(180.0);
        anchorPane.setPrefWidth(200.0);

        phoneNumber.setId("Phone Number");
        phoneNumber.setLayoutX(169.0);
        phoneNumber.setLayoutY(114.0);
        phoneNumber.setPrefHeight(31.0);
        phoneNumber.setPrefWidth(256.0);
        phoneNumber.setPromptText("Phone Number");
       
        password.setId("password");
        password.setLayoutX(169.0);
        password.setLayoutY(174.0);
        password.setPrefHeight(31.0);
        password.setPrefWidth(256.0);
        password.setPromptText("Password");

        login.setId("login");
        login.setLayoutX(346.0);
        login.setLayoutY(232.0);
        login.setMnemonicParsing(false);
        login.setPrefHeight(36.0);
        login.setPrefWidth(77.0);
        login.setText("Login");
        

        login.setOnAction((ActionEvent event) -> {           
            String phone = phoneNumber.getText();
            String passwordText = password.getText();
            
            // Validate Field input
            if( phone.isEmpty())
            {
                phoneError.setDisable(false);
                phoneError.setText("your phone is required.!");
                passError.setDisable(true);
                passError.setText("");
            }
            else if( passwordText.isEmpty())
            {
                passError.setDisable(false);
                passError.setText("This Field is required.!");
                phoneError.setDisable(true);
                phoneError.setText("");
            }
            else if(!phone.matches("\\d{11}"))
            {
                phoneError.setDisable(false);
                phoneError.setText("your phone just be only 11 numbers.!");
            }
            else
            {
                passError.setDisable(true);
                phoneError.setDisable(true);
                passError.setText("");
                phoneError.setText("");
                
                // All things is true ==> Send phone number and password to Server.          
                ps.println(phone + "," + passwordText);
                System.out.println(phone + "," + passwordText);
                // Read Server Reply [login is true or not] 
            }
        });
        
        new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true)
                        {
                            String serverCheck;
                            String isExist, isLogin;
                            String[] arr;
                            try 
                            {
                                // Read Server Reply [login is true or not]
                                serverCheck = dis.readLine();
                                System.out.println(serverCheck);
                                    // Check reply if true or false
                                    arr = serverCheck.split(",");
                                    isExist = arr[0];
                                    isLogin = arr[1];

                                    if(isExist.compareTo("false") == 0) // phone don't exist
                                    {
                                        //phoneError.setDisable(false);
                                        //phoneError.setText("You don't exist, Please Register");
                                        phoneReply = true;
                                        System.out.println("You don't exist, Please Register");
                                    }
                                    else
                                    {
                                        phoneError.setDisable(true);
                                        phoneError.setText("");
                                    }

                                    if(isLogin.compareTo("false") == 0) // password is false
                                    {
                                        //passError.setDisable(false);
                                        //passError.setText("Please insert valied password");
                                        passReply = true;
                                        System.out.println("Please insert valied password");
                                    }
                                    else
                                    {
                                        passError.setDisable(true);
                                        passError.setText("");
                                    }

                                    if(isExist.compareTo("true") == 0 && isLogin.compareTo("true") == 0) // Login is true
                                    {
                                        passError.setDisable(true);
                                        phoneError.setDisable(true);
                                        passError.setText("");
                                        phoneError.setText("");
                                        stage.getScene().setRoot(new Users(stage)); //Change it to online board
                                    }
                            } 
                            catch (IOException ex) 
                            {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SQLException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }).start();
            

        phoneError.setDisable(true);
        phoneError.setId("phoneError");
        phoneError.setLayoutX(169.0);
        phoneError.setLayoutY(148.0);
        phoneError.setPrefHeight(21.0);
        phoneError.setPrefWidth(255.0);
        phoneError.setTextFill(javafx.scene.paint.Color.RED);

        passError.setDisable(true);
        passError.setId("passError");
        passError.setLayoutX(169.0);
        passError.setLayoutY(209.0);
        passError.setPrefHeight(21.0);
        passError.setPrefWidth(255.0);
        passError.setTextFill(javafx.scene.paint.Color.RED);
        tab.setContent(anchorPane);

        tab0.setText("Register");

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(180.0);
        anchorPane0.setPrefWidth(200.0);
        tab0.setContent(anchorPane0);
        setCenter(tabPane);

        anchorPane.getChildren().add(phoneNumber);
        anchorPane.getChildren().add(password);
        anchorPane.getChildren().add(login);
        anchorPane.getChildren().add(phoneError);
        anchorPane.getChildren().add(passError);
        tabPane.getTabs().add(tab);
        //tabPane.getTabs().add(tab0);

    }
}
