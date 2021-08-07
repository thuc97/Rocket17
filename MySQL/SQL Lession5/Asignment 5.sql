USE `adventureworks`;

------ Question 1------------------------------------------------

SELECT p.`Name`
FROM `product`p
JOIN `productsubcategory`pr ON p.ProductSubcategoryID=pr.ProductSubcategoryID
WHERE p.`Name` IN (SELECT `product`.`Name` FROM `product` WHERE `product` .ProductSubcategoryID =15);

---- Question 2 --------------------------------------------------

SELECT p.`Name`
FROM `product`p
WHERE p.`Name` IN (SELECT `product`.`Name` 
FROM `product` 
WHERE  `product`.`Name` LIKE "_____Bo%" 
OR `product`.`Name` LIKE "_________Bo%" 
OR   `product`.`Name` LIKE "______Bo%."
OR `product`.`Name` LIKE  "___Bo%__" );


-----  Question 3-------
-----  Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring 
-----  Bike (nghĩa là ProductSubcategoryID = 3)

WITH 
CTE_RS AS(
SELECT p.`Name`,p.ListPrice as ok
FROM `product`p
WHERE  p.ProductSubcategoryID =3
),
CTE_KAKA AS(
SELECT MIN(ok) as kq
FROM CTE_RS 
)
SELECT p1.`Name`,p1.ListPrice
FROM `product`p1
WHERE  p1.ListPrice = ( SELECT MIN(ok) as kq
FROM CTE_RS);

-----  Exercise 2: JOIN nhiều bảng 
------ Question 1 : Viết query lấy danh sách tên country và province được lưu trong AdventureWorks2008sample database. 
SELECT c.`Name` as country ,s.`Name` as Province, s.`CountryRegionCode`
FROM countryregion c
JOIN stateprovince s ON c.`CountryRegionCode`=s.`CountryRegionCode`;

----- Question 2: Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country Germany và Canada

WITH CTE_KQ AS(
SELECT c.`Name` as country ,s.`Name` as Province, s.`CountryRegionCode`
FROM countryregion c
JOIN stateprovince s ON c.`CountryRegionCode`=s.`CountryRegionCode`)
SELECT *
FROM CTE_KQ
WHERE country IN ('Canada', 'Germany')
ORDER BY CountryRegionCode ASC;

-----  Question 3:

SELECT sa.`SalesOrderID`,sa.`OrderDate`,s.`SalesPersonID`,s.`SalesPersonID` as `BusinessEntityID`,s.Bonus ,s.`SalesYTD`
FROM SalesPerson s
Join SalesOrderHeader sa ON s.`SalesPersonID`=sa.`SalesPersonID`
WHERE OnlineOrderFlag = 0 ;

------ Question 4:Sử dụng câu query ở question 3, thêm cột JobTitle `and` xóa cột SalesPersonID và BusinessEntityID

SELECT sa.`SalesOrderID`,sa.`OrderDate`,e.Title ,s.Bonus ,s.`SalesYTD`
FROM SalesPerson s
JOIN `employee`  e
Join SalesOrderHeader sa ON s.`SalesPersonID`=sa.`SalesPersonID`;
 
 
 
 
 
 
 
 
 
 
 

