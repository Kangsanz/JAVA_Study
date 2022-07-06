-- Customer2 테이블 생성
CREATE TABLE Customer2 (
	cid			BIGINT			PRIMARY KEY	AUTO_INCREMENT,
	name		VARCHAR(10)		NOT NULL,
	ssn			VARCHAR(14)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001;

-- Customer2 테이블 확인
SELECT * FROM Customer2;
-- Customer2 값 입력
INSERT INTO Customer2 (name, ssn) VALUES ('홍길동', '801225-1234567');


-- Account2 테이블 생성
CREATE TABLE Account2(
	aid					BIGINT			PRIMARY KEY AUTO_INCREMENT,
	accountType			CHAR(1)			NOT NULL	DEFAULT 'S',
	balance 			DOUBLE			NOT NULL	DEFAULT 0.0,
	interestRate		DOUBLE			NOT NULL 	DEFAULT 0.0,
	overdraftAmount		DOUBLE			NOT NULL	DEFAULT 0.0,
	customerId			BIGINT			NOT NULL,
	regDate				TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	
	-- Customer2의 cid와 Account2의 customerId을 연동
	CONSTRAINT Account2_customerId_FK FOREIGN KEY (customerId) REFERENCES Customer2(cid)
)AUTO_INCREMENT = 3001;

-- Account2 테이블 확인
SELECT * FROM Account2;
-- Account2 값 입력
INSERT INTO Account2 (accountType, balance, interestRate, overdraftAmount, customerId) VALUES ('A', '2000.0', '0.03', '2000.0', '1001');

-- inner join
SELECT * FROM Customer2 c INNER JOIN Account2 a ON c.cid = a.customerId;