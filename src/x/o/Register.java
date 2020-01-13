package x.o;

import java.io.DataInputStream;
import java.io.File;
import java.io.PrintStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.ToggleGroup;

public class Register extends Pane {

    protected final Label tel_label;
    protected final TextField first_name_textfield;
    protected final Label last_name_label;
    protected final TextField last_name_textfield;
    protected final Label email_label;
    protected final TextField email_textfield;
    protected final Label password_label;
    protected final TextField password_textfield;
    protected final Label confirm_label;
    protected final TextField confirm_textfield;
    protected final Label gender_label;
    protected final Button register_button;
    protected final TextField tel_textfield;
    protected final Label last_name_label1;
    protected final RadioButton gender_radio_button;
    protected final RadioButton gender_radio_button0;
    protected final Label label_required_email;
    protected final Label label_required_tel;
    protected final Label label_required_confirm;
    protected final Label label_required_fn;
    protected final Label label_required_ln;
    protected final Label label_required_pass;
     protected final FileChooser file;
    protected final Button file_button;
    protected final ToggleGroup group ;


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
     
    public Register(PrintStream ps, DataInputStream dis) {

        group = new ToggleGroup();
        tel_label = new Label();
        first_name_textfield = new TextField();
        last_name_label = new Label();
        last_name_textfield = new TextField();
        email_label = new Label();
        email_textfield = new TextField();
        password_label = new Label();
        password_textfield = new TextField();
        confirm_label = new Label();
        confirm_textfield = new TextField();
        gender_label = new Label();
        register_button = new Button();
        tel_textfield = new TextField();
        last_name_label1 = new Label();
        gender_radio_button = new RadioButton();
        gender_radio_button0 = new RadioButton();
        label_required_email = new Label();
        label_required_tel = new Label();
        label_required_confirm = new Label();
        label_required_fn = new Label();
        label_required_ln = new Label();
        label_required_pass = new Label();
        file=new FileChooser();
        file_button=new Button("Upload Img");
        
        
        
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(437.0);
        setPrefWidth(570.0);

        tel_label.setLayoutX(21.0);
        tel_label.setLayoutY(253.0);
        tel_label.setPrefHeight(29.0);
        tel_label.setPrefWidth(75.0);
        tel_label.setText("Telephone");

        first_name_textfield.setLayoutX(136.0);
        first_name_textfield.setLayoutY(11.0);
        first_name_textfield.setPrefHeight(29.0);
        first_name_textfield.setPrefWidth(270.0);
        first_name_textfield.setPromptText("Enter your first name");


        last_name_label.setLayoutX(21.0);
        last_name_label.setLayoutY(57.0);
        last_name_label.setPrefHeight(29.0);
        last_name_label.setPrefWidth(56.0);
        last_name_label.setText("LastName");

        last_name_textfield.setLayoutX(136.0);
        last_name_textfield.setLayoutY(61.0);
        last_name_textfield.setPrefHeight(29.0);
        last_name_textfield.setPrefWidth(270.0);
        last_name_textfield.setPromptText("Enter your last name");
       

        email_label.setLayoutX(20.0);
        email_label.setLayoutY(107.0);
        email_label.setPrefHeight(29.0);
        email_label.setPrefWidth(56.0);
        email_label.setText("E-mail");

        email_textfield.setLayoutX(136.0);
        email_textfield.setLayoutY(108.0);
        email_textfield.setPrefHeight(29.0);
        email_textfield.setPrefWidth(270.0);
        email_textfield.setPromptText("Enter your Email");


        password_label.setLayoutX(19.0);
        password_label.setLayoutY(160.0);
        password_label.setPrefHeight(25.0);
        password_label.setPrefWidth(60.0);
        password_label.setText("Password");

        password_textfield.setLayoutX(136.0);
        password_textfield.setLayoutY(157.0);
        password_textfield.setPrefHeight(29.0);
        password_textfield.setPrefWidth(270.0);
        password_textfield.setPromptText("Enter your password");

        

        confirm_label.setLayoutX(17.0);
        confirm_label.setLayoutY(208.0);
        confirm_label.setPrefHeight(29.0);
        confirm_label.setPrefWidth(96.0);
        confirm_label.setText("Confirm Password");

        confirm_textfield.setLayoutX(136.0);
        confirm_textfield.setLayoutY(208.0);
        confirm_textfield.setPrefHeight(29.0);
        confirm_textfield.setPrefWidth(270.0);
        confirm_textfield.setPromptText("Confirm your password");
        
        
        gender_label.setLayoutX(21.0);
        gender_label.setLayoutY(301.0);
        gender_label.setPrefHeight(29.0);
        gender_label.setPrefWidth(75.0);
        gender_label.setText("Gender");

        register_button.setLayoutX(234.0);
        register_button.setLayoutY(383.0);
        register_button.setMnemonicParsing(false);
        register_button.setPrefHeight(40.0);
        register_button.setPrefWidth(75.0);
        register_button.setText("Register");

         file_button.setLayoutX(20.0);
        file_button.setLayoutY(340.0);
        file_button.setMnemonicParsing(false);
        file_button.setPrefHeight(35.0);
        file_button.setPrefWidth(85.0);
        
        tel_textfield.setLayoutX(136.0);
        tel_textfield.setLayoutY(253.0);
        tel_textfield.setPrefHeight(29.0);
        tel_textfield.setPrefWidth(270.0);
        tel_textfield.setPromptText("Enter your phone number");

        last_name_label1.setLayoutX(21.0);
        last_name_label1.setLayoutY(11.0);
        last_name_label1.setPrefHeight(29.0);
        last_name_label1.setPrefWidth(59.0);
        last_name_label1.setText("FirstName");

        gender_radio_button.setLayoutX(136.0);
        gender_radio_button.setLayoutY(303.0);
        gender_radio_button.setMnemonicParsing(false);
        gender_radio_button.setPrefHeight(29.0);
        gender_radio_button.setPrefWidth(59.0);
        gender_radio_button.setText("Male");
        gender_radio_button.setToggleGroup(group);
        

        gender_radio_button0.setFocusTraversable(true);
        gender_radio_button0.setLayoutX(242.0);
        gender_radio_button0.setLayoutY(305.0);
        gender_radio_button0.setMnemonicParsing(false);
        gender_radio_button0.setPrefHeight(29.0);
        gender_radio_button0.setPrefWidth(59.0);
        gender_radio_button0.setText("Female");
        gender_radio_button0.setToggleGroup(group);
        

        label_required_email.setDisable(true);
        label_required_email.setLayoutX(138.0);
        label_required_email.setLayoutY(138.0);
        label_required_email.setPrefHeight(17.0);
        label_required_email.setPrefWidth(270.0);

        label_required_tel.setDisable(true);
        label_required_tel.setLayoutX(136.0);
        label_required_tel.setLayoutY(282.0);
        label_required_tel.setPrefHeight(17.0);
        label_required_tel.setPrefWidth(270.0);

        label_required_confirm.setDisable(true);
        label_required_confirm.setLayoutX(136.0);
        label_required_confirm.setLayoutY(232.0);
        label_required_confirm.setPrefHeight(17.0);
        label_required_confirm.setPrefWidth(270.0);

        label_required_fn.setDisable(true);
        label_required_fn.setLayoutX(136.0);
        label_required_fn.setLayoutY(40.0);
        label_required_fn.setPrefHeight(17.0);
        label_required_fn.setPrefWidth(270.0);

        label_required_ln.setDisable(true);
        label_required_ln.setLayoutX(136.0);
        label_required_ln.setLayoutY(90.0);
        label_required_ln.setPrefHeight(17.0);
        label_required_ln.setPrefWidth(270.0);

        label_required_pass.setDisable(true);
        label_required_pass.setLayoutX(136.0);
        label_required_pass.setLayoutY(186.0);
        label_required_pass.setPrefHeight(17.0);
        label_required_pass.setPrefWidth(270.0);

        getChildren().add(tel_label);
        getChildren().add(first_name_textfield);
        getChildren().add(last_name_label);
        getChildren().add(last_name_textfield);
        getChildren().add(email_label);
        getChildren().add(email_textfield);
        getChildren().add(password_label);
        getChildren().add(password_textfield);
        getChildren().add(confirm_label);
        getChildren().add(confirm_textfield);
        getChildren().add(gender_label);
        getChildren().add(register_button);
        getChildren().add(tel_textfield);
        getChildren().add(last_name_label1);
        getChildren().add(gender_radio_button);
        getChildren().add(gender_radio_button0);
        getChildren().add(label_required_email);
        getChildren().add(label_required_tel);
        getChildren().add(label_required_confirm);
        getChildren().add(label_required_fn);
        getChildren().add(label_required_ln);
        getChildren().add(label_required_pass);
        getChildren().add(file_button);
         
         
         Stage s = null;
        file_button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
         
            @Override
            public void handle(ActionEvent event) {
                
                File selectedFile= file.showOpenDialog(s);
            }
        });
        
        
        register_button.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                if(tel_textfield.getText().isEmpty())
                {
                    label_required_tel.setDisable(false);
                    label_required_tel.setText("* you should Enter your phone");
                    label_required_tel.setTextFill(javafx.scene.paint.Color.RED);
                }
                
                else if(!(isValidate(tel_textfield.getText())))
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
                            tel_textfield.getText()+ "," +
                            gender);
                    //System.out.println();
                }
            }
        }); 
    }
}
