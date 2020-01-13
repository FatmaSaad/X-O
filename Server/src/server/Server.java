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
<<<<<<< HEAD
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/xo", "root", "234234");
=======
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/xo", "root", "root");
>>>>>>> c97433aadcd5032debc06d9e08160be255f628c4
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
    String msg;
    DataInputStream dis;
    PrintStream ps;
    Statement stmt;
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
            String msg;
             boolean isExist = false; // Check registeration
             boolean passTrue = false; // Check Login
             
            try {
                loginUser = dis.readLine();
                String[] arr = loginUser.split(",");

                String state = arr[0];
                
                if(state.compareTo("login") == 0) // Data come from login Form
                {
                    String loginPhone = arr[1];
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

                                if(res.getString(4).compareTo(loginPass) == 0)
                                   passTrue = true; // Check entered new pass or not
                            }                               
                        }
                    }

                    if(isExist && passTrue)
                    {
                        String updateState = "update users set state = 'online'" + " Where phone =" + loginPhone;
                        stmt.executeUpdate(updateState);
                    }
                    ps.println(isExist + "," + passTrue);
                    System.out.println(loginPhone);
                    System.out.println(loginPass);
                }
                else if(state.compareTo("register") == 0) // Data come from Register Form
                {
                    String addNewUser = "INSERT INTO users(username, email, password, phone, gender, img_url, total_score, state) VALUES('"+arr[1]+"', '"+arr[2]+"', '"+arr[3]+"', '"+arr[4]+"', '"+arr[5]+"', 'image url', 0, 'online')";
                    stmt.executeUpdate(addNewUser);
                    ps.println("registred");
                    System.out.println("registred");
                }
        
           
               msg =(dis.readLine()).toString();
               System.out.println(msg);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(UserCheck.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
}
