USE Testing_System_Assignment ;
------------ Question 2: lấy ra tất cả các phòng ban
SELECT DepartmentName
FROM  Department;

----------- Question 3: lấy ra id của phòng ban "Sale"
SELECT DepartmentID ,DepartmentName
FROM   Department
WHERE DepartmentName='sale'    ;

----------  Question 4: lấy ra thông tin account có full name dài nhất
SELECT *
FROM   `Account`   
WHERE  length(UserFullName )=(SELECT max(length(UserFullName )) FROM  `Account` );


--------- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id =3
 
SELECT *
FROM   `Account`   
WHERE  length(UserFullName )=(SELECT max(length(UserFullName )) FROM  `Account` )AND DepartmentID =3;
 
-----   Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019

SELECT GroupName  
FROM `Group` 
WHERE   CreateDate <  '2019-12-20' ;
  
-------  Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT   QuestionID  ,   Content	 ,count(QuestionID )as SL
FROM     Answer  
GROUP BY   QuestionID  
HAVING  QuestionID >=4;
-----   Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019

SELECT   `Code`   
FROM Exam  
WHERE Duration >=60 AND     CreateDate <  '2019-12-20'  ;

------- Question 9: Lấy ra 5 group được tạo gần đây nhất  
 

SELECT  GroupName , CreateDate   
FROM `Group` 
ORDER BY GroupName DESC
LIMIT 5;

----- Question 10: Đếm số nhân viên thuộc department có id = 2

SELECT count(UserFullName),DepartmentID
FROM  `Account`
WHERE DepartmentID=2;

------ Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT  UserFullName
FROM `Account`
WHERE  UserFullName LIKE 'D%g';

------- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE 
FROM  ExamQuestion 
WHERE ExamID IN(SELECT ExamID FROM  Exam  WHERE  CreateDate <  '2019-12-20' );

DELETE 
FROM  Exam  
WHERE  CreateDate <  '2019-12-20' ;

SELECT *
FROM Exam ;

---- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"

DELETE
FROM Question
WHERE Content  LIKE  '%cau hoi' ;

---- --- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và 
 ------- email thành loc.nguyenba@vti.com.vn
UPDATE `Account`  
SET    UserFullName ='Nguyễn Bá Lộc' , Email ='thanh loc.nguyenba@vti.com.vn'
WHERE AccountID    =5;
 

----- Question 15: update account có id = 5 sẽ thuộc group có id = 4

UPDATE  `Group Account`
SET   AccountID  =5
WHERE GroupID  =4;
 
 

