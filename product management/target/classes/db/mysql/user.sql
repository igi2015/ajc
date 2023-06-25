CREATE DATABASE IF NOT EXISTS productmanagement;

ALTER DATABASE productmanagement
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON productmanagement.* TO 'productmanagement'@'%' IDENTIFIED BY 'productmanagement';
