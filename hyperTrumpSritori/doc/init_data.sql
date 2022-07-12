-- > mysql -u word -p
-- > word_user



-- データベースの作成

CREATE DATABASE IF NOT EXISTS word;



-- データベースの使用宣言

USE word;


-- DORP関連

DROP TABLE IF EXISTS word;   -- 定義するときはempが先
-- DROP TABLE IF EXISTS dept;  -- empはdeptを参照しているのでempを先には消せない



--  いったん断念




-- word表の定義

CREATE TABLE dept (
	did CHAR(4) PRIMARY KEY,
	dname VARCHAR(20) NOT NULL
);


-- emp表の定義

CREATE TABLE emp (
	id CHAR(6) PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	birthday DATE NOT NULL,
	dept_id CHAR(4) NOT NULL,    -- 外部キー接続(dept表のdidを参照する)
	CONSTRAINT fk_dept_id FOREIGN KEY (dept_id) REFERENCES dept (did)  -- 制約(今回は外部制約)
);



-- 初期データの挿入

INSERT INTO dept (did, dname) VALUES
('D001', '総務部'),
('D002', '経理部'),
('D003', '第一営業部'),
('D004', '第二営業部'),
('D005', '開発部'),
('D999', '-');


INSERT INTO emp (id, name, birthday, dept_id) VALUES
('EMP001', '染谷 将太', '1992-09-03', 'D004'),
('EMP002', '二階堂 ふみ', '1994-09-21', 'D002'),
('EMP003', '窪塚 洋介', '1979-05-07', 'D003'),
('EMP004', '吉高 由里子', '1988-07-22', 'D001'),
('EMP005', '渡辺 哲', '1950-03-11', 'D005');
-- ('EMP006', '前田 博喜', '1998-10-05', 'D006'); 



-- データの表示

SELECT * FROM emp;
SELECT * FROM dept;



-- 結合票の作成

SELECT id, name, birthday, dept_id, dname
FROM emp e
	INNER JOIN dept d
	ON e.dept_id = d.did
\g   -- ;の意味(目立たせたい時に使う)


-- VIEWがあったら消す
DROP VIEW IF EXISTS emp_v;



-- VIEWの作成

CREATE VIEW emp_v AS
SELECT id, name, birthday, dept_id, dname
FROM emp e
	INNER JOIN dept d
	ON e.dept_id = d.did
\g

-- SELECT * FROM emp_v;



-- 