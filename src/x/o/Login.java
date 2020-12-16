package x.o;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import static javafx.scene.layout.Region.USE_PREF_SIZE;


public class Login extends Pane {

    protected final ImageView imageView;
    protected final DropShadow dropShadow;
    protected final TextField phoneNumber;
    protected final Button login;
    protected final InnerShadow innerShadow;
    protected final Button back;
    protected final InnerShadow innerShadow0;
    protected final Button register;
    protected final InnerShadow innerShadow1;
    protected final Label phoneError;
    protected final Label passError;
    protected final PasswordField password;
    OnlineBoard playBord;
    //TwoPlayer playBord;
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    boolean phoneReply = false;
    boolean passReply = false;
    final JButton Reject = new JButton("reject");
         
    
    public Login(Stage stage, String _ip) {

        try {
            mySocket = new Socket(_ip, 5005);
            dis = new DataInputStream(mySocket.getInputStream());
            ps=new PrintStream(mySocket.getOutputStream());
            
        } catch (IOException ex) {
            Logger.getLogger(XO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        imageView = new ImageView();
        dropShadow = new DropShadow();
        phoneNumber = new TextField();
        login = new Button();
        innerShadow = new InnerShadow();
        back = new Button();
        innerShadow0 = new InnerShadow();
        register = new Button();
        innerShadow1 = new InnerShadow();
        phoneError = new Label();
        passError = new Label();
        password = new PasswordField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(414.0);
        setPrefWidth(717.0);

        imageView.setFitHeight(210.0);
        imageView.setFitWidth(192.0);
        imageView.setLayoutX(250.0);
        imageView.setLayoutY(27.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("media/login.jpg").toExternalForm()));

        imageView.setEffect(dropShadow);

        phoneNumber.setLayoutX(205.0);
        phoneNumber.setLayoutY(240.0);
        phoneNumber.setPrefHeight(31.0);
        phoneNumber.setPrefWidth(283.0);
        phoneNumber.setPromptText("phone number");

        login.setLayoutX(299.0);
        login.setLayoutY(360.0);
        login.setMnemonicParsing(false);
        login.setPrefHeight(31.0);
        login.setPrefWidth(95.0);
        login.setText("Login");

        login.setEffect(innerShadow);

        back.setLayoutX(116.0);
        back.setLayoutY(360.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(31.0);
        back.setPrefWidth(95.0);
        back.setText("back");

        back.setEffect(innerShadow0);
        back.setOnAction((ActionEvent event) -> {
            stage.getScene().setRoot(new PlayingModes(stage));
        });

        register.setLayoutX(472.0);
        register.setLayoutY(360.0);
        register.setMnemonicParsing(false);
        register.setPrefHeight(31.0);
        register.setPrefWidth(95.0);
        register.setText("Register");

        register.setEffect(innerShadow1);
        register.setOnAction((ActionEvent event) -> {

            stage.getScene().setRoot(new Register(ps, dis, stage, _ip));

        });

        password.setLayoutX(205.0);
        password.setLayoutY(298.0);
        password.setPrefHeight(31.0);
        password.setPrefWidth(283.0);
        password.setPromptText("password");
        
        phoneError.setDisable(true);
        phoneError.setId("phoneError");
        phoneError.setTextFill(javafx.scene.paint.Color.RED);

        passError.setDisable(true);
        passError.setId("passError");
        passError.setTextFill(javafx.scene.paint.Color.RED);
        phoneError.setLayoutX(205.0);
        
        phoneError.setLayoutY(274.0);
        phoneError.setPrefHeight(21.0);
        phoneError.setPrefWidth(283.0);

        passError.setLayoutX(206.0);
        passError.setLayoutY(333.0);
        passError.setPrefHeight(21.0);
        passError.setPrefWidth(283.0);
        

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
                ps.println("login," + phone + "," + passwordText);
                System.out.println("login," + phone + "," + passwordText);
                // Read Server Reply [login is true or not] 
            }
        });
        
