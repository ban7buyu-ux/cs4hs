CREATE TABLE accounts ( id	INT PRIMARY KEY, name		VARCHAR(100),
balance DECIMAL(10,2)
);
INSERT INTO accounts VALUES (1, 'User', 5000.00), (2, 'Merchant', 1000.00);
-- Payment transaction START TRANSACTION;
UPDATE accounts SET balance = balance - 1500 WHERE id = 1;
-- Check sufficient balance
SELECT balance INTO @bal FROM accounts WHERE id = 1; IF @bal < 0 THEN
ROLLBACK;
SELECT 'Payment FAILED – Insufficient funds' AS status; ELSE
UPDATE accounts SET balance = balance + 1500 WHERE id = 2; COMMIT;
SELECT 'Payment SUCCESSFUL' AS status; END IF;

