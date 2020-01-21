/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.mysql.cj.jdbc.Driver;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author oem
 */
public class Server {
    
    ServerSocket myServerSocket;
    Socket s;
    
    public static void main(String[] args) {
        try {
            Driver myDriver = new Driver();
            DriverManager.registerDriver(myDriver);
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/xo", "root", "ashraf");

            Statement stmt = myConnection.createStatement();
            new Server(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Server(Statement stmt)
    {
        try {
            myServerSocket = new ServerSocket(5005);     
            while(true){
                
                s = myServerSocket.accept();
                new UserCheck(s, stmt);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       /* try 
        {
            ps.close();
            dis.close();
            s.close();
            myServerSocket.close();
        }
        catch( Exception ex)
        {

        ex.printStackTrace();
        }*/

    }
}


class UserCheck extends Thread
{
    DataInputStream dis;
    PrintStream ps;
    Statement stmt;
    String phone;
    public UserCheck(Socket s, Statement _stmt)
    {
        try {
            dis = new DataInputStream(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(UserCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        stmt = _stmt;
        start();  
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            String loginUser;
            boolean isExist = false; // Check registeration
            boolean passTrue = false; // Check Login
            String loginPhone="" ;

             
            try {
                
                loginUser = dis.readLine();
                if(loginUser != null)
                {
                    String[] arr = loginUser.split(",");
                    String state = arr[0];
                    
                    if(state.compareTo("login") == 0) // Data come from login Form
                    {
                        loginPhone = arr[1];
                        String loginPass = arr[2];
                        String query = "SELECT * FROM users";
                        ResultSet res = stmt.executeQuery(query);

                        while(!res.isLast())
                        {
                            if(res.next())
                            {
                                if(res.getString(5).compareTo(loginPhone) == 0)
                                {
                                    isExist = true; // yes it is registered
                                    System.out.println("user logined is : "+phone);
                                    if(res.getString(4).compareTo(loginPass) == 0)
                                    {
                                        passTrue = true; // Check entered new pass or not
                                        phone=res.getString(5);
                                    }
                                }                               
                            }
                        }

                        if(isExist && passTrue)
                        {
                            String updateState = "update users set state = 'online'" + " Where phone =" + loginPhone;
                            stmt.executeUpdate(updateState);
                        }
                        ps.println("login," + isExist + "," + passTrue +"," + phone); // send to logined user
                        System.out.println(phone);
                        System.out.println(loginPhone);
                        System.out.println(loginPass);
                    }
                    
                    else if(state.compareTo("register") == 0) // Data come from Register Form
                    {
                        phone = arr[4];
                        String addNewUser = "INSERT INTO users(username, email, password, phone, gender, img_url, total_score, state) VALUES('"+arr[1]+"', '"+arr[2]+"', '"+arr[3]+"', '"+arr[4]+"', '"+arr[5]+"', 'image url', 0, 'online')";
                        stmt.executeUpdate(addNewUser);
                        ps.println("registred," + phone); // send to registered user
                        System.out.println(phone + "  registred");
                    }
                    
                    else if(state.compareTo("requestUsers") == 0)
                    {
                        String users = "onlineUsers";
                        ResultSet onlineUsers = stmt.executeQuery("SELECT * FROM users");
                        while(onlineUsers.next())
                        {
                            users = users.concat("," + onlineUsers.getString(2) + "." + onlineUsers.getString(1));
                        }
                        ps.println(users);
                    }
                    
                   
                    else if(state.compareTo("requestPlay") == 0)
                    {
                        System.out.println(arr[1]);
                        String userSendRequest = arr[1];
                        String userReq = "", sendReq = "", userRecieveRequest = "";
                        String requesteduser = arr[2];
                        String[] arrsplit = requesteduser.split("\\.");
                        int id = Integer.parseInt(arrsplit[1]) ;
                        
                        System.out.println(id + "** send:" + userSendRequest + "*** to:" + requesteduser);
                        
                        ResultSet resultRequest = stmt.executeQuery("SELECT username,phone FROM users WHERE id = " + id);

                        while(resultRequest.next())
                        {
                           
                            userReq = resultRequest.getString("username");
                            userRecieveRequest = resultRequest.getString("phone");
                        }
                        
                        ResultSet loginedName = stmt.executeQuery("select username from users where phone = " + userSendRequest);

                        while(loginedName.next())
                        {
                            sendReq = loginedName.getString("username");
                        }
                        
                        System.out.println("recieveReuest,request from  " + sendReq + " to " + userReq + "," + userSendRequest + "," + userRecieveRequest);
                        ps.println("recieveReuest,request from  " + sendReq + " to " + userReq + "," + userSendRequest + "," + userRecieveRequest);
                    }
                    
                    else if(state.compareTo("requestreplay") == 0)
                    {
                        
                        System.out.println(arr[1]);
                        if (arr[1]=="Accept")
                        {
                            // Start Playing
                        }
                        
                        else 
                            
                        {
                            //ps.println("replay," + arr[2]);
                        }
                    }
                    
                }
        
            } catch (IOException | SQLException ex) {
                Logger.getLogger(UserCheck.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
