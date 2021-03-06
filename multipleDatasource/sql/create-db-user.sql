CREATE DATABASE sample_database;

CREATE USER 'sample'@'%' IDENTIFIED BY 'roqkf1!';

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES ON sample_database.* TO 'sample'@'%';

GRANT FILE ON *.* TO 'sample'@'%';