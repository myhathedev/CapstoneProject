DROP DATABASE IELTS_DB;

CREATE DATABASE IELTS_DB;

Use IELTS_DB;

Create table Users(
ID INT NOT NULL AUTO_INCREMENT UNIQUE KEY,
FULLNAME VARCHAR(30) NOT NULL,
EMAIL VARCHAR(30) PRIMARY KEY,
USERNAME VARCHAR(30) NOT NULL UNIQUE KEY,
PASSWORD VARCHAR(30) NOT NULL,
ROLE VARCHAR(20)
);

INSERT INTO `ielts_db`.`users`
(
`FULLNAME`,
`EMAIL`,
`USERNAME`,
`PASSWORD`,
`ROLE`)
VALUES
("Tu Pham",
"pham0091@algonquinlive.com",
"pham0091",
"12345678",
"Admin");

INSERT INTO `ielts_db`.`users`
(
`FULLNAME`,
`EMAIL`,
`USERNAME`,
`PASSWORD`,
`ROLE`)
VALUES
("My Ha Cao",
"cao00108@algonquinlive.com",
"cao00108",
"12345678",
"Admin");

INSERT INTO `ielts_db`.`users`
(
`FULLNAME`,
`EMAIL`,
`USERNAME`,
`PASSWORD`,
`ROLE`)
VALUES
("Hongcheng Bu",
"bu000006@algonquinlive.com",
"bu000006",
"12345678",
"Admin");


INSERT INTO `ielts_db`.`users`
(
`FULLNAME`,
`EMAIL`,
`USERNAME`,
`PASSWORD`,
`ROLE`)
VALUES
("User 1",
"user1@algonquinlive.com",
"user1",
"12345678",
"User");

INSERT INTO `ielts_db`.`users`
(
`FULLNAME`,
`EMAIL`,
`USERNAME`,
`PASSWORD`,
`ROLE`)
VALUES
("User 2",
"user2@algonquinlive.com",
"user2",
"12345678",
"User");

