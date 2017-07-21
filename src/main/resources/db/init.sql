CREATE TABLE users
(
  id    BIGINT       NOT NULL,
  login VARCHAR(255) NOT NULL,
  name  VARCHAR(255),
  PRIMARY KEY (id)
);

INSERT INTO users VALUES(1, 'admin', 'Администратор');
INSERT INTO users VALUES(2, 'dima', 'Дмитрий');
INSERT INTO users VALUES(3, 'vanya', 'Иван');
INSERT INTO users VALUES(4, 'olya', 'Ольга');
