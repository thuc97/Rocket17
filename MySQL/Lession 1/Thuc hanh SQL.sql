DROP DATABASE IF EXISTS salemanagement;
CREATE DATABASE salemanagement;
USE salemanagement;

CREATE TABLE customer (
		customer_id          INT,
		first_name           VARCHAR(50),
		last_name            VARCHAR(50),
		email                VARCHAR(100),
		date_of_purchase     DATE
	);

CREATE TABLE Sales (
		purchase_number          INT,
		date_of_purchase         DATE,
		customer_id              INT,
		item_code                VARCHAR(50)
		);
CREATE TABLE Items (
		item_code                VARCHAR(50),
		item_unit                VARCHAR(50),
		price_usd                INT,
		Company_id               INT,
		company                  VARCHAR(50),
		Heaquarters_phone_number  VARCHAR(50)
		);





