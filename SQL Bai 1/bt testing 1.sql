DROP DATABASE IF EXISTS Testing_System_Assignment;
CREATE DATABASE Testing_System_Assignment ;
USE Testing_System_Assignment ;


CREATE TABLE Department (
DepartmentID               TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
DepartmentName             VARCHAR (50) NOT NULL
);

 CREATE TABLE Position (
 PositionID                 TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 PositionName               ENUM ('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL UNIQUE
 );
 
 CREATE TABLE `Account` (
 AccountID                   TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
 Email                       VARCHAR(50) NOT NULL ,
 UserFullName                CHAR (50) UNIQUE NOT NULL ,
 DepartmentID                TINYINT UNSIGNED NOT NULL ,
 PositionID 			     TINYINT UNSIGNED NOT NULL,
 CreateDate                  TIMESTAMP DEFAULT NOW(),
 FOREIGN KEY (PositionID)    REFERENCES  Position (PositionID ),
 FOREIGN KEY ( DepartmentID) REFERENCES  Department ( DepartmentID)
 );
 
 CREATE TABLE `Group`(
 GroupID                     TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 GroupName                   VARCHAR (50) NOT NULL,
 CreatorID                   TINYINT UNSIGNED NOT NULL,
 CreateDate                  TIMESTAMP DEFAULT NOW()
 );

  CREATE TABLE `Group Account`(
  GroupID                    TINYINT UNSIGNED NOT NULL ,
  AccountID                  TINYINT UNSIGNED NOT NULL,
  JoinDate                   TIMESTAMP DEFAULT NOW() ,
  PRIMARY KEY                AUTO_INCREMENT         ( GroupID ,AccountID),
  FOREIGN KEY (GroupID )     REFERENCES  `Group` (GroupID),
  FOREIGN KEY (AccountID )   REFERENCES `Account`( AccountID )
  );
 
  CREATE TABLE TypeQuestion (
  TypeID                    TINYINT UNSIGNED  AUTO_INCREMENT PRIMARY KEY,
  TypeName                  ENUM ('Essay',' Multiple-Choice') NOT NULL UNIQUE
  );

  CREATE TABLE CategoryQuestion (
  CategoryID                 TINYINT UNSIGNED  AUTO_INCREMENT PRIMARY KEY,
  CategoryName               VARCHAR (50) NOT NULL UNIQUE 
  );
 
  CREATE TABLE  Question (
  QuestionID               SMALLINT UNSIGNED    AUTO_INCREMENT PRIMARY KEY, 
  Content                  VARCHAR (50) NOT NULL,
  CategoryID               TINYINT UNSIGNED NOT NULL,
  TypeID                   TINYINT UNSIGNED NOT NULL, 
  CreatorID                TINYINT UNSIGNED NOT NULL, 
  CreateDate               TIMESTAMP  DEFAULT NOW(),
  FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
  FOREIGN KEY  (TypeID)    REFERENCES TypeQuestion (TypeID)
  );
  
   CREATE TABLE   Answer (
   AnswerID                 SMALLINT UNSIGNED   AUTO_INCREMENT PRIMARY KEY,
   Content                  VARCHAR (50) NOT NULL,
   QuestionID               SMALLINT UNSIGNED NOT NULL,
   isCorrect                BIT ,
   FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
   );

    CREATE TABLE  Exam (
    ExamID                    TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`                    CHAR (50)  ,
    Title                     VARCHAR (50),
    CategoryID                TINYINT UNSIGNED NOT NULL,
    Duration                  TINYINT UNSIGNED  NOT NULL,
    CreatorID                 TINYINT UNSIGNED  NOT NULL,
    CreateDate                TIMESTAMP DEFAULT NOW(),
    FOREIGN KEY (CategoryID ) REFERENCES CategoryQuestion (CategoryID )
    );
   
    CREATE TABLE             ExamQuestion(
    ExamID                   TINYINT UNSIGNED,
    QuestionID				 SMALLINT UNSIGNED NOT NULL,
    FOREIGN KEY   (ExamID )  REFERENCES Exam (ExamID ),
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
    );
    
    



                        
                                
                                
                                
                                
                                
 

 
								
         
							
 
                                
							
					
                                
                                
  
                                
                                
                                
                                
                                
 






  
  
  
  
  
