/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Titan
 */
public class DatabaseHandler {
    
    private static Connection conn = null;   
    
    private static DatabaseHandler handler = null;
    
    private DatabaseHandler()
    {
        createConection();
    }
    
    private static void createConection()
    {
        try
        {
            String user = "root";
            String password = "admin";
            String port = "3306";
            String path = "jdbc:mysql://localhost:"+port+"/readandlearn";
            
            conn = DriverManager.getConnection(path,user,password);
            System.out.println("Connected!");
            
        }
        catch(Exception e)
        {
            System.out.println("Create connection exception :"+ e.getMessage());
        }
    }
    
   
    public static Connection getConnection()
    {
        if(conn == null)
        {
           createConection();
        }
        return conn;
    }
    
    /**
     * This method inserts new registered users into database.
     */
    
    
    
    
}
