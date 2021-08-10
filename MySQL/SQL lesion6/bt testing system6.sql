
USE Testing_System_Assignment4 ;

------- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các `account` thuộc phòng ban đó
DROP PROCEDURE IF EXISTS nhap_phong_ban ;
DELIMITER $$
CREATE PROCEDURE nhap_phong_ban (IN nhap VARCHAR(50))
BEGIN
SELECT d.DepartmentName, a.AccountID
FROM department d 
RIGHT JOIN `account` a  ON d.DepartmentID=a.DepartmentID
WHERE d.DepartmentName=nhap;
END $$
DELIMITER ;
CALL nhap_phong_ban ('sale');

------ Question 2: Tạo store để in ra số lượng `account` trong mỗi `group`
DROP PROCEDURE IF EXISTS SL ;
DELIMITER $$
CREATE PROCEDURE SL (IN groupname VARCHAR(50))
BEGIN
SELECT g.`GroupName`  , count(ga.AccountID)
FROM `group account` ga 
LEFT JOIN `account` a ON ga.AccountID=a.AccountID
JOIN `group` g        ON  g.GroupID =ga.GroupID
GROUP BY  ga.AccountID
HAVING g.`GroupName` =groupname;

END$$
DELIMITER ;
CALL SL ('samsung');

----- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo   trong tháng hiện tại
DROP PROCEDURE IF EXISTS count_of_typequestion ;
DELIMITER $$
CREATE PROCEDURE count_of_typequestion (IN nhap_typequestion VARCHAR(50))
BEGIN
SELECT * ,count(q.TypeID) as soluongquestion
FROM `typequestion` ty  
LEFT JOIN question q ON ty.TypeID=q.TypeID
GROUP BY q.TypeID 
HAVING ty.TypeName= nhap_typequestion AND month(CreateDate) = month(now());
END $$
DELIMITER ;
CALL count_of_typequestion  ('Essay');

------ Question 4: Tạo store để trả ra id của `type` question có nhiều câu hỏi nhất

DROP PROCEDURE IF EXISTS maxtyquestion ;
DELIMITER $$
CREATE PROCEDURE maxtyquestion (OUT id INT)
BEGIN
WITH CTE_idoftyquestion  AS(
SELECT count(q.TypeID) as soluongquestion
FROM `question` q  
GROUP BY q.TypeID 
)
SELECT ty.TypeID  as soluongquestion INTO id
FROM `typequestion` ty  
LEFT JOIN question q ON ty.TypeID=q.TypeID
GROUP BY q.TypeID 
HAVING count(q.TypeID) = (SELECT Max(soluongquestion) FROM CTE_idoftyquestion);
END $$
DELIMITER ;
CALL maxtyquestion(@id);
SELECT @id;

-----  Question 5: Sử dụng store ở question 4 để tìm ra tên của type question

DROP PROCEDURE IF EXISTS maxtyquestion ;
DELIMITER $$
CREATE PROCEDURE maxtyquestion (OUT id INT)
BEGIN
WITH CTE_idoftyquestion  AS(
SELECT count(q.TypeID) as soluongquestion
FROM `question` q  
GROUP BY q.TypeID 
)
SELECT ty.TypeID  as soluongquestion INTO id
FROM `typequestion` ty  
LEFT JOIN question q ON ty.TypeID=q.TypeID
GROUP BY q.TypeID 
HAVING count(q.TypeID) = (SELECT Max(soluongquestion) FROM CTE_idoftyquestion);
END $$
DELIMITER ;
CALL maxtyquestion(@id);
SELECT @id;
SELECT TypeName FROM typequestion WHERE TypeID=@id ;

 
-------  Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về `group `có tên 
-------  chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa 
-------- chuỗi của người dùng nhập vào
DROP PROCEDURE IF EXISTS getgroupname_and_username;
DELIMITER $$
CREATE PROCEDURE getgroupname_and_username (IN nhap_chuoi VARCHAR(50))
BEGIN
SELECT `GroupName` FROM `group`  WHERE  `GroupName` LIKE concat(nhap_chuoi,"%")
UNION
SELECT `UserFullName` FROM `account` WHERE `UserFullName` LIKE concat(nhap_chuoi,"%");
END $$
DELIMITER ;
CALL getgroupname_and_username ('l');

-------    Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và 
--------   trong store sẽ tự động gán:
--------   username sẽ giống email nhưng bỏ phần @..mail đi
--------   positionID: sẽ có default là developer
--------   departmentID: sẽ được cho vào 1 phòng chờ
--------   Sau đó in ra kết quả tạo thành công

DROP PROCEDURE IF EXISTS sp_insertAccount;
DELIMITER $$
CREATE PROCEDURE sp_insertAccount
( IN nhap_Email VARCHAR(50),
IN nhap_UserFullName VARCHAR(50))
BEGIN
DECLARE nhap_UserFullName VARCHAR(50)  DEFAULT SUBSTRING_INDEX(nhap_Email, '@', 1) ;
DECLARE nhap_Email VARCHAR(50) ;
DECLARE nhap_DepartmentID TINYINT UNSIGNED DEFAULT 11 ;
DECLARE nhap_PositionID TINYINT UNSIGNED DEFAULT 1;
DECLARE nhap_CreateDate DATETIME DEFAULT now();
INSERT INTO `account` ( `UserFullName`, `Email`,
`DepartmentID`, `PositionID`, `CreateDate`) 
VALUES ( nhap_UserFullName, 'nguyen@haui.com.vn' ,
nhap_DepartmentID, nhap_PositionID, nhap_CreateDate );
END$$
DELIMITER ;
Call sp_insertAccount('b@com.vn','le nguyen');
SELECT * FROM `account`;

------ Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
------  để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

DROP PROCEDURE IF EXISTS count_of_typequestion ;
DELIMITER $$
CREATE PROCEDURE count_of_typequestion (IN nhap_typequestion VARCHAR(50))
BEGIN
SELECT ty.TypeName , question .Content 
FROM `typequestion` ty  
LEFT JOIN question  ON ty.TypeID= question .TypeID
WHERE ty.TypeName=nhap_typequestion AND length( question .Content)=(SELECT MAX(length( question .Content ))FROM question);
END $$ 
DELIMITER ;
CALL count_of_typequestion('Essay');
--------- 

--- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS deletexam;
DELIMITER $$ 
CREATE PROCEDURE deletexam (IN  ok VARCHAR(50) ,OUT id INT)
BEGIN
SELECT ExamID INTO id
FROM   `exam`
WHERE `Title` = ok ;
END$$
DELIMITER ;
CALL deletexam('vit',@id);
SELECT @id;
DELETE FROM exam
WHERE ExamID =@id;

----- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử  dụng store ở câu 9 để xóa)
------  Sau đó in số lượng record đã remove từ các table liên quan trong khi  removing


-- ----- Question 11 Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
------   nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
------   chuyển về phòng ban default là phòng ban chờ việc

DROP PROCEDURE IF EXISTS deletedpment;
DELIMITER $$ 
CREATE PROCEDURE deletedpment(IN nhap_phong_ban VARCHAR(50) )
BEGIN
DECLARE iddepat INT;
SELECT D2. DepartmentID  INTO iddepat
FROM   department D2
WHERE D2. DepartmentName =nhap_phong_ban ;
UPDATE `account` SET `account`.DepartmentID ='15' WHERE DepartmentID =iddepat;
DELETE FROM department WHERE   DepartmentName = nhap_phong_ban;
SELECT iddepat;
END$$
DELIMITER ;
CALL deletedpment('sale');
SELECT * FROM department;


------ Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6   tháng gần đây nhất

DROP PROCEDURE IF EXISTS haft_month;
DELIMITER $$ 
CREATE PROCEDURE haft_month (IN question_of_month INT)
BEGIN
SELECT q.Content ,q.`CreateDate` ,count(month(q.`CreateDate`))
FROM question  q
WHERE  month(q.`CreateDate`)>=6  AND month(q.`CreateDate`) =question_of_month ;
END$$
DELIMITER ;
CALL haft_month('6');


----------- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm  nay
-----------  cách 1 là tự động nhập tháng => sẽ in ra câu hỏi cần tìm trong tháng và trong năm 
DROP PROCEDURE IF EXISTS sp_aCountQuesInMonth;
DELIMITER $$
CREATE PROCEDURE sp_aCountQuesInMonth( IN nhapdate INT)
BEGIN
SELECT q.Content ,q.`CreateDate` ,count(month(q.`CreateDate`))
FROM question  q
WHERE  year(q.`CreateDate`)=year(now()) AND month(q.`CreateDate`) =nhapdate ;
END$$
DELIMITER ;
Call sp_aCountQuesInMonth('7');

----- cách 2 : gọi trực  tiếp  ko cần hàm In,out  => sẽ ra kết quả tự động 
DROP PROCEDURE IF EXISTS sp_CountQuesInMonth;
DELIMITER $$
CREATE PROCEDURE sp_CountQuesInMonth()
BEGIN
WITH CTE_12Months AS (
 SELECT 1 AS MONTH
 UNION SELECT 2 AS MONTH
 UNION SELECT 3 AS MONTH
 UNION SELECT 4 AS MONTH
 UNION SELECT 5 AS MONTH
 UNION SELECT 6 AS MONTH
 UNION SELECT 7 AS MONTH
 UNION SELECT 8 AS MONTH
 UNION SELECT 9 AS MONTH
 UNION SELECT 10 AS MONTH
 UNION SELECT 11 AS MONTH
 UNION SELECT 12 AS MONTH
)
SELECT M.MONTH ,count(C.`Content`)
FROM CTE_12Months  as M
LEFT JOIN (SELECT q.`CreateDate`,q.Content FROM question as q WHERE year(q.`CreateDate`)  =year(now())) as C
ON M.MONTH = MONTH( C.`CreateDate`)
GROUP BY M.MONTH;
END$$
DELIMITER ;
Call sp_CountQuesInMonth();












































