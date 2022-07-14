-- > mysql -u empdb_user -p
-- > empdb_user

-- データベースの作成

CREATE DATABASE IF NOT EXISTS emp_db;

-- データベースの使用宣言

USE emp_db;

DROP TABLE IF EXISTS emp;
DROP TABLE IF EXISTS dept;

-- dept表の定義
CREATE TABLE dept (
  did CHAR(4) PRIMARY KEY,
  dname VARCHAR(20) NOT NULL
);

-- emp表の定義
CREATE TABLE emp (
  id CHAR(6) PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  birthday DATE NOT NULL,
  dept_id CHAR(4) NOT NULL,
  CONSTRAINT fk_dept_id
  FOREIGN KEY (dept_id) REFERENCES dept (did)
);

-- 初期データ
INSERT INTO dept (did, dname) VALUES
('D001', '総務部'),
('D002', '経理部'),
('D003', '第一営業部'),
('D004', '第二営業部'),
('D005', '開発部'),
('D999', '-');

INSERT INTO emp (id, name, birthday, dept_id) VALUES
('EMP001', '染谷 翔太', '1992-09-03', 'D004'),
('EMP002', '二階堂 ふみ', '1994-09-21', 'D002'),
('EMP003', '窪塚 洋介', '1979-05-07', 'D003'),
('EMP004', '吉高 由里子', '1988-07-22', 'D001'),
('EMP005', '渡辺 哲', '1950-03-11', 'D005');

-- データの表示
SELECT * FROM dept;
SELECT * FROM emp;

-- 結合表
SELECT id, name, birthday, dept_id, dname
FROM emp e
  INNER JOIN dept d
  ON e.dept_id = d.did
\g

DROP VIEW IF EXISTS emp_v;

CREATE VIEW emp_v AS
SELECT id, name, birthday, dept_id, dname
FROM emp e
  INNER JOIN dept d
  ON e.dept_id = d.did;

-- SELECT * FROM emp_v;








