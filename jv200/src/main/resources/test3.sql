-- 문제3-------------------------------------------------------------------------

SHOW TABLES;

SELECT * FROM Customer;

CREATE INDEX CustomerIndex ON Customer(ssn);

SELECT aid, accountNum, accountType, balance FROM Account a INNER JOIN Customer c ON c.ssn = '840104-1234567';
