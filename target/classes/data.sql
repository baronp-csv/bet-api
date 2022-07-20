SET REFERENTIAL_INTEGRITY FALSE;
TRUNCATE TABLE bet;
SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE bet ALTER COLUMN id RESTART WITH 1;

INSERT INTO bet(ticker, start_date, end_date, prediction) VALUES('Apple', '2022-01-01' ,'2022-01-15',153.0);
INSERT INTO bet(ticker, start_date, end_date, prediction) VALUES('Google', '2022-04-01' ,'2022-04-15',77.0);
INSERT INTO bet(ticker, start_date, end_date, prediction) VALUES('Facebook', '2022-03-01' ,'2022-03-15',67.0);
INSERT INTO bet(ticker, start_date, end_date, prediction) VALUES('Oracle', '2022-02-01' ,'2022-02-15',99.0);

SET REFERENTIAL_INTEGRITY FALSE;
TRUNCATE TABLE user;
SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE user ALTER COLUMN id RESTART WITH 1;
INSERT INTO user(username,password) VALUES('test','test');
