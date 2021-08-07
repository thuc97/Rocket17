-----  Exercise 1:Design a table
----- Question 1
DROP DATABASE IF EXISTS `manage fresher`;
CREATE DATABASE  `manage fresher`;
USE `manage fresher`;
DROP DATABASE IF EXISTS `Trainee`;
CREATE TABLE  `Trainee` (
TraineeID							TINYINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
Full_Name							VARCHAR (50) NOT NULL,
Birth_Date							DATE NOT NULL,
Gender								ENUM ("male", "female",  "unknown") ,
ET_IQ								SMALLINT UNSIGNED NOT NULL CHECK(ET_IQ<=20),
ET_Gmath							SMALLINT UNSIGNED NOT NULL CHECK(ET_Gmath	<=20),
ET_English							SMALLINT UNSIGNED NOT NULL CHECK(ET_English<=50),
Training_Class						VARCHAR(50) NOT NULL,
Evaluation_Notes					VARCHAR (100) NOT NULL
);

---- Question 2 : thêm trường VTI_Account với điều kiện not null & unique 
ALTER TABLE   `Trainee`
ADD VTI_Account  SMALLINT UNSIGNED NOT NULL UNIQUE 
AFTER  Evaluation_Notes ;


--- Exercise 2: Data Types
DROP DATABASE IF EXISTS `Data Types`;
CREATE TABLE `Data Types`(
ID          						MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
`Name`								VARCHAR (50) NOT NULL,
`Code`                              CHAR(20) NOT NULL,
ModifiedDate						TIMESTAMP NOT NULL
);
DROP DATABASE IF EXISTS `Data Types (2)`;
CREATE TABLE  `Data Types (2)`(
ID									MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
`Name`								CHAR(50) NOT NULL,
BirthDate							DATE NOT NULL,
Gender            					ENUM ( "male" ,"female", "unknow") UNIQUE,
IsDeletedFlag					    BIT
);








