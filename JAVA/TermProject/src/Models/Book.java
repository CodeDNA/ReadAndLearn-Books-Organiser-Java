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
public class Book {
    public static Book currentBook;
    String BookId, BookName, Author, Professor, BookDescription, BookType,DateAdded;
    
    public Book()
    {
        
    }
    public Book(String BookId,String BookName,String  Author,String  Professor,String  BookDescription,String DateAdded)
    {
        this.BookId =BookId;
        this.BookName = BookName;
        this.Author = Author;
        this.Professor = Professor;
        this.BookDescription = BookDescription;
        this.BookType = BookType;
        this.DateAdded = DateAdded;        
    }
    
    public String getBookId()
    {
        return BookId;
    }
    
    public String getBookName()
    {
        return BookName;
    }

    public void setBookId(String BookId) {
        this.BookId = BookId;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setProfessor(String Professor) {
        this.Professor = Professor;
    }

    public void setBookDescription(String BookDescription) {
        this.BookDescription = BookDescription;
    }

    public void setBookType(String BookType) {
        this.BookType = BookType;
    }

    public void setDateAdded(String DateAdded) {
        this.DateAdded = DateAdded;
    }
    
    public String getAuthor()
    {
        return Author;
    }
    
    public String getProfessor()
    {
        return Professor;
    }
    
    public String getBookDescription()
    {
        return BookDescription;
    }
    
    public String getBookType()
    {
        return BookType;
    }
    
    public String getDateAdded()
    {
        return DateAdded;
    }
}
    
