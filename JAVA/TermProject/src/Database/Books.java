/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;


public class Books {
    Connection conn;
    
    public Books()
    {
        conn = DatabaseHandler.getConnection();
    }
    
    
    public ResultSet getBooksRead(String userId)
    {
        PreparedStatement preparedStatement = null;
        
        try {
            ResultSet resultSet;
            String readBooks = "SELECT * from books b, booksread bra where bra.UserId = ? and b.BookId=bra.BookId";
            preparedStatement = conn.prepareStatement(readBooks);
            preparedStatement.setString(1, userId);
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                if(resultSet.getInt(1) > 0)
                return resultSet;
            }
            
        } 
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return null;
    }
    
    public ResultSet getBookDetails(String BookId)
    {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        
        try {            
            String readBooks = "SELECT * from books where BookId = ?";
            preparedStatement = conn.prepareStatement(readBooks);
            preparedStatement.setString(1, BookId);
            
            resultSet = preparedStatement.executeQuery(readBooks);
            System.out.println("idha bhi pahuncha");
            if(resultSet.next())
            {
                System.out.println("idha bhi pahuncha");
                if(resultSet.getInt(1) >= 0)
                return resultSet;
            }
            
        } 
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        System.out.println("null dera ab");
        return null;
    }
    
  public boolean deleteBook(String bookName)
  {
      PreparedStatement preparedStatement = null;
      try {
            String insertQuery = "Delete from Books where Bookname = ?";
            
            preparedStatement = conn.prepareStatement(insertQuery);
            
            preparedStatement.setString(1, bookName);
            
            int result = preparedStatement.executeUpdate();
            
            return (result == 1);
      
        }
        
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return false; 
      
      
  }
    
    public boolean insertNewBook(String bookName, String author, String bookDescription)
    {
        PreparedStatement preparedStatement = null;
        
        try {

            String bookId = UUID.randomUUID().toString();
            
            String insertQuery = "INSERT INTO Books VALUES (?,?,?,?,?,CURDATE())";
            
            preparedStatement = conn.prepareStatement(insertQuery);
            
            preparedStatement.setString(1, bookId);
            preparedStatement.setString(2, bookName);
            preparedStatement.setString(3, author);
            preparedStatement.setString(4, User.currentUser.getFirstName());
            preparedStatement.setString(5, bookDescription);
            
            int result = preparedStatement.executeUpdate();
            
            return (result == 1);
      
        }
        
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return false; 
    }
    
    
    public ResultSet getBookTags(String BookId)
    {
        PreparedStatement preparedStatement = null;
        
        try {
            ResultSet resultSet; //356416325463546354635426dfgaidfs guybasiuedrfgthbsodijfhgblskdfjhgbslkdfgbsdfg
            String readBooks = "SELECT t.TagName from booktags bt, tags t where bt.BookId = \"123\" and bt.tagid = t.tagid"; //dfgsdfgsdfgsdfgdsfg
            preparedStatement = conn.prepareStatement(readBooks);
            preparedStatement.setString(1, BookId);
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                if(resultSet.getInt(1) > 0)
                return resultSet;
            }
            
        } 
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return null;
    }
    
    public ResultSet getBookReaders(String BookId)
    {
       PreparedStatement preparedStatement = null;
        
        try {
            ResultSet resultSet;
            String readBooks = "SELECT Fname from Users"; //query?????????????
            preparedStatement = conn.prepareStatement(readBooks);
            preparedStatement.setString(1, BookId);
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                if(resultSet.getInt(1) > 0)
                return resultSet;
            }
            
        } 
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return null;
    }
    
    public ResultSet getBookCourses(String BookId)
    {
        PreparedStatement preparedStatement = null;
        
        try {
            ResultSet resultSet;
            String readBooks = "SELECT TagName from books b, tags t where BookId = ? and b."; //query?????????????
            preparedStatement = conn.prepareStatement(readBooks);
            preparedStatement.setString(1, BookId);
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                if(resultSet.getInt(1) > 0)
                return resultSet;
            }
            
        } 
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return null;
    }
    
    public boolean insertIntoBooksRead(String BookId, String UserId)
    {
       PreparedStatement preparedStatement = null;
        
        try {
            ResultSet resultSet;
            String readBooks = "INSERT into BooksRead (UserId, BookId) VALUES(?,?)"; //query?????????????
            preparedStatement = conn.prepareStatement(readBooks);
            preparedStatement.setString(1, UserId);
            preparedStatement.setString(2, BookId);
            preparedStatement.executeUpdate();
            return true;            
        }
        
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return false; 
    }
    
    public boolean addToWishlist(String BookId, String UserId)
    {//insert into wishlist (userid, bookid,dateadded) values ("84650e5a-fe33-464f-a2b1-b865d1b64279", "abc-bce", CURDATE() );
        PreparedStatement preparedStatement = null;
        
        try {
            ResultSet resultSet;
            String readBooks = "insert into wishlist (userid, bookid,dateadded) values (?, ?, CURDATE() )";
            preparedStatement = conn.prepareStatement(readBooks);
            preparedStatement.setString(1, UserId);
            preparedStatement.setString(2, BookId);
            preparedStatement.executeUpdate();
            return true;            
        }
        
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return false; 
        
        
    }

    
//----------------------SEARCH QUERIESZ-----------------------------------------------------
      public String getBookName(String str)
    {
        Statement stmt = null;
        
        try {
            
            String query = "Select BookName from Books where Bookname LIKE '"+str+"'";
            ResultSet resultSet;
                       
            resultSet = stmt.executeQuery(query);
            System.out.println(resultSet.getString("Bookname"));
            while(resultSet.next())
            return (resultSet.getString("Bookname"));
      
        }
        
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return ""; 
    }
    
    public ResultSet searchBookByName(String BookName)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            
            String readBooks = "SELECT * from books where BookName LIKE ?";
            preparedStatement = conn.prepareStatement(readBooks);
            
            preparedStatement.setString(1,"%"+ BookName+"%");
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                    resultSet.previous();
                    return resultSet;
                            
            }
            
        } 
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return null;
        
    }
    
   /* public ResultSet searchBookByType(String BookType)
    {
        
        PreparedStatement preparedStatement = null;
        
        try {
            ResultSet resultSet;
            String readBooks = "SELECT * from books where BookType = ?";
            preparedStatement = conn.prepareStatement(readBooks);
            preparedStatement.setString(1, BookType);
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                if(resultSet.getInt(1) > 0)
                return resultSet;
            }
            
        } 
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return null;
        
    }*/
    
    public ResultSet searchBookByCourseName(String CourseName)
    {
        
        PreparedStatement preparedStatement = null;
        
        try {
            ResultSet resultSet;
            String readBooks = "SELECT B.BookId,B.BookName,B.Author,B.Professor,B.BookDescription,B.DateAdded from books B " +
                                "Inner join coursebook CB on CB.BookId = B.BookId " +
                                "Inner join courses C on C.CourseId = CB.CourseId where c.CourseName like ?";
            preparedStatement = conn.prepareStatement(readBooks);
            preparedStatement.setString(1,"%" + CourseName + "%");
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                if(resultSet.getInt(1) > 0)
                return resultSet;
            }
            
        } 
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return null;
        
    }
    
    public ResultSet searchBookByTags(String TagName)
    {
        
        PreparedStatement preparedStatement = null;
        
        try {
            ResultSet resultSet;
            String readBooks = "SELECT B.BookId,B.BookName,B.Author,B.Professor,B.BookDescription,B.DateAdded from books B " +
                                "Inner join Booktags BT on BT.BookId = B.BookId " +
                                "Inner join Tags T on T.TagID = BT.TagID where T.TagName like ? ";
            preparedStatement = conn.prepareStatement(readBooks);
            preparedStatement.setString(1,"%"+ TagName+"%");
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                if(resultSet.getInt(1) > 0)
                return resultSet;
            }
            
        } 
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return null;
        
    }
    
    public ResultSet searchBookByProfessor(String Professor)
    {
        
        PreparedStatement preparedStatement = null;
        
        try {
            ResultSet resultSet;
            String readBooks = "SELECT * from books where professor like ?";
            preparedStatement = conn.prepareStatement(readBooks);
            preparedStatement.setString(1,"%"+ Professor+"%");
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                if(resultSet.getInt(1) > 0)
                return resultSet;
            }
            
        } 
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }   
        return null;
        
    }
}
