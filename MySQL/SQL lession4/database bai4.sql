DROP DATABASE IF EXISTS Testing_System_Assignment4;
CREATE DATABASE Testing_System_Assignment4 ;
USE Testing_System_Assignment4 ;


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
 CreateDate                  DATETIME DEFAULT NOW(),
 FOREIGN KEY (PositionID)    REFERENCES  Position (PositionID ),
 FOREIGN KEY ( DepartmentID) REFERENCES  Department ( DepartmentID)
 );
 
 CREATE TABLE `Group`(
 GroupID                     TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 GroupName                   VARCHAR (50) NOT NULL,
 CreatorID                   TINYINT UNSIGNED NOT NULL,
 CreateDate                  DATETIME DEFAULT NOW()
 );

  CREATE TABLE `Group Account`(
  GroupID                    TINYINT UNSIGNED NOT NULL ,
  AccountID                  TINYINT UNSIGNED NOT NULL,
  JoinDate                   DATETIME DEFAULT NOW() ,
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
  CreateDate               DATETIME DEFAULT NOW(),
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
    CreateDate                DATETIME DEFAULT NOW(),
    FOREIGN KEY (CategoryID ) REFERENCES CategoryQuestion (CategoryID )
    );
   
    CREATE TABLE             ExamQuestion(
    ExamID                   TINYINT UNSIGNED,
    QuestionID				 SMALLINT UNSIGNED NOT NULL,
    FOREIGN KEY   (ExamID )  REFERENCES Exam (ExamID ) ON DELETE CASCADE,
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
    );
    
    
---- Tạo Bảng Department ----
-----------------------------
INSERT INTO Department                        (        DepartmentName )        
 VALUE                                        (    	   N'Dọn Dẹp'     ),		
								              (    	   N'Bán Hàng'    ),	    
                                              (    	   N'Kinh Doanh'  ),		
                                              (    	   N'Nhân sự'     ),
                                              (        'sale'         ),
                                              (        N'Trưởng Phòng'),
                                              (         'sale'        );
                              
				
INSERT INTO Position                          (   PositionName       )
VALUE							              (            'Dev'     ), 
								              (           'Test'     ),                                     
                                              (       'Scrum Master' ), 
							                  (            'PM'      ); 
                                              
                                               
                                               
                                               
                                               
 INSERT INTO   `Account`        (           Email                ,           UserFullName        ,        DepartmentID    ,      PositionID       ,        CreateDate       )  
 VALUE                          (       'duy@gmail.com'          ,        'Nguyen van duy'       ,               2        ,            1          ,       '2021-03-05'      ),
								(       'tan@gmail.com'          ,        ' Nguyen van tan'      ,              2         ,            2          ,       '2021-03-06'      ),
                                (       'hung@gmail.com'         ,        ' Nguyen van hung'     ,              2         ,            3          ,       '2021-03-07'      ),
                                (       'chung@gmail.com'        ,        'Dguyen van chunOg'    ,              3         ,            4          ,       '2021-03-08'      ),
                                (       'hai@gmail.com'          ,        'Dguyen van kungOk'    ,              2         ,            4          ,       '2021-03-09'      );
                               
                               
----	Tạo Bảng `Group`
INSERT INTO  `Group`            (         GroupName                ,                CreatorID     ,        CreateDate         )                 
VALUE                           (           'samsung'              ,      	           1	      ,        '2021-06-06'       ),                 
								(           'nissan'	           ,                   3	      ,        '2021-06-07'       ),                 
								(           'foxcom'	           ,                   4	      ,        '2021-06-08'       ),                 
								(           'haiphong'             ,      	           4	      ,        '2021-06-09'       ),
                                (           'Thanh Hoa'            ,                   5          ,        '2021-06-08'       );
                                
    INSERT INTO `Group Account` (        GroupID                   ,                AccountID     ,        JoinDate           )
    VALUE                       (          1                       ,                     4        ,         '2016-03-05'      ),
								(          2                       ,                     4        ,         '2017-03-05'      ),
                                (          4                       ,                     1        ,         '2018-03-05'      ),
                                (          4                       ,                     3        ,         '2019-03-05'      ),
                                (          3                       ,                     5        ,         '2016-03-06'      ),
                                (          5                       ,                     2        ,         '2016-03-08'      );
    
    
																													
                                
------
 INSERT INTO   TypeQuestion     (         TypeName            )                    
 VALUE                          (         'Essay'             ),                    
								(         ' Multiple-Choice'  );                    
-------
INSERT INTO CategoryQuestion	( 		  CategoryName          )                    
 VALUE                          (  		        'OK'            ),                    
								(  		        'NG'            ), 
                                (               'tu linh'       ),
                                (              'xuan truong'    ),
                                (              'Hai boi'        );
                                
