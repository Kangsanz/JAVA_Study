CREATE TABLE BigCategory (
	bid			    INT		 		PRIMARY KEY AUTO_INCREMENT,
	bigName			VARCHAR(20)		NOT NULL
) AUTO_INCREMENT = 2001;

SELECT * FROM BigCategory;
DROP TABLE BigCategory;

INSERT INTO BigCategory bigName VALUES 'drink';
INSERT INTO BigCategory bigName VALUES 'dessert';


CREATE TABLE MidCategory (
	mid			    INT			 	PRIMARY KEY AUTO_INCREMENT,
	midBigCategory	INT				NOT NULL,
	midName			VARCHAR(20)		NOT NULL,
	
	CONSTRAINT MidCategory_midBigCategory_FK FOREIGN KEY (midBigCategory) REFERENCES BigCategory(bid)
) AUTO_INCREMENT = 3001;

SELECT * FROM MidCategory;
DROP TABLE MidCategory;

INSERT INTO MidCategory (midBigCategory, midName) VALUES ('2001','coffee');
INSERT INTO MidCategory (midBigCategory, midName) VALUES ('2001','nonCoffee');
INSERT INTO MidCategory (midBigCategory, midName) VALUES ('2002','Cake');
INSERT INTO MidCategory (midBigCategory, midName) VALUES ('2002','Cookie');


CREATE TABLE Product (
	pId			     INT		    PRIMARY KEY AUTO_INCREMENT,
	proMidCategory	 INT			NOT NULL,
	proName 	   	 VARCHAR(20)	NOT NULL,
	proPrice	     BIGINT		    NOT NULL,
	proImage 		 VARCHAR(40),
	
	CONSTRAINT Product_proMidCategory_FK FOREIGN KEY (proMidCategory) REFERENCES MidCategory(mid)
) AUTO_INCREMENT = 101;

SELECT * FROM Product;
DROP TABLE Product;

INSERT INTO Product (proMidCategory, proName, proPrice, proImage) VALUES ('3001','아메리카노','2000','아메리카노.jpg');
INSERT INTO Product (proMidCategory, proName, proPrice, proImage) VALUES ('3002','녹차라떼','3000','녹차라떼.jpg');
INSERT INTO Product (proMidCategory, proName, proPrice, proImage) VALUES ('3003','딸기케이크','6500','딸기케이크.jpg');
INSERT INTO Product (proMidCategory, proName, proPrice, proImage) VALUES ('3004','민트초코쿠키','3000','민트초코쿠키.jpg');

SELECT * FROM Product a INNER JOIN MidCategory b INNER JOIN BigCategory c ON a.proMidCategory = b.mid AND b.midBigCategory = c.bid WHERE c.bigName = 'drink'