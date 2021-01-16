DROP TABLE IF EXISTS balance_details;
DROP TABLE IF EXISTS transaction_details;
CREATE TABLE balance_details
(
   id INT AUTO_INCREMENT PRIMARY KEY,
   acc_num VARCHAR (250) NOT NULL,
   updated_time TIMESTAMP WITH TIME ZONE NOT NULL,
   balance LONG NOT NULL
);
INSERT INTO balance_details
(
   acc_num,
   updated_time,
   balance
)
VALUES
(
   'abc',
   '2020-01-01T01:02:03.8Z',
   89.1
);
CREATE TABLE transaction_details
(
   id INT AUTO_INCREMENT PRIMARY KEY,
   acc_num VARCHAR (250) NOT NULL,
   transaction_time_stamp TIMESTAMP WITH TIME ZONE NOT NULL,
   amount LONG NOT NULL,
   type VARCHAR (250) NOT NULL
);
INSERT INTO transaction_details
(
   acc_num,
   transaction_time_stamp,
   amount,
   type
)
VALUES
(
   'abc',
   '2020-01-03T01:02:03.8Z',
   89.1,
   'DEPOSIT'
),

(
   'abc',
   '2020-01-03T01:02:03.8Z',
   49.1,
   'WITHDRAW'
);