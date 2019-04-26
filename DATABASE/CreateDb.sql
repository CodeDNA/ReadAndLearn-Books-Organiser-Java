Create Database ReadAndLearn;
Use ReadAndLearn;

/*---------------------------------------------------------*/
CREATE TABLE Books(

BookId varchar(40) NOT NULL,
BookName nvarchar(50)  NOT NULL,
Author nvarchar(100) NOT NULL,
Professor nvarchar(60) NOT NULL,
BookDescription nvarchar(200) NOT NULL,
DateAdded  DATETIME NOT NULL,

CONSTRAINT Book_BookId_PK PRIMARY KEY (BookId)

);

/*----------------------------------------------------------*/

CREATE TABLE Users (

UserId varchar(40) NOT NULL,
FName nvarchar(50) NOT NULL,
LName nvarchar(50) NOT NULL,
UserEmail nvarchar(30) NOT NULL,
UserPassword nvarchar(100) NOT NULL,
UserType numeric(2) NOT NULL,
CONSTRAINT User_UserId_PK PRIMARY KEY (UserId)
);


/*----------------------------------------------------------*/

Create Table BooksRead(

UserId varchar(40),
BookId varchar(40),

CONSTRAINT BooksRead_UserId_FK FOREIGN KEY (UserId) REFERENCES Users(UserId) ON DELETE CASCADE,
CONSTRAINT BooksRead_BookId_FK FOREIGN KEY (BookId) REFERENCES Books(BookId) ON DELETE CASCADE
);

/*----------------------------------------------------------*/

Create Table Wishlist(

UserId varchar(40),
BookId varchar(40),

CONSTRAINT Wishlist_UserId_FK FOREIGN KEY (UserId) REFERENCES Users(UserId) ON DELETE CASCADE,
CONSTRAINT Wishlist_BookId_FK FOREIGN KEY (BookId) REFERENCES Books(BookId) ON DELETE CASCADE

);

/*----------------------------------------------------------*/

Create Table Courses(

CourseId varchar(40) NOT NULL,
CourseName nvarchar(70) NOT NULL,

CONSTRAINT Courses_courseId_PK PRIMARY KEY (CourseId)
);

/*----------------------------------------------------------*/

Create Table CourseBook(
BookId varchar(40),
CourseId varchar(40),

CONSTRAINT CourseBook_BookId_FK FOREIGN KEY (BookId) REFERENCES Books(BookId) ON DELETE CASCADE,
CONSTRAINT CourseBook_CourseId_FK FOREIGN KEY (CourseId) REFERENCES Courses(CourseId) ON DELETE CASCADE

);

/*----------------------------------------------------------*/

Create Table Tags(

TagId varchar(40) NOT NULL,
TagName nvarchar(20),

CONSTRAINT Tags_TagId_PK PRIMARY KEY(TagId)
);

/*----------------------------------------------------------*/

Create Table BookTags(
BookId varchar(40),
TagId varchar(40),

CONSTRAINT BookTags_BookId_FK FOREIGN KEY (BookId) REFERENCES Books(BookId) ON DELETE CASCADE,
CONSTRAINT BookTags_TagId_FK FOREIGN KEY (TagId) REFERENCES Tags(TagId) ON DELETE CASCADE
);
/*----------------------------------------------------------*/


#Drop Database ReadAndLearn
