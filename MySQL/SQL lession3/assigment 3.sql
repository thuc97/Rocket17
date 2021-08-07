DROP DATABASE IF EXISTS `manage fresher`;
CREATE DATABASE  `manage fresher`;
USE `manage fresher`;
DROP DATABASE IF EXISTS `Trainee`;
CREATE TABLE  `Trainee` (
TraineeID							TINYINT UNSIGNED  PRIMARY KEY AUTO_INCREMENT,
Full_Name							VARCHAR (50) NOT NULL,
Birth_Date							DATETIME   DEFAULT NOW(),
Gender								ENUM ("male", "female",  "unknown") ,
ET_IQ								SMALLINT UNSIGNED NOT NULL CHECK(ET_IQ<=20),
ET_Gmath							SMALLINT UNSIGNED NOT NULL CHECK(ET_Gmath	<=20),
ET_English							SMALLINT UNSIGNED NOT NULL CHECK(ET_English<=50),
Training_Class						VARCHAR(50) NOT NULL,
Evaluation_Notes					VARCHAR (100) NOT NULL
);
----- Question 1: Thêm ít nhất 10 bản ghi vào table
---- cú pháp  INSERT INTO table_name (column1, column2, column3) VALUES (value1, value2, value3);

INSERT INTO    `Trainee`      (	 Full_Name      	 ,         Birth_Date ,      Gender         ,			  ET_IQ		   ,	  ET_Gmath		  ,	   ET_English	  ,	  Training_Class,	  Evaluation_Notes				)			  
VALUES                        (	"nguyen ba thuc"     ,         "2020-08-06" ,      "male"       ,             18           ,      12              ,       26          ,        "A"        ,      "giỏi"      				),	                         
						      (	"nguyen ba thuc"     ,         "2020-05-06" ,      "female"     ,             19           ,      8               ,       26          ,        "A"        ,      "kha"       				),								
							  (	"nguyen thi thao"    ,         "2020-04-06" ,      "unknown"    ,             8            ,      2               ,       26          ,        "b"        ,      "giỏi"      				),
							  (	"nguyen thi thun"    ,         "2021-06-06" ,      "unknown"    ,             12           ,      9               ,       26          ,        "b"        ,      "giỏi"      				),
							  (	"nguyen thi thuni"   ,         "2021-04-06" ,      "unknown"    ,             12           ,      9               ,       26          ,        "b"        ,      "giỏi"      				),
							  (	"nguyen thi thuki"   ,         "2018-04-06" ,      "female"     ,             8            ,      9               ,       26          ,        "b"        ,      "giỏi"      				),
							  (	"nguyen thi than"    ,         "2019-04-06" ,      "unknown"    ,             9            ,      9               ,       26          ,        "b"        ,      "giỏi"      				);
                            
                            
------ Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, 
------ nhóm chúng thành các tháng sinh khác nhau

---- cách 1 : dùng hàm month (name colum select ) 
SELECT Full_Name,month(  Birth_Date)
FROM    `Trainee`
WHERE ( ET_IQ + ET_Gmath>=20  AND    ET_IQ>=8  AND ET_Gmath>=8 AND ET_English>=18)
GROUP BY month(Birth_Date);


---- cách 2 : sử dụng hàm DATE_FORMAT("tên colum muốn lấy thông tin", '%M')  nhưng in ra định dạng USA
---- chú ý : Dùng order by  khi select sẽ không bị mất thông tin => group by sẽ bị mất thông tin 

SELECT Full_Name, Birth_Date,
DATE_FORMAT (Birth_Date ,"%M") AS KQ
FROM  `Trainee`
WHERE ( ET_IQ + ET_Gmath>=20  AND    ET_IQ>=8  AND ET_Gmath>=8 AND ET_English>=18)
ORDER BY DATE_FORMAT (Birth_Date ,"%M");

------ Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau: 
------ tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
------  sử dụng cú pháp selec* from (table name ), where length (tên collum muốn lấy thông tin)= (SELECT Max(length(tên collum muốn lấy thông tin)) from (table name ),

 SELECT Full_Name 
 FROM `Trainee` 
 WHERE length(Full_Name )=(SELECT Max(length(Full_Name ) ) FROM `Trainee`);
 
 ----  Question 4
 SELECT Full_Name
 FROM  `Trainee`
 WHERE ( ET_IQ + ET_Gmath>=20  AND    ET_IQ>=8  AND ET_Gmath>=8 AND ET_English>=18);
 
 --- Question 5: xóa thực tập sinh có TraineeID = 3
DELETE
FROM `Trainee`
WHERE  TraineeID =3;		
 
---- Question 6: Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2"
----  sử dụng câu lệnh  UPDATE table_name,
-- SET column1 = value1, column2 = value2...., columnN = valueN
--  WHERE [condition];
 
UPDATE `Trainee`
SET   Training_Class =2 WHERE TraineeID = 5 ;
SELECT *
FROM `Trainee`;







                            
                            
                            