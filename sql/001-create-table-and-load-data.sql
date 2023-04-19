DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  address VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO users (name, address) VALUES ("青木", "東京");
INSERT INTO users (name, address) VALUES ("佐藤", "千葉");
INSERT INTO users (name, address) VALUES ("田中", "埼玉");
INSERT INTO users (name, address) VALUES ("鈴木", "東京");