INSERT INTO  Question           (	          Content			,        CategoryID   ,       	TypeID     ,	 CreatorID     ,	CreateDate     )
VALUE                           (             'Quang hai'       ,            2        ,           1        ,         1         ,    '2018-04-06'   ),
								(             'duy manh'        ,            3        ,           1        ,         2         ,    '2017-04-06'   ),
                                (             'tien linh'       ,            5        ,           2        ,         3         ,    '2016-04-06'   ),
                                (             'hong duy'        ,            4        ,           2        ,         4         ,    '2019-04-06'   ),
                                (             'cong phuong'     ,            3        ,           1        ,         5         ,    '2020-04-06'   );
                                
                                
INSERT INTO   Answer            (             Content           ,       QuestionID     ,        isCorrect   )
VALUE                           (             'Tan truong'     ,              1        ,           1        ),
								(             'Hung Dung'       ,             4        ,           0        ),
                                (             'Hung dang'       ,             4        ,           1        ),
                                (             'Hung Dong'       ,             4        ,           1        ),
                                (             'Hung Ding'       ,             4        ,           0        );
                                
                                
INSERT INTO    Exam              (            `Code`           ,          Title         ,        CategoryID   ,       Duration             ,       CreatorID           ,      CreateDate      )
VALUE                            (              'M'            ,          'van'         ,           3         ,         30                 ,           6               ,      '2014-08-01'    ),
								 (              'N'            ,          'Toan'        ,           4         ,         40                 ,           4               ,      '2016-08-01'    ),  
                                 (              'Q'            ,          'ly'          ,           3         ,         70                 ,           5               ,      '2017-08-01'    ),   
								 (              'A'            ,          'hoa'         ,           5         ,         60                 ,           3               ,      '2019-08-01'    );
                                 
 INSERT INTO  ExamQuestion       (               ExamID        ,        QuestionID      )
 VALUE                           (               1             ,             5          ),
                                 (               2             ,             4          ),
                                 (               3             ,             3          ),
                                 (               4             ,             2          );
                                 
                                 
------ Tạo thêm 10 record cho mỗi bảng ------
---------------------------------------------                                 
 
 
 
INSERT INTO Department                        (        DepartmentName   )        
 VALUE                                        (    	   N'bao ve'        ),		
								              (    	   N'truc ban'      ),	    
                                              (    	   N'boi ban'       ),		
                                              (    	   N'tiep vien'     ),
                                              (        N'nguoi mau'     ),
                                              (        N'pho phong'     ),
                                              (         'sale'          ),
                                              (        N'Kiem ke'       ),
                                              (        N'ton kho'       ),
                                              (        N'Kiem tra'      );
                              
				

                                               
                                               
                                               
                                               
 INSERT INTO   `Account`        (           Email                 ,           UserFullName        ,        DepartmentID      ,      PositionID       ,        CreateDate       )  
 VALUE                          (       'tinh@gmail.com'          ,        'le van tinh'          ,               10         ,            1          ,       '2019-03-05'      ),
								(       'toan@gmail.com'          ,        'le van toan'          ,               12         ,            2          ,       '2019-03-06'      ),
                                (       'bien@gmail.com'          ,        'Nguyen van bien'      ,               13         ,            3          ,       '2018-03-07'      ),
                                (       'vien@gmail.com'          ,        'Nguyen van vien'      ,               13         ,            4          ,       '2017-03-08'      ),
                                (       'luan@gmail.com'          ,        'Nguyen van cay'       ,               12         ,            1          ,       '2016-03-09'      ),
								(       'cay@gmail.com'           ,        'le van cay'           ,               10         ,            4          ,       '2019-04-09'      ),
								(       'lien@gmail.com'          ,        'Nguyen van tuan'      ,               9          ,            3          ,       '2016-04-09'      ),
								(       'cuoc@gmail.com'          ,        'Nguyen van lien'      ,               9          ,            3          ,       '2011-03-09'      ),
								(       'xuan@gmail.com'          ,        'Nguyen van xuan'      ,               8          ,            2          ,       '2010-03-09'      ),
                                (       'tam@gmail.com'           ,        'Nguyen van tam'       ,               7          ,            4          ,       '2015-03-09'      );
                               
                               
                               
                               
                             
                             
                              
                               
----	Tạo Bảng `Group`
INSERT INTO  `Group`            (         GroupName                 ,                CreatorID     ,        CreateDate         )                 
VALUE                           (           'bac ninh'              ,      	            6	       ,        '2014-06-06'       ),                 
								(           'lang son'	            ,                   7	       ,        '2016-06-07'       ),                 
								(           'ninh binh'	            ,                   9	       ,        '2021-07-08'       ),                 
								(           'bac giamg'             ,      	           10	       ,        '2019-04-09'       ),
                                (           'ha giang'              ,                   5          ,        '2018-06-08'       ),  
								(           'ha gian'               ,                   5          ,        '2019-01-08'       ),
								(           'bac lieu'              ,                   6          ,        '2015-04-08'       ),
								(           'ca mau'                ,                   7          ,        '2010-06-08'       ),
								(           'kien giang'            ,                   8          ,        '2016-06-08'       ),
								(           'ca mau'               ,                   9          ,        '2018-07-08'       );
                                     
                                
                                
                                
                               
                                
                                
							
                               
                                
                                
    INSERT INTO `Group Account` (        GroupID                    ,                AccountID      ,        JoinDate           )
    VALUE                       (          12                       ,                     10        ,         '2016-07-05'      ),
								(          11                       ,                     14        ,         '2017-09-05'      ),
                                (          14                       ,                     13        ,         '2018-08-05'      ),
                                (          13                       ,                     13        ,         '2016-03-05'      ),
                                (          12                       ,                     12        ,         '2016-10-06'      ),
                                (          5                        ,                     12        ,         '2016-03-08'      ),
								(          10                       ,                     10        ,         '2016-04-08'      ),
								(          9                        ,                     12        ,         '2016-05-08'      ),
								(          8                        ,                     9         ,         '2016-06-08'      ),
								(          7                        ,                     8         ,         '2016-03-08'      );
    
    
								
				                    
																				
                 
-------
INSERT INTO CategoryQuestion	( 		  CategoryName          )                    
 VALUE                          (  		        'max'           ),                    
								(  		        'min'           ), 
                                (               'agv'           ),
                                (              'lamn'           ),
                                (              'lantrinh'       ),
								(              'lan toan'       ),
								(              'lam hai'        ),
								(              'toan tu'        ),
								(              'boi thu'        ),
								(              'Hai bong'       );
                                
                                
                                
                                
                                
                                
                                
                                
INSERT INTO  Question           (	          Content		    ,        CategoryID    ,       	TypeID      ,	 CreatorID      ,	CreateDate     )
VALUE                           (             'qua com'         ,            12        ,           1        ,         10        ,    '2018-04-06'   ),
								(             'micom'           ,            13        ,           1        ,         12        ,    '2017-05-06'   ),
                                (             'cutting'         ,            14        ,           2        ,         13        ,    '2016-08-06'   ),
                                (             'caoting'         ,            14        ,           2        ,         14        ,    '2019-07-06'   ),
                                (             'vo len'          ,            10        ,           1        ,         5         ,    '2020-06-06'   ),
								(             'vo chum'         ,            9         ,           2        ,         9         ,    '2016-04-06'   ),
								(             'vo bom'          ,            7         ,           1        ,         8         ,    '2020-04-06'   ),
								(             'don pahm'        ,            7         ,           1        ,         7         ,    '2018-03-06'   ),
								(             'cat ca'          ,            8         ,           2        ,         5         ,    '2020-04-06'   ),
								(             'cau hoi'         ,            3         ,           1        ,         6         ,    '2021-04-06'   );
                                          
                                
                                
																																																                                
                                
INSERT INTO    Exam             (            `Code`           ,          Title         ,        CategoryID    ,       Duration             ,       CreatorID           ,      CreateDate      )
VALUE                           (              'B'            ,          'Sinh'        ,           13         ,         80                 ,           6               ,      '2014-03-01'    ),
								(              'C'            ,          'su'          ,           14         ,         60                 ,           4               ,      '2016-04-01'    ),  
								(              'D'            ,          'dia'         ,           13         ,         70                 ,           5               ,      '2017-05-01'    ),   
								(              'E'            ,          'chu'         ,           12         ,         90                 ,           7               ,      '2019-06-01'    ),
								(              'F'            ,          'trau'        ,           12         ,         50                 ,           3               ,      '2019-08-01'    ),
								(              'G'            ,          'bo'          ,           13         ,         120                ,           8               ,      '2016-08-01'    ),
								(              'X'            ,          'ga'          ,           11         ,         160                ,           4               ,      '2016-08-01'    ),
								(              'K'            ,          'cho'         ,           5          ,         160                ,           3               ,      '2019-07-01'    ),
								(              'Y'            ,          'lon'         ,           9          ,         160                ,           9               ,      '2021-08-01'    ),
								(              'U'            ,          'vit'         ,           5          ,         160                ,           3               ,      '2021-08-01'    );
                                 
                                 
 INSERT INTO  ExamQuestion      (              ExamID         ,        QuestionID      )
 VALUE                          (               11            ,             5          ),
								(               12            ,             4          ),
								(               13            ,             13         ),
								(               4             ,             12         ), 
								(               6             ,             12         ), 
								(               7             ,             12         ), 
								(               4             ,             9          ), 
								(               8             ,             8          ), 
								(               4             ,             7          ), 
								(               9             ,             2          );  
                                 

                                 
                                


                        
                                
                                
                                
                                
                                
 

 
								
         
							
 
                                
							
					
                                
                                
  
                                
                                
                                
                                
                                
 






  
  
  
  
  