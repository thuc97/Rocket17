DROP DATABASE IF EXISTS Asigntment4;
CREATE DATABASE Asigntment4;
USE Asigntment4 ;


DROP TABLE IF EXISTS  Department;
CREATE TABLE Department (
Department_Number             				TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Department_Name  							VARCHAR (100) NOT NULL 
);


DROP TABLE IF EXISTS Employee_Table;
CREATE TABLE Employee_Table (
Employee_Number 							TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Employee_Name								VARCHAR (100) NOT NULL ,
Department_Number							TINYINT UNSIGNED NOT NULL,
FOREIGN KEY    (Department_Number)          REFERENCES   Department( Department_Number)        
);

DROP TABLE IF EXISTS Employee_Skill_Table;
CREATE TABLE Employee_Skill_Table (
Employee_Number 							TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Skill_Code                                  VARCHAR (100) NOT NULL ,
`Date Registered`							DATETIME DEFAULT NOW(),	
FOREIGN KEY (Employee_Number)				REFERENCES  Employee_Table (Employee_Number)
);





----- Questtion2 insert table data `

INSERT INTO  Department 							(		Department_Name      )					
VALUES												(			 "sale"          ),
													(			 "salo"          ),
													(			 "kaka"          ),
													(			 "luli"          ),
													(		     "kuki"          ),
													(			 "sala"          ),
													(			 "salo"          ),
													(		     "lale"          ),
													(		     "kale"          ),
													(		     "nale"          );


INSERT INTO   Employee_Table                        (			Employee_Name	 ,         Department_Number	 )
VALUES											    (			     "tân"		 ,					1             ),
												    (			     "lam"		 ,					8             ),
												    (			     "lan"		 ,					6             ),           
												    (			     "tam"		 ,					9             ),
												    (			     "tun"		 ,					3             ),
                                                    (			     "tau"		 ,					3             ),
                                                    (			     "kau"		 ,					7             ),
                                                    (			     "kau"		 ,					5             ),
                                                    (			     "cai"		 ,					1             );
                                                  
                                                  

INSERT INTO  Employee_Skill_Table                   (			Skill_Code        ,         	`Date Registered` )
VALUES	                                            (     		"skill Java"     ,					"2014-06-08"  ),
													(     		"skill Java"     ,					"2015-06-08"  ),
                                                    (     		"skill Jave"     ,					"2014-07-08"  ),
                                                    (     		"skill Javu"     ,					"2016-06-08"  ),
                                                    (     		"skill Javi"     ,					"2018-06-08"  ),
                                                    (     		"skill Java"     ,					"2019-06-08"  ),
                                                    (     		"skill Javo"     ,					"2020-06-08"  ),
                                                    (     		"skill Javk"     ,					"2014-09-08"  ),
                                                    (     		"skill Javh"     ,					"2014-06-09"  );
                                                    
   
   
   

-------- Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
SELECT Employee_Name,Skill_Code 
FROM  Employee_Table   e 
JOIN  Employee_Skill_Table  ek ON   e.Employee_Number= ek. Employee_Number
WHERE Skill_Code ='skill Java';

----- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT Department_Name  , count(e.Department_Number) as sl
FROM  Employee_Table   e 
lEFT JOIN  Department       D  ON   e.Department_Number= D. Department_Number
GROUP BY e.Department_Number 
HAVING sl >1;

------ Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban. 
SELECT Department_Name , Employee_Name 
FROM  Employee_Table   e 
LEFT JOIN  Department       D  ON   e.Department_Number= D. Department_Number;



------ Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills
SELECT Employee_Name,Skill_Code ,count(ek. Employee_Number) as  DSNV
FROM  Employee_Table   e 
JOIN  Employee_Skill_Table  ek ON   e.Employee_Number= ek. Employee_Number
GROUP BY ek. Employee_Number
HAVING  DSNV >1;



   
   
   
                                                  
                                                  
                                                  


