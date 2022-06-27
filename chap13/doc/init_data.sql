-- 初期データ

DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
	id CHAR(6) PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	age int NOT NULL
);


-- データ

INSERT INTO employee (id, name, age) VALUES
('EMP001', '湊 雄輔', 23),
('EMP002', '綾部 みゆき', 22);