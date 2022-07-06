CREATE TABLE Sample10 (
	no			INT(11)			DEFAULT NULL,
	name		VARCHAR(20) 	DEFAULT NULL,
	birthday	DATE			DEFAULT NULL,
	address		VARCHAR(20) 	DEFAULT NULL
);

SELECT * FROM Sample10;
DROP TABLE Sample10;

INSERT INTO Sample10 VALUES (1, '유비', '1996-10-25', '대구광역시 중구 반월당');
INSERT INTO Sample10 VALUES (2, '관우', '1997-01-15', '대구광역시 서구 비산동');
INSERT INTO Sample10 VALUES (3, '장비', '1997-03-04', '대구광역시 남구 봉덕동');

---------------------------------------------------------------------------
CREATE TABLE Customer (
	cid			BIGINT			PRIMARY KEY	AUTO_INCREMENT,
	name		VARCHAR(20)		NOT NULL,
	ssn			VARCHAR(14)		NOT NULL,
	phone		VARCHAR(14)		NOT NULL,
	customerId	VARCHAR(16)		NOT NULL,
	passwd		VARCHAR(16)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001;

ALTER TABLE Customer CHANGE customerId userId VARCHAR(16) NOT NULL;

SELECT * FROM Customer;
INSERT INTO Customer (name, ssn, phone, customerId, passwd) VALUES ('유비', '970115-1234567', '010-4444-4444', 'asdf1234', 'qwer1234');
INSERT INTO Customer (name, ssn, phone, customerId, passwd) VALUES ('관우', '961025-7894561', '010-1234-5678', 'zxcv4567', 'tbgb1234');
INSERT INTO Customer (name, ssn, phone, customerId, passwd) VALUES ('장비', '840104-1234567', '010-9101-1213', 'vbnm1538', 'yjtrher1');

UPDATE Customer SET cid='1002' WHERE cid=1007;
DELETE FROM Customer WHERE cid=1010;
DROP TABLE Customer;

---------------------------------------------------------------------------

CREATE TABLE Account(
	aid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	accountNum		VARCHAR(11)		NOT NULL,		-- 111-11-1111
	balance 		DOUBLE			NOT NULL	DEFAULT 0.0,
	interestRate	DOUBLE			NOT NULL 	DEFAULT 0.0,
	overdraft		DOUBLE			NOT NULL	DEFAULT 0.0,
	accountType		CHAR(1)			NOT NULL	DEFAULT 'S',
	customerId		BIGINT			NOT NULL,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT Account_customerId_FK FOREIGN KEY (customerId) REFERENCES Customer(cid)
)AUTO_INCREMENT = 3001;


SELECT * FROM Account; 
INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId)
VALUES ('111-11-1111', '100', '1', '1000', 'A', '1001'), 
('222-22-2222', '200', '2', '2000', 'B', '1002'), 
('333-33-3333', '300', '3', '3000', 'C', '1003');

-- inner join
-- 약식 조건 코드
SELECT * FROM Account, Customer WHERE Account.customerId = Customer.cid AND Customer.ssn = "970115-1234567"; 

-- 정식 코드
SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid;

-- 정식 조건 코드
SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = "970115-1234567";



-- 문제 3

SELECT aid, accountNum, accountType, balance FROM Account a INNER JOIN Customer c ON c.ssn = '840104-1234567';









