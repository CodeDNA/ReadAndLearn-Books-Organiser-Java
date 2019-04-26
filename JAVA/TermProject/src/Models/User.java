/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Titan
 */
public class User {
    
    /*User user = new User(loggedInUser.getString("userId"),loggedInUser.getString("firstName") ,
            loggedInUser.getString("lastName") ,loggedInUser.getString("userEmail") ,loggedInUser.getString("userPassword"),loggedInUser.getInt("UserType"));*/
    
    public static User currentUser; 
    String userId , firstName, lastName, userEmail, userPassword;
    int userType;

    public User(String userId, String firstName, String lastName, String userEmail, String userPassword, int userType) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        //User.currentUser=new User("","","","","")
    }
public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
