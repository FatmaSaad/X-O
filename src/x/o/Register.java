package x.o;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Register extends Pane {

    protected final ImageView imgPaneRegister;
    protected final ColorAdjust colorAdjust;
    protected final Label label;
    protected final TextField first_name_textfield;
    protected final Label label_required_fn;
    protected final Label label0;
    protected final TextField last_name_textfield;
    protected final Label label_required_ln;
    protected final Label label1;
    protected final TextField email_textfield;
    protected final Label label_required_email;
    protected final Label label2;
    protected final TextField tel_textfiield;
    protected final Label label_required_tel;
    protected final Label label3;
    protected final TextField password_textfield;
    protected final Label label_required_pass;
    protected final Label label4;
    protected final TextField confirm_textfield;
    protected final Label label_required_confirm;
    protected final Label label5;
    protected final RadioButton male_btn;
    protected final RadioButton female_btn;
    protected final Button button;
    protected final Button button_back;
        
    protected final ToggleGroup group ;

    String ipadd;
    public static boolean isValidate(String phone_num) {
        Pattern p = Pattern.compile("\\d{11}");
        Matcher m =p.matcher(phone_num);
        return (m.find() && m.group().equals(phone_num)); 
    
    }
    
    public static boolean firstNameValidate( String firstName ) {
        String regx = "[a-zA-Z]+\\.?";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.find();

   }

     public static boolean lastNameValidate( String firstName ) {
        String regx = "[a-zA-Z]+\\.?";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.find();

   }
     public static boolean passwdValidate( String passwd ) {
        Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}",Pattern.CASE_INSENSITIVE);
        Matcher matcher =pattern.matcher(passwd);
        return matcher.find();
     }
     
      public static boolean emailValidate( String email ) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$",Pattern.CASE_INSENSITIVE);
        Matcher matcher =pattern.matcher(email);
        return matcher.find();
     }
      
    public Register(PrintStream ps, DataInputStream dis, Stage stage, String _ip) {

        ipadd = _ip;
        group = new ToggleGroup();
        imgPaneRegister = new ImageView();
        colorAdjust = new ColorAdjust();
        label = new Label();
        first_name_textfield = new TextField();
        label_required_fn = new Label();
        label0 = new Label();
        last_name_textfield = new TextField();
        label_required_ln = new Label();
        label1 = new Label();
        email_textfield = new TextField();
        label_required_email = new Label();
        label2 = new Label();
        tel_textfiield = new TextField();
        label_required_tel = new Label();
        label3 = new Label();
        password_textfield = new TextField();
        label_required_pass = new Label();
        label4 = new Label();
        confirm_textfield = new TextField();
        label_required_confirm = new Label();
        label5 = new Label();
        male_btn = new RadioButton();
        female_btn = new RadioButton();
        button = new Button();
        button_back = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(414.0);
        setPrefWidth(717.0);

        imgPaneRegister.setFitHeight(365.0);
        imgPaneRegister.setFitWidth(315.0);
        imgPaneRegister.setLayoutX(338.0);
        imgPaneRegister.setLayoutY(24.0);
        imgPaneRegister.setPickOnBounds(true);
        imgPaneRegister.setPreserveRatio(true);
        imgPaneRegister.setRotate(20.0);
        imgPaneRegister.setImage(new Image(getClass().getResource("media/paneback.jpeg").toExternalForm()));

        imgPaneRegister.setEffect(colorAdjust);

        label.setLayoutX(25.0);
        label.setLayoutY(21.0);
        label.setPrefHeight(20.0);
        label.setPrefWidth(72.0);
        label.setText("FirstName :");

        first_name_textfield.setFocusTraversable(false);
        first_name_textfield.setLayoutX(144.0);
        first_name_textfield.setLayoutY(19.0);
        first_name_textfield.setPrefHeight(25.0);
        first_name_textfield.setPrefWidth(239.0);
        first_name_textfield.setPromptText("Enter your firstName");
        first_name_textfield.setStyle("-fx-background-color: none; -fx-border-color: black;");

        label_required_fn.setDisable(true);
        label_required_fn.setLayoutX(144.0);
        label_required_fn.setLayoutY(43.0);
        label_required_fn.setPrefHeight(17.0);
        label_required_fn.setPrefWidth(239.0);

        label0.setLayoutX(25.0);
        label0.setLayoutY(64.0);
        label0.setPrefHeight(20.0);
        label0.setPrefWidth(72.0);
        label0.setText("lastName :");

        last_name_textfield.setFocusTraversable(false);
        last_name_textfield.setLayoutX(144.0);
        last_name_textfield.setLayoutY(64.0);
        last_name_textfield.setPrefHeight(25.0);
        last_name_textfield.setPrefWidth(239.0);
        last_name_textfield.setPromptText("Enter your lastName");
        last_name_textfield.setStyle("-fx-background-color: none; -fx-border-color: black;");

        label_required_ln.setDisable(true);
        label_required_ln.setLayoutX(144.0);
        label_required_ln.setLayoutY(89.0);
        label_required_ln.setPrefHeight(17.0);
        label_required_ln.setPrefWidth(239.0);

        label1.setLayoutX(28.0);
        label1.setLayoutY(108.0);
        label1.setPrefHeight(20.0);
        label1.setPrefWidth(55.0);
        label1.setText("Email :");

        email_textfield.setFocusTraversable(false);
        email_textfield.setLayoutX(144.0);
        email_textfield.setLayoutY(107.0);
        email_textfield.setPrefHeight(25.0);
        email_textfield.setPrefWidth(239.0);
        email_textfield.setPromptText("Enter your Email");
        email_textfield.setStyle("-fx-background-color: none; -fx-border-color: black;");

        label_required_email.setDisable(true);
        label_required_email.setLayoutX(144.0);
        label_required_email.setLayoutY(132.0);
        label_required_email.setPrefHeight(17.0);
        label_required_email.setPrefWidth(239.0);

        label2.setLayoutX(28.0);
        label2.setLayoutY(151.0);
        label2.setPrefHeight(20.0);
        label2.setPrefWidth(72.0);
        label2.setText("Telephone :");

        tel_textfiield.setFocusTraversable(false);
        tel_textfiield.setLayoutX(144.0);
        tel_textfiield.setLayoutY(151.0);
        tel_textfiield.setPrefHeight(25.0);
        tel_textfiield.setPrefWidth(239.0);
        tel_textfiield.setPromptText("Enter your phone");
        tel_textfiield.setStyle("-fx-background-color: none; -fx-border-color: black;");

        label_required_tel.setDisable(true);
        label_required_tel.setLayoutX(144.0);
        label_required_tel.setLayoutY(176.0);
        label_required_tel.setPrefHeight(17.0);
        label_required_tel.setPrefWidth(239.0);

        label3.setLayoutX(28.0);
        label3.setLayoutY(197.0);
        label3.setPrefHeight(20.0);
        label3.setPrefWidth(72.0);
        label3.setText("Password :");

        password_textfield.setFocusTraversable(false);
        password_textfield.setLayoutX(144.0);
        password_textfield.setLayoutY(195.0);
        password_textfield.setPrefHeight(25.0);
        password_textfield.setPrefWidth(239.0);
        password_textfield.setPromptText("Enter your password");
        password_textfield.setStyle("-fx-background-color: none; -fx-border-color: black;");

        label_required_pass.setDisable(true);
        label_required_pass.setLayoutX(144.0);
        label_required_pass.setLayoutY(220.0);
        label_required_pass.setPrefHeight(17.0);
        label_required_pass.setPrefWidth(239.0);

        label4.setLayoutX(28.0);
        label4.setLayoutY(239.0);
        label4.setPrefHeight(20.0);
        label4.setPrefWidth(108.0);
        label4.setText("Confirm Password :");

        confirm_textfield.setFocusTraversable(false);
        confirm_textfield.setLayoutX(144.0);
        confirm_textfield.setLayoutY(237.0);
        confirm_textfield.setPrefHeight(25.0);
        confirm_textfield.setPrefWidth(239.0);
        confirm_textfield.setPromptText("confirm your password");
        confirm_textfield.setStyle("-fx-background-color: none; -fx-border-color: black;");

        label_required_confirm.setDisable(true);
        label_required_confirm.setLayoutX(144.0);
        label_required_confirm.setLayoutY(262.0);
        label_required_confirm.setPrefHeight(17.0);
        label_required_confirm.setPrefWidth(239.0);

        label5.setLayoutX(28.0);
        label5.setLayoutY(287.0);
        label5.setPrefHeight(20.0);
        label5.setPrefWidth(98.0);
        label5.setText("Gender :");

        male_btn.setLayoutX(144.0);
        male_btn.setLayoutY(289.0);
        male_btn.setMnemonicParsing(false);
        male_btn.setPrefHeight(25.0);
        male_btn.setPrefWidth(55.0);
        male_btn.setText("Male");
        male_btn.setToggleGroup(group);
        
        female_btn.setLayoutX(264.0);
        female_btn.setLayoutY(289.0);
        female_btn.setMnemonicParsing(false);
        female_btn.setPrefHeight(25.0);
        female_btn.setPrefWidth(79.0);
        female_btn.setText("Female");
        female_btn.setToggleGroup(group);

        button.setLayoutX(150.0);
        button.setLayoutY(342.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(47.0);
        button.setPrefWidth(98.0);
        button.setStyle("-fx-background-color: none; -fx-border-color: black;");
        button.setText("Register");
        button.setFont(new Font("Arial Rounded MT Bold", 14.0));
        
        
        
        button_back.setLayoutX(350.0);
        button_back.setLayoutY(342.0);
        button_back.setMnemonicParsing(false);
        button_back.setPrefHeight(47.0);
        button_back.setPrefWidth(98.0);
        button_back.setStyle("-fx-background-color: none; -fx-border-color: black;");
        button_back.setText("Back");
        button_back.setFont(new Font("Arial Rounded MT Bold", 14.0));
        

        getChildren().add(imgPaneRegister);
        getChildren().add(label);
        getChildren().add(first_name_textfield);
        getChildren().add(label_required_fn);
        getChildren().add(label0);
        getChildren().add(last_name_textfield);
        getChildren().add(label_required_ln);
        getChildren().add(label1);
        getChildren().add(email_textfield);
        getChildren().add(label_required_email);
        getChildren().add(label2);
        getChildren().add(tel_textfiield);
        getChildren().add(label_required_tel);
        getChildren().add(label3);
        getChildren().add(password_textfield);
        getChildren().add(label_required_pass);
        getChildren().add(label4);
        getChildren().add(confirm_textfield);
        getChildren().add(label_required_confirm);
        getChildren().add(label5);
        
        getChildren().add(male_btn);
        getChildren().add(female_btn);
        getChildren().add(button);
        getChildren().add(button_back);
        
        
          button.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                if(tel_textfiield.getText().isEmpty())
                {
                    label_required_tel.setDisable(false);
                    label_required_tel.setText("* you should Enter your phone");
                    label_required_tel.setTextFill(javafx.scene.paint.Color.RED);
                }
                
                else if(!(isValidate(tel_textfiield.getText())))
                {
                        
                    label_required_tel.setDisable(false);
                    label_required_tel.setText("* you should Enter a valid phonenumber");
                    label_required_tel.setTextFill(javafx.scene.paint.Color.RED);
                }
                else  
                { 
                    // ba2e yro7 ll login
                    label_required_tel.setText("");
                    label_required_tel.setDisable(true);

                }
                
                if(first_name_textfield.getText().isEmpty())
                {
                    label_required_fn.setDisable(false);
                    label_required_fn.setText("* You should enter your Fname");
                    label_required_fn.setTextFill(javafx.scene.paint.Color.RED);                
                }
                else if((firstNameValidate(first_name_textfield.getText())))
                {
                    label_required_fn.setText(" ");
                    label_required_fn.setDisable(true);
                }
                else
                {
                    label_required_fn.setDisable(false);
                    label_required_fn.setText("* You should enter valid Fname");
                    label_required_fn.setTextFill(javafx.scene.paint.Color.RED);
                }
            
                if(last_name_textfield.getText().isEmpty())
                {
                    label_required_ln.setDisable(false);
                    label_required_ln.setText("* You should enter your lname");
                    label_required_ln.setTextFill(javafx.scene.paint.Color.RED);
                }
                else if((lastNameValidate(last_name_textfield.getText())))
                {
                    label_required_ln.setText(" ");
                    label_required_ln.setDisable(true);
                        
                }
                else
                {
                    label_required_ln.setDisable(false);
                    label_required_ln.setText("* You should enter valid lname");
                    label_required_ln.setTextFill(javafx.scene.paint.Color.RED);
                         
                }
                
                if(password_textfield.getText().isEmpty())
                {

                    label_required_pass.setDisable(false);
                    label_required_pass.setText("* You should enter your Password");
                    label_required_pass.setTextFill(javafx.scene.paint.Color.RED);
                }
                else if(passwdValidate(password_textfield.getText()))
                {
            
                    label_required_pass.setDisable(true);
                    label_required_pass.setText(" ");
                }
                else 
                {
            
                    label_required_pass.setDisable(false);
                    label_required_pass.setText("* digits , char, specialChar");
                    label_required_pass.setTextFill(javafx.scene.paint.Color.RED);
                }

                if((password_textfield.getText().equals( confirm_textfield.getText())))
                {
                    label_required_confirm.setDisable(true);
                    label_required_confirm.setText(" ");  
                }
                else
                {
                    label_required_confirm.setDisable(false);
                    label_required_confirm.setText("* you should match your password");
                    label_required_confirm.setTextFill(javafx.scene.paint.Color.RED);
                }
                
                if(email_textfield.getText()==null)
                {
                    label_required_email.setDisable(false);
                    label_required_email.setText("Enter your E-mail");
                    label_required_email.setTextFill(javafx.scene.paint.Color.RED);
                }
                else if(!(emailValidate(email_textfield.getText())))
                {
                    label_required_email.setDisable(false);
                    label_required_email.setText("Enter validate E-mail 'char@char.com'");
                    label_required_email.setTextFill(javafx.scene.paint.Color.RED);
                }
                else
                {
                
                    String gender;
                    System.out.println(group.getSelectedToggle().getUserData());
                    if(group.toString().compareTo("Female") == 0)
                        gender = "f";
                    else
                        gender = "m";
                        
                    label_required_email.setDisable(true);
                    label_required_email.setText("");
                    System.out.println(gender);
                    ps.println("register," + 
                            first_name_textfield.getText() + "," + 
                            email_textfield.getText() + "," +
                            password_textfield.getText() + "," +
                            tel_textfiield.getText()+ "," +
                            gender);
                }
            }
        });
          
           button_back.setOnAction((ActionEvent event) -> {

            stage.getScene().setRoot(new Login(stage , ipadd));

        });

    }
}

        

    

