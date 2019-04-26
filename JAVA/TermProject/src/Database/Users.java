package Database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Database.DatabaseHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;



public class Users {
    
    public Users(){}
    Connection conn = DatabaseHandler.getConnection(); 
    
   
    
    public ResultSet getUser(String userEmail, String Password)
    {
        PreparedStatement preparedStatement = null;
        
        try {
            ResultSet resultSet;
            String countRecords = "SELECT * FROM Users where UserEmail = ?";
            
            preparedStatement = conn.prepareStatement(countRecords);
            
            preparedStatement.setString(1, userEmail);
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                ResultSet user = selectUser(userEmail,Password);
                System.out.println("This is in getUser method");
                System.out.println(user);
                return user;
            }
            
        } catch (Exception e) {
            System.out.println("ERROR, Cant get user : " + e.getMessage());
        }
        
        return null;
        
    }

    public ResultSet selectUser(String userEmail, String Password) throws SQLException {
       
        PreparedStatement preparedStatement = null;
        
        String insertQuery = "SELECT * FROM USERS WHERE UserEmail = ? AND UserPassword = ?";
            
            preparedStatement = conn.prepareStatement(insertQuery);
            
            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, Password);
            
            
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            System.out.println("This is selected user : " + result.getString("FName"));
            return result;
    }
    
    public boolean insertUser(String fName, String lName,String userEmail,String userPassword,int userType)
    {
        PreparedStatement preparedStatement = null;
        
        try {
            ResultSet resultSet;
            String countEmails = "SELECT COUNT(*) FROM Users where UserEmail = ?";
            preparedStatement = conn.prepareStatement(countEmails);
            preparedStatement.setString(1, userEmail);
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                if(resultSet.getInt(1) > 0)
                return false;
            }
            
            String userId = UUID.randomUUID().toString();
            
            String insertQuery = "INSERT INTO USERS (UserId,FName,LName,UserEmail,UserPassword,UserType) VALUES(?,?,?,?,?,?)";
            
            preparedStatement = conn.prepareStatement(insertQuery);
            
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, fName);
            preparedStatement.setString(3, lName);
            preparedStatement.setString(4, userEmail);
            preparedStatement.setString(5, userPassword);            
            preparedStatement.setInt(6, userType);
            
            int result = preparedStatement.executeUpdate();
            
            return (result == 1);
            
        } catch (Exception e) {
            System.out.println("Inset User Exception : " + e.getMessage());
        }
        
        return true;
    }
    
    
    
}
