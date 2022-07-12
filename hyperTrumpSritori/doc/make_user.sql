-- > mysql -u root -p
-- > root


-- IDENTIFIED = passwprdのこと
CREATE USER 'word_user'@'localhost' IDENTIFIED BY 'word_user';

GRANT ALL ON word_db.* TO 'word_user'@'localhost';