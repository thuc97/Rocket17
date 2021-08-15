USE Testing_System_Assignment4 ;

--- Question 1: Tạo `trigger` không cho phép người dùng nhập vào `Group` có ngày tạo   trước 1 năm trước
DROP TRIGGER  IF EXISTS insert_togroup ;
DELIMITER $$ 
CREATE TRIGGER  insert_togroup 
BEFORE INSERT ON `group` 
FOR EACH ROW 
BEGIN 
IF (NEW.CreateDate<(now()) -INTERVAL 1 YEAR  ) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT ="Can not input any information into group";
END IF ;
END $$
DELIMITER ;

INSERT INTO `group`      (         GroupName                ,                CreatorID     ,        CreateDate        )                 
VALUES                   (           'samsung'              ,      	           1	      ,        '2020-09-06'       );




--------- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào 
--------- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department  "Sale" cannot add more user"


DROP TRIGGER  IF EXISTS insert_to_acount ;
DELIMITER $$ 
CREATE TRIGGER  insert_to_acount
BEFORE INSERT ON `account`
FOR EACH ROW 
BEGIN 
DECLARE nhapid INT ;
SELECT DepartmentID INTO nhapid  FROM `department` WHERE DepartmentName='sale';
IF(NEW.DepartmentID=nhapid) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT ="cannot add more user";
END IF ;
END$$
DELIMITER ;

INSERT INTO   `account`   (           Email                ,           UserFullName        ,        DepartmentID    ,      PositionID       ,        CreateDate       )  
 VALUE                     (       '1'                        ,        '1'       ,               '2'        ,            '3'          ,       '2020-11-12');


------  Question 3: Cấu hình 1 `group` có nhiều nhất là 5 `user`

DROP TRIGGER IF EXISTS AddAccountToGroup;
DELIMITER $$
CREATE TRIGGER AddAccountToGroup
 BEFORE INSERT ON `group account`
 FOR EACH ROW
 BEGIN
DECLARE var_CountGroupID TINYINT;
SELECT count(GA.GroupID) INTO var_CountGroupID FROM 
`group account` GA
WHERE GA.GroupID= NEW.GroupID;
IF (var_CountGroupID >5) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Cant add more User to This Group';
END IF; 
 END$$
DELIMITER ;
INSERT INTO `group account` (`GroupID`, `AccountID`, `JoinDate`) 
VALUES (1, 1, 
'2020-05-11 00:00:00');



------- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question

DROP TRIGGER IF EXISTS AddAquestionToexam;
DELIMITER $$
CREATE TRIGGER AddAquestionToexam
 BEFORE INSERT ON `examquestion`
 FOR EACH ROW
 BEGIN
DECLARE var_CountquestionID TINYINT;
SELECT count(ex. QuestionID) INTO var_CountquestionID FROM 
`examquestion` ex
WHERE ex. QuestionID= NEW.QuestionID ;
IF (var_CountquestionID >1) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Cant add more User to This question';
END IF; 
 END$$
DELIMITER ;
INSERT INTO `examquestion` (`QuestionID`) 
VALUES ('1'),
       ('2');


-------  Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là 
-------- `admin@gmail.com (đây là tài khoản admin, không cho phép user xóa), 
-------- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông  tin liên quan tới user đó


DROP TRIGGER  IF EXISTS delete_acount ;
DELIMITER $$ 
CREATE TRIGGER delete_acount
BEFORE DELETE ON `account`
FOR EACH ROW 
BEGIN 
IF(OLD.Email='duy@gmail.com' ) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT ="đây là tài khoản admin";
END IF;
END$$
DELIMITER ;
DELETE FROM `account` 
WHERE Email = 'duy@gmail.com' ;

------- Question 6: Không sử dụng cấu hình `default` cho field DepartmentID của `table` 
------- `Account`, hãy tạo `trigger` cho phép người dùng khi tạo `account` không điền 
------- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"

DROP TRIGGER IF EXISTS Trg_SetDepWaittingRoom;
DELIMITER $$
CREATE TRIGGER Trg_SetDepWaittingRoom
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
DECLARE v_WaittingRoom VARCHAR(50);
 SELECT D.DepartmentID INTO v_WaittingRoom FROM department D WHERE 
D.DepartmentName = 'Waitting Room';
IF (NEW.DepartmentID IS NULL ) THEN
SET NEW.DepartmentID = v_WaittingRoom;
 END IF;
END $$
DELIMITER ;
INSERT INTO `account` (`Email`, `UserFullName`, `PositionID`, 
`CreateDate`) 
VALUE ('1',
'1', "",'1', '2019-07-15');


-----  Question 8: Viết trigger sửa lại dữ liệu cho đúng: 
----- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định 
------ Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database


DROP TRIGGER IF EXISTS Trg_GenderFromInput;
DELIMITER $$
CREATE TRIGGER Trg_GenderFromInput
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
 IF NEW.Gender = 'Nam' THEN
 SET NEW.Gender = 'M';
 ELSEIF NEW.Gender = 'Nu' THEN
 SET NEW.Gender = 'F';
 ELSEIF NEW.Gender = 'Chưa xác định' THEN
 SET NEW.Gender = 'U';
 END IF ;
END $$
DELIMITER ;

------- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày


DROP TRIGGER  IF EXISTS delete_exam ;
DELIMITER $$ 
CREATE TRIGGER delete_exam
BEFORE DELETE ON `exam`
FOR EACH ROW 
BEGIN 
DECLARE new_date DATETIME ;
SET new_date =  DATE_SUB(NOW(),INTERVAL 2 DAY);
IF(OLD.CreateDate<new_date) THEN 
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = "NG";
END IF;
END$$  
DELIMITER ;
DELETE
FROM `exam` 
WHERE ExamID =1;






-------   Question 10: Viết` trigger` chỉ cho phép người dùng chỉ được `update, delete` các 
-------  question khi question đó chưa nằm trong exam nào

----- update
DROP TRIGGER IF EXISTS Trg_CheckBefUpdateQues;
DELIMITER $$
CREATE TRIGGER Trg_CheckBefUpdateQues
BEFORE UPDATE ON `question`
FOR EACH ROW
BEGIN
 DECLARE v_CountQuesByID TINYINT;
 SELECT count(ex.QuestionID) INTO v_CountQuesByID FROM examquestion ex
 WHERE ex.QuestionID = NEW.QuestionID;
 IF (v_CountQuesByID !=1) THEN    
SIGNAL SQLSTATE '12345'
 SET MESSAGE_TEXT = 'Cant Update This Question';
 END IF ; 
END $$ 
DELIMITER ;
UPDATE `question` SET `Content` = 'Question VTI 2599 lL6 1' WHERE 
(QuestionID = '2');

DROP TRIGGER IF EXISTS `update`;
DELIMITER $$
CREATE TRIGGER `update`
BEFORE UPDATE ON `exam` 
FOR EACH ROW 
BEGIN
DECLARE nhapex INT ;
SELECT ExamID INTO nhapex   FROM   `exam` 
WHERE ExamID =NEW.ExamID;
IF(nhapex !=2) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Cant Update This Q EXAM'; 
END IF ;
END $$
DELIMITER ;
SELECT * FROM  `exam`     WHERE DAY(CreateDate) = (DAY(now()) - 12 );


------ Question 12: Lấy ra thông tin exam trong đó:
------ Duration <= 30 thì sẽ đổi thành giá trị "Short time"
------ 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
------- Duration > 60 thì sẽ đổi thành giá trị "Long time"

SELECT `exam`.Duration ,CASE
WHEN `exam`.Duration <=30 THEN "Short time"
WHEN `exam`.Duration <=60 THEN "Medium time"
WHEN `exam`.Duration >60 THEN "Long time"
END
FROM `exam`;



-----  Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên 
------ là the_number_user_amount và mang giá trị được quy định như sau:
------  Nếu số lượng `user` trong `group` =< 5 thì sẽ có giá trị là few
------  Nếu số lượng `user` trong `group` <= 20 và > 5 thì sẽ có giá trị là normal
------- Nếu số lượng `user` trong `group` > 20 thì sẽ có giá trị là higher 


SELECT g.AccountID  ,g.GroupID ,count(g.AccountID) , CASE
WHEN count(g.AccountID) <=5 THEN "few"
WHEN count(g.AccountID) <=20 THEN "nomal"
WHEN count(g.AccountID)>20 THEN "higher"
END  AS the_number_user_amount
FROM `group account` g  GROUP BY g.AccountID;



---------   Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào 
---------  không có user thì sẽ thay đổi giá trị 0 thành "Không có User"

SELECT a.DepartmentID ,a.UserFullName,count(a.DepartmentID ) ,CASE
WHEN( a.DepartmentID IS NULL )  THEN "Không có User"
END 
FROM `account` a
RIGHT JOIN  `department` d ON a.DepartmentID =d.DepartmentID 
GROUP BY a.DepartmentID ;