        new Thread(new Runnable() {
                public String userPhone;

                    @Override
                    public void run() {
                        while(true)
                        {
                            String serverCheck;
                            String isExist, isLogin,loginMsg;
                            String[] arr;
                            try 
                            {
                                // Read Server Reply [login is true or not]
                                serverCheck = dis.readLine();
                                System.out.println(serverCheck);
                                    // Check reply if true or false
                                    arr = serverCheck.split(",");
                                    
                                    loginMsg = arr[0];
                                                                        
                                    if(loginMsg.compareTo("login") == 0) // Yes, this for Login
                                    {
                                        isExist = arr[1];
                                        isLogin = arr[2];

                                        if(isExist.compareTo("false") == 0) // phone don't exist
                                        {
                                            JOptionPane.showMessageDialog(null, "You don't exist, Please Register");
                                            phoneReply = true;
                                            stage.getScene().setRoot(new Register(ps, dis, stage, _ip));

                                        }

                                        if(isExist.compareTo("true") == 0 && isLogin.compareTo("false") == 0) // Just password only is false
                                        {
                                            JOptionPane.showMessageDialog(null, "Please insert valied password");
                                            passReply = true;
                                        }

                                        if(isExist.compareTo("true") == 0 && isLogin.compareTo("true") == 0) // Login is true
                                        {
                                            passError.setDisable(true);
                                            phoneError.setDisable(true);
                                            passError.setText("");
                                            phoneError.setText("");
                                            userPhone = arr[3];
                                            System.out.println("userPhone = "+userPhone);

                                            stage.getScene().setRoot(new Users(stage, ps, dis, userPhone)); //Change it to online board
                                        }
                                    }
                                    else if(loginMsg.compareTo("registred") == 0) // Yes, user registered successfuly
                                    {
                                        userPhone = arr[1];
                                        stage.getScene().setRoot(new Users(stage, ps, dis, userPhone)); //Change it to online board
                                    }
                                    
                                    else if(loginMsg.compareTo("recieveReuest") == 0) 
                                    {
                                        
                                        if(userPhone.compareTo(arr[3]) == 0)
                                        {
                                            System.out.println("Recieved");
                                            Object[] options = { "Accept", "Reject" };
                                           //String reject = JOptionPane.showInputDialog("");
                                            JOptionPane optionPane = new JOptionPane();

                                            int input =  optionPane.showOptionDialog(null, arr[1], "Warning",JOptionPane.OK_OPTION, JOptionPane.OK_OPTION, null, options, options[0]);
                                       
                                            if(input== JOptionPane.OK_OPTION)
                                            {
                                               System.out.println("Accept");
                                               //(int _playRole,Stage stage, PrintStream ps, DataInputStream dis, String phone)
                                               //(String s1,String s2,boolean flagplayerR,boolean isrecord,Stage stage, PrintStream ps, DataInputStream dis) 
                                               playBord = new OnlineBoard(1, stage, ps, dis, userPhone,arr[2]);
                                               //playBord = new TwoPlayer(userPhone, arr[2], true, false, stage, ps, dis);
                                               stage.getScene().setRoot(playBord);
                                               ps.println("requestreplay,Accept," + arr[2] + "," +arr[3]);
                                            }
                                            else
                                            {
                                                System.out.println("rejected");
                                                ps.println("requestreplay,reject"+ arr[2] + "," +arr[3]);

                                            }
                                        }
                                    }
                                    
                                    else if(loginMsg.compareTo("replay") == 0) 
                                    {
                                        if(arr[1].compareTo(userPhone) == 0)
                                        {
                                            JOptionPane.showMessageDialog(null, "Your Request Rejected.! >_<");
                                            System.out.println("rejected");
                                        }
                                        
                                    }
                                    
                                    else if(loginMsg.compareTo("openBoardToPlay") == 0)
                                    {
                                        if(arr[1].compareTo(userPhone) == 0)
                                        {
                                            playBord = new OnlineBoard(2, stage, ps, dis, userPhone,arr[2]);
                                            //playBord = new TwoPlayer(userPhone, arr[2], true, false, stage, ps, dis);
                                            stage.getScene().setRoot(playBord);
                                        }
                                    }
                                    
                                    else if(loginMsg.compareTo("playingUser") == 0)
                                    {
                                        //"playingUser," + myPhone + "," + phoneOther + "," + playChar + ",1"
                                        if(arr[2].compareTo(userPhone) == 0)
                                            playBord.playGameListen(Integer.parseInt(arr[4]), arr[3]);
                                    }
                                    //"playVideos," + myPhone + "," + oppositePhone 
                                    else if(loginMsg.compareTo("playVideos") == 0)
                                    {
                                        
                                        if(arr[1].compareTo(userPhone) == 0)
                                        {
                                            int newScore = ++playBord.myScore;
                                            playBord.playWinnerVideo();
                                            playBord.setMyScore(newScore);
//                                            playBord.setOppositeScore(playBord.getOppositeScore());
                                        }
                                        
                                        if(arr[2].compareTo(userPhone) == 0)
                                        {
                                            int newScore = ++playBord.oppositeScore;
                                            playBord.playLoserVideo();
                                            playBord.setOppositeScore(newScore);
//                                            playBord.setMyScore(playBord.getMyScore());
                                        }
                                    }
                                    
                                    //gameReply
                                    else if(loginMsg.compareTo("gameReply") == 0)
                                    {
                                        if(arr[1].compareTo(userPhone) == 0 || arr[2].compareTo(userPhone) == 0)
                                        {
                                            playBord.replayGame();
                                        }
                                    }
                            } 
                            catch (IOException ex) 
                            {
                              //  Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                 stage.getScene().setRoot(new NoNet(stage));
                                  break;

                            }
                        }
                    }
                }).start();
            
                
        getChildren().add(imageView);
        getChildren().add(phoneNumber);
        getChildren().add(login);
        getChildren().add(back);
        getChildren().add(register);
        getChildren().add(phoneError);
        getChildren().add(passError);
        getChildren().add(password);

    }
}
