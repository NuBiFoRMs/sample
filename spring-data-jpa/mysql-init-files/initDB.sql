set @@global.sql_mode = "";

CREATE DATABASE manage CHARACTER SET utf8;

ALTER DATABASE manage
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

CREATE USER manage IDENTIFIED BY 'manage';
GRANT ALL PRIVILEGES ON manage.* TO manage;

USE manage;

CREATE TABLE IF NOT EXISTS owners (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  address VARCHAR(255),
  city VARCHAR(80),
  telephone VARCHAR(20),
  INDEX(last_name)
) engine=InnoDB;

INSERT IGNORE INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');
INSERT IGNORE INTO owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');
INSERT IGNORE INTO owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763');
INSERT IGNORE INTO owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198');
INSERT IGNORE INTO owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765');
INSERT IGNORE INTO owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654');
INSERT IGNORE INTO owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387');
INSERT IGNORE INTO owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683');
INSERT IGNORE INTO owners VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435');
INSERT IGNORE INTO owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487');

CREATE TABLE IF NOT EXISTS pets (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  birth_date DATE,
  owner_id INT(4) UNSIGNED NOT NULL,
  INDEX(name),
  FOREIGN KEY (owner_id) REFERENCES owners(id)
) engine=InnoDB;

INSERT IGNORE INTO pets VALUES (1, 'Leo', '2000-09-07', 1);
INSERT IGNORE INTO pets VALUES (2, 'Basil', '2002-08-06', 6);
INSERT IGNORE INTO pets VALUES (3, 'Rosy', '2001-04-17', 2);
INSERT IGNORE INTO pets VALUES (4, 'Jewel', '2000-03-07', 2);
INSERT IGNORE INTO pets VALUES (5, 'Iggy', '2000-11-30', 3);
INSERT IGNORE INTO pets VALUES (6, 'George', '2000-01-20', 4);
INSERT IGNORE INTO pets VALUES (7, 'Samantha', '1995-09-04', 1);
INSERT IGNORE INTO pets VALUES (8, 'Max', '1995-09-04', 1);
INSERT IGNORE INTO pets VALUES (9, 'Lucky', '1999-08-06', 5);
INSERT IGNORE INTO pets VALUES (10, 'Mulligan', '1997-02-24', 2);
INSERT IGNORE INTO pets VALUES (11, 'Freddy', '2000-03-09', 5);
INSERT IGNORE INTO pets VALUES (12, 'Lucky', '2000-06-24', 2);
INSERT IGNORE INTO pets VALUES (13, 'Sly', '2002-06-08', 1);

CREATE TABLE IF NOT EXISTS users (
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  email VARCHAR(100) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (username)
) engine=InnoDB;

INSERT IGNORE INTO users(username, password, enabled) VALUES ('admin', 'admin', true);
INSERT IGNORE INTO users(username, password, enabled) VALUES ('user', 'user', true);