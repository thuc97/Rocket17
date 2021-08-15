DROP DATABASE IF EXISTS		Bai_Thi_1;
CREATE DATABASE				Bai_Thi_1;
USE							Bai_Thi_1;

DROP TABLE IF EXISTS		Customer;
CREATE TABLE	Customer(
CustomerID		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Name_Customer	VARCHAR(50) NOT NULL,
Phone			CHAR(12) UNIQUE NOT NULL,
Email			VARCHAR(50) UNIQUE NOT NULL,
Address			VARCHAR(100) NOT NULL,
Note			VARCHAR(200) NOT NULL
);

DROP TABLE IF EXISTS		Car;
CREATE TABLE	Car(
CarID			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Maker			VARCHAR(20) NOT NULL,
Model			VARCHAR(50) NOT NULL,
`Year`			CHAR(4) NOT NULL,
Color			VARCHAR(20) NOT NULL,
Note			VARCHAR(200) NOT NULL
);

DROP TABLE IF EXISTS		`Order`;
CREATE TABLE	`Order`(
OrderID			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
CustomerID		INT  UNSIGNED  NOT NULL,
CarID			INT UNSIGNED NOT NULL,
Amount			TINYINT UNSIGNED DEFAULT 1,
SalePrice		INT UNSIGNED NOT NULL,
OrderDate		DATETIME NOT NULL,
DeliveryDate	DATETIME NOT NULL,
DeliveryAddress	VARCHAR(100) NOT NULL,
`Status`		TINYINT DEFAULT 0 CHECK(`Status` = 0 OR `Status` = 1 OR `Status` = 2),
Note			VARCHAR(200) NOT NULL,
FOREIGN KEY (CustomerID) REFERENCES	Customer(CustomerID),
FOREIGN KEY (CarID) REFERENCES	Car(CarID)
);

INSERT INTO		Customer(Name_Customer				, Phone		, Email						, Address					, Note		 		)
VALUE					('Nguyen Van Trung'	, 0363001112, 'Nguyenvantrung@gmail.com', '2/4 Phao Dai Lang'		, 'Khach Vip'		),
						('Nguyen Ba Thuc'  	, 0363234131, 'Nguyenbathuc@gmail.com'	, '4/67 Duong Lang'			, 'Khach Ruộc' 		),
                        ('Trần Hữu Minh'   	, 0363076145, 'Tranhuminh@gmail.com'	, '4//45 NGuyen CHi Thanh'	, 'Khach Vip'		),
                        ('Le Van Manh'		, 0363040812, 'Lehumanh@gmail.com'		, '123/34 Linh Dam'			, 'Khach Quen'		),
                        ('Ton Hong Son'		, 0363011395, 'Tonghongson@gmail.com'	, '54/3 Giai Phong'			, 'Khach Mua Nhieu' );

INSERT INTO		Car		(Maker		, Model			, `Year`, Color		, Note		 	)
VALUE					('HONDA'	, 'CR-V'		, 2020	, 'white'	, 'Xe luot'		),
						('TOYOTA'  	, 'CAMRY'		, 2020	, 'black'	, 'Xe lươt'	 	),
                        ('NISSAN'   , 'xpander'		, 2020	, 'yellow'	, 'Xe Mơi'		),
                        ('Ford'		, 'mustang 1967', 1967	, 'red'		, 'Hang hiem'	),
                        ('Mercedes'	, 's650 maybach', 2021	, 'green'	, 'Sieu Pham' 	);
                        
INSERT INTO		`Order`	(CustomerID	, CarID	, Amount, SalePrice		, OrderDate , DeliveryDate	,  DeliveryAddress			, `Status`	, Note			)
VALUE					(1			, 1		, 1		, 1200			, '2020/2/9', '2020/1/19'	,	'2/4 Phao Dai Lang'		, 0			,'Giao Dung Hen'),
						(2			, 2		, 1		, 2450			, '2020/1/5', '2020/3/15'	,	'4/67 Duong Lang'		, 1			,'Giao Dung Hen'),
                        (1			, 4		, 1		, 12000			, '2020/1/9', '2020/7/19'	,	'2/4 Phao Dai Lang'		, 2			,'Giao Dung Hen'),
                        (4			, 4		, 1		, 12000			, '2021/1/1', '2020/2/11'	,	'123/34 Linh Dam'		, 0			,'Giao Dung Hen'),
                        (5			, 5		, 1		, 20000			, '2021/1/3', '2020/5/13'	,	'54/3 Giai Phong'		, 1			,'Giao Dung Hen'),
						(3			, 4		, 1		, 12000			, '2021/1/3', '2020/5/13'	,	'4//45 NGuyen CHi Thanh', 1			,'Giao Dung Hen');



-

------ Question2  Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã  mua và sắp sếp tăng dần theo số lượng oto đã mua.

SELECT cs.Name_Customer	, odr.Amount ,count(odr.CustomerID	) 
FROM Customer  cs      
JOIN `Order` odr   ON cs.CustomerID =odr.CustomerID	
GROUP BY odr.CustomerID	;


----- 3. Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều oto nhất trong năm nay





DROP PROCEDURE IF EXISTS name_of_car ;
DELIMITER $$ 
CREATE PROCEDURE name_of_car ()
BEGIN 
WITH cte_maxofcount AS (
SELECT od.OrderDate ,count(od.CarID) as RS
FROM `Order` od      
WHERE year(OrderDate)	=year(now())
GROUP BY od.CarID 
)
SELECT cr.Maker,odr.OrderDate ,count(odr.CarID )
FROM Car  cr      
LEFT JOIN `Order` odr   ON cr.CarID	=odr.CarID 
WHERE year(OrderDate)	=year(now())
GROUP BY odr.CarID 
HAVING count(odr.CarID )= (SELECT max(RS) FROM  cte_maxofcount );
END $$
DELIMITER ;
CALL name_of_car ();


-------- 4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của những năm trước. In ra số lượng bản ghi đã bị xóa.

DELETE 
FROM `Order` o
WHERE `Status`=2 AND year(o.OrderDate ) <year(now());
DROP TRIGGER IF EXISTS delete_order;
DELIMITER $$
 CREATE TRIGGER delete_order
AFTER DELETE ON `Order`
 FOR EACH ROW
BEGIN
DELETE
FROM `Order` WHERE `Status`=OLD.`Status`;
END$$
 DELIMITER ;
 
 
----- QS 5 : Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn 
------ hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto và tên hãng sản xuất.

DROP PROCEDURE IF EXISTS print_oder;
DELIMITER $$ 
CREATE PROCEDURE print_oder (IN nhap_CustomerID SMALLINT )
BEGIN 
 SELECT c.Name_Customer	, cr.Maker ,cr.Model	,count(o.CustomerID) as SL
FROM `Order` o
JOIN Customer  c      ON o.CustomerID	=c.CustomerID
JOIN Car	   cr     ON o.CarID	    =cr.CarID
WHERE `Status`=0  AND	o.CustomerID =nhap_CustomerID 
GROUP BY o.CustomerID;
END $$
DELIMITER ;
CALL print_oder(1);

 

-------   Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ 
--------  vào database (DeliveryDate < OrderDate + 15).


DROP TRIGGER IF EXISTS Insert_information;
DELIMITER $$
 CREATE TRIGGER Insert_information
BEFORE INSERT ON `Order`
FOR EACH ROW
BEGIN
IF(NEW.DeliveryDate<NEW.OrderDate + INTERVAL 15 DAY         ) THEN
 SIGNAL SQLSTATE '12345'
 SET MESSAGE_TEXT ="User can not input any information";
 END IF;
END$$
 DELIMITER ;
INSERT INTO `Order`     (CustomerID	, CarID	, Amount, SalePrice		, OrderDate , DeliveryDate	,  DeliveryAddress			, `Status`	, Note			)
VALUES				    (1			, 1		, 1		, 1200			, '2021/2/9', '2020/1/19'	,	'2/4 Phao Dai Lang'		, 0			,'Giao Dung Hen'),
						(2			, 2		, 1		, 2450			, '2021/1/5', '2020/3/15'	,	'4/67 Duong Lang'		, 1			,'Giao Dung Hen');

 



 
 


