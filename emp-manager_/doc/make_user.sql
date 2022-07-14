-- > mysql -u root -p
-- > root

CREATE USER 'empdb_user'@'localhost' IDENTIFIED BY 'empdb_user';

GRANT ALL ON emp_db.* TO 'empdb_user'@'localhost';