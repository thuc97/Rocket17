USE Testing_System_Assignment4 ;

---- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale

DROP VIEW IF EXISTS ds;
CREATE OR REPLACE VIEW ds AS
SELECT								 DepartmentName  ,UserFullName  
FROM								 Department d
JOIN   								`Account`   a  ON d.DepartmentID  =a.DepartmentID 
WHERE 								 UserFullName IN (SELECT UserFullName FROM   `Account`  WHERE DepartmentName='sale');

SELECT  							 *
FROM 								 ds;


---- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất

--- Cách 1 : Dùng hàm (SELECT MAX(Total) FROM (SELECT COUNT(*) AS Total FROM emp1 GROUP BY name) AS Results);
DROP VIEW IF EXISTS OK;
CREATE VIEW OK AS
SELECT 								 a.AccountID , count(ga. AccountID) as sl
FROM 								`Group Account` ga
LEFT JOIN   						`Account`  a ON  ga. AccountID  =a.AccountID
GROUP BY 							 ga. AccountID
HAVING 								 count(ga. AccountID) =(SELECT max(Total)  FROM (SELECT count(ga. AccountID)   AS total FROM  `Group Account` ga
LEFT JOIN   						`Account`  a ON  ga. AccountID  =a.AccountID
GROUP BY 							 ga. AccountID) AS rs );

SELECT *
FROM OK ;

---- cách 2 dùng CTE -----------------------------------------------------------

WITH 								cte_ds AS (
SELECT 								ga.AccountID , count(ga. AccountID) as sl
FROM 								`Group Account` ga
GROUP BY 							ga. AccountID
)
SELECT 								a.AccountID , count(ga. AccountID) as sl
FROM 								`Group Account` ga
LEFT JOIN  							`Account`  a ON  ga. AccountID  =a.AccountID
GROUP BY 							ga. AccountID
HAVING 								count(ga. AccountID) =(SELECT max(sl) FROM cte_ds );

----- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 10 từ  được coi là quá dài) và xóa nó đi 
DROP VIEW IF EXISTS dlt;
CREATE VIEW dlt AS
SELECT  Content	
FROM Question  
WHERE length(Content)>=10;
SELECT *
FROM dlt;
DELETE 
FROM dlt ;

 --- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
DROP VIEW IF EXISTS OKe;
CREATE VIEW OKe AS 
 
SELECT  							d. DepartmentID ,UserFullName ,count(a. DepartmentID ) as kq
FROM  								Department       d
LEFT JOIN  						   `Account`  a ON d. DepartmentID   =a. DepartmentID   
GROUP BY 							a. DepartmentID 
HAVING 								count(a. DepartmentID ) =(SELECT MAX(Total) FROM (SELECT count(a. DepartmentID ) AS Total 
FROM                                Department       d
LEFT JOIN  						   `Account`  a ON d. DepartmentID   =a. DepartmentID   
GROUP BY 							a. DepartmentID ) as rs);
 
SELECT*
FROM OKe;
 
 ------ Cách 2 Dùng CTE --------------------------------------------------
 
WITH 								cte_sl AS(
SELECT  							a. DepartmentID  ,count(a. DepartmentID ) as kq
FROM 								`Account`      a
GROUP BY 							a. DepartmentID 
)
 SELECT  							d. DepartmentID ,UserFullName ,count(a. DepartmentID ) as kq
 FROM 								Department       d
 LEFT JOIN 							`Account`  a ON d. DepartmentID   =a. DepartmentID   
 GROUP BY 							a. DepartmentID 
 HAVING 							count(a. DepartmentID ) =(SELECT MAX(kq) FROM cte_sl );
 
 ---  --- Question 5  Tạo view có chứa danh sách các câu hỏi có `do user` họ Nguyễn tạo ------------------------------
 
DROP VIEW IF EXISTS ok;
CREATE VIEW ok AS
SELECT UserFullName, q.Content
FROM Question   q
JOIN `Account`  a  ON q. CreatorID =a. AccountID
WHERE UserFullName LIKE "Nguyen%";
 
SELECT *
FROM ok 
WHERE UserFullName LIKE "Nguyen%";

 

