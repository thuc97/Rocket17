----- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
USE           	Testing_System_Assignment4 ;

SELECT 		  	UserFullName, d.DepartmentID 
FROM  		 	`Account`  a
INNER JOIN   	Department d ON a.DepartmentID = d.DepartmentID;

----- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010 
SELECT 	*
FROM 			`Account` a
WHERE 			 CreateDate >'2010-12-20'; 

----  Question 3: Viết lệnh để lấy ra tất cả các developer 

SELECT			 UserFullName, PositionName
FROM 			`Account` a
JOIN 			 Position p ON a.PositionID  =p.PositionID 
WHERE			 PositionName = 'Dev'   ;


---- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT          DepartmentName,   UserFullName ,count( d.DepartmentID) as SL
FROM           `Account`   a
JOIN            Department  d ON a.DepartmentID  =d.DepartmentID
GROUP BY        d.DepartmentID
HAVING          SL >3;
----- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều  nhất 
--- cách 1:
SELECT          Content ,count( Content ) as sl
FROM            Question   q
JOIN            ExamQuestion E ON q. QuestionID  = E. QuestionID
GROUP BY        q. QuestionID 
ORDER BY        sl DESC 
LIMIT           1;
----- cách 2: Dùng hàm  (SELECT MAX(Total) FROM (SELECT COUNT(*) AS Total FROM emp1 GROUP BY name) AS Results);
SELECT          Content,      count( Content ) as sl
FROM            Question   q
JOIN            ExamQuestion E     ON q. QuestionID  = E. QuestionID
GROUP BY        q. QuestionID 
HAVING          count( Content )= (SELECT MAX(Total) FROM(SELECT count( Content ) AS Total FROM Question  q
JOIN            ExamQuestion  E    ON q. QuestionID  = E. QuestionID 
GROUP BY        q. QuestionID )AS RESULTS );

------ Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT          c.CategoryID ,count(q. CategoryID),CategoryName
FROM            Question  as q
LEFT JOIN       CategoryQuestion as c ON q.CategoryID=  c.CategoryID
GROUP BY        q.CategoryID;
------   Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam

SELECT          q.QuestionID,count(E.QuestionID),Content
FROM            Question  as q
LEFT JOIN       ExamQuestion as E ON q.QuestionID  = E.QuestionID
GROUP BY        E.QuestionID ;

------ Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT          q.QuestionID,count(a.QuestionID),q.Content
FROM            Question  as q
LEFT JOIN       Answer   as a ON q.QuestionID  = a.QuestionID
GROUP BY        a.QuestionID 
HAVING          count(a.QuestionID) =(SELECT max(Total) FROM (SELECT count(a.QuestionID) as Total FROM Question  as q
LEFT JOIN       Answer   as a ON q.QuestionID  = a.QuestionID
GROUP BY        a.QuestionID ) as kq );

---- Question 9: Thống kê số lượng account trong mỗi group 
SELECT     	  GroupName ,count(g.AccountID)	 as kq
FROM  		 `Group Account`  g  
INNER JOIN   `Group` gp ON g. GroupID =gp.GroupID   
LEFT JOIN   `Account`a ON g.AccountID  =a.AccountID 
GROUP BY g.AccountID;

----- ----- Question 10: Tìm chức vụ có ít người nhất
 
 SELECT  PositionName ,count(UserFullName)  
 FROM Position AS P
 INNER JOIN  `Account` AS A
 ON P.PositionID =A.PositionID
 GROUP BY  PositionName
 HAVING count(UserFullName) = (SELECT MIN(Total) 
 FROM (SELECT count(UserFullName) AS Total 
 FROM Position AS P
 INNER JOIN  `Account` AS A
 ON P.PositionID =A.PositionID
 GROUP BY  PositionName ) AS RESULTS);
 
 ---- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
 
 SELECT D.DepartmentName ,D.DepartmentID ,P.PositionName , count(P.PositionName )
 FROM  `Account` AS A  
 INNER JOIN department AS D
 ON A.DepartmentID=D.DepartmentID
 INNER JOIN Position AS P
 ON P.PositionID =A.PositionID
 GROUP BY p.PositionID ,D.DepartmentID;
 
 
----  Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của 
 ----- question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì
 
 
 SELECT question.Content , typequestion.TypeName ,`Account`.UserFullName ,answer.Content,question.QuestionID 
 FROM question
 INNER JOIN typequestion ON question.TypeID=typequestion.TypeID
 INNER JOIN answer ON question.QuestionID=answer.QuestionID
 INNER JOIN `Account` ON question.CreatorID=`Account`.AccountID;
 
 

---- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm

SELECT typequestion.TypeName , question.TypeID, count(typequestion.TypeName)
FROM typequestion
INNER JOIN question ON typequestion.TypeID=question.TypeID
GROUP BY question.TypeID;

----- Question 14:Lấy ra Acount không có group nào
SELECT     	  GroupName , g.AccountID	
FROM  		 `Group Account`  g
INNER JOIN   `Group` gp ON g. GroupID =gp.GroupID   
RIGHT JOIN   `Account`a ON g.AccountID  =a.AccountID 
WHERE         g.AccountID  is NULL;

------- Question 16: Lấy ra question không có answer nào
SELECT     	   q.Content   ,a.QuestionID 	
FROM  		   Question  q  
LEFT JOIN      Answer    a ON q.QuestionID  =a.QuestionID
WHERE          a.QuestionID is NULL;


------ lấy ra tên acout và tên group của những acoutn đã tham gia

SELECT     	  gp. GroupName , a. UserFullName, g.AccountID 	
FROM  		 `Group Account`  g
JOIN         `Group` gp ON g. GroupID = gp.GroupID   
JOIN         `Account`a ON g.AccountID =a.AccountID ;

----  Exercise 2: 
----- Question 17: Lấy các account thuộc nhóm thứ 1
SELECT       UserFullName ,a.AccountID,g. GroupID 
FROM  		 `Group Account`  g
JOIN         `Account`a ON g.AccountID =a.AccountID 
WHERE       g. GroupID=1;


SELECT       UserFullName ,a.AccountID,g. GroupID 
FROM  		 `Group Account`  g
JOIN         `Account`a ON g.AccountID =a.AccountID 
WHERE        g. GroupID=2;

---- Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau

SELECT       UserFullName ,a.AccountID,g. GroupID 
FROM  		 `Group Account`  g
JOIN         `Account`a ON g.AccountID =a.AccountID 
WHERE       g. GroupID=1

UNION

SELECT       UserFullName ,a.AccountID,g. GroupID 
FROM  		 `Group Account`  g
JOIN         `Account`a ON g.AccountID =a.AccountID 
WHERE        g. GroupID=2;


---- Question 18: Lấy các group có lớn hơn 5 thành viên

SELECT     	 GroupName ,UserFullName ,count(  GroupName ) as SL
FROM  		 `Group Account`  g
JOIN         `Group` gp ON g. GroupID = gp.GroupID   
JOIN         `Account`a ON g.AccountID =a.AccountID 
GROUP BY      gp.GroupID 
HAVING       SL>=5;

SELECT     	  GroupName ,UserFullName ,count(  GroupName ) as SL
FROM  		 `Group Account`  g
JOIN         `Group` gp ON g. GroupID = gp.GroupID   
JOIN         `Account`a ON g.AccountID =a.AccountID 
GROUP BY      gp.GroupID 
HAVING        SL<=7;

---- Ghép 2 kết quả từ câu a) và câu b) 
SELECT     	 GroupName ,UserFullName ,count(  GroupName ) as SL
FROM  		 `Group Account`  g
JOIN         `Group` gp ON g. GroupID = gp.GroupID   
JOIN         `Account`a ON g.AccountID =a.AccountID 
GROUP BY      gp.GroupID 
HAVING       SL>=5

UNION ALL

SELECT     	  GroupName ,UserFullName ,count(  GroupName ) as SL
FROM  		 `Group Account`  g
JOIN         `Group` gp ON g. GroupID = gp.GroupID   
JOIN         `Account`a ON g.AccountID =a.AccountID 
GROUP BY      gp.GroupID 
HAVING        SL<=7;


























