-- > mysql -u root -p
-- > root


-- IDENTIFIED = passwprdのこと
CREATE USER 'empdb_user'@'localhost' IDENTIFIED BY 'empdb_user';

GRANT ALL ON emp_db.* TO 'empdb_user'@'localhost';