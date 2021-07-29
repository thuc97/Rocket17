DROP DATABASE IF exists  Testing_System;
CREATE DATABASE  Testing_System; 
USE  Testing_System;

CREATE TABLE Department (
Department_ID            INT,
Department_Name          VARCHAR (50)
);
CREATE TABLE `Position` (
PositionID               INT,
Department_Name          VARCHAR (50) 
);
CREATE TABLE `Account` (
Account_ID                INT,
Email                     VARCHAR (50), 
Username                  VARCHAR (50), 
FullName                  VARCHAR (50),
DepartmentID              INT,
PositionID                INT,
CreateDate                DATE
);
CREATE TABLE _Group  (
GroupID                  INT,
GroupName                VARCHAR (50),
CreatorID                INT,
CreateDate               DATE
);
CREATE TABLE _GroupAcount (
GroupID                  INT,
AccountID                INT,
JoinDate                 DATE
);
CREATE TABLE TypeQuestion (
TypeID                   INT, 
TypeName                 VARCHAR (50)
);
CREATE TABLE CategoryQuestion (
CategoryID                INT,
CategoryName              VARCHAR (50)
);
CREATE TABLE Question (
QuestionID              INT,
Content                 VARCHAR (50),
CategoryID              INT, 
TypeID                  INT,
CreatorID               INT,
CreateDate              DATE
);

CREATE TABLE  Answer (
AnswerID               INT,
Content                VARCHAR (50),
QuestionID             INT,
isCorrect              VARCHAR (50)  
);
CREATE TABLE  Exam (
ExamID                  INT,
`Code`                   VARCHAR (50),  
Title                   VARCHAR (50),
CategoryID              INT,
Duration                DATE,
CreatorID               INT,
CreateDate              DATE
);
CREATE TABLE ExamQuestion (
ExamID                  INT,
QuestionID              INT
);



