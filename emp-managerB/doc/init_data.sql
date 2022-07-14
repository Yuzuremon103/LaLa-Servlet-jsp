-- > mysql -u empdb_user -p
-- > empdb_user

-- �f�[�^�x�[�X�̍쐬

CREATE DATABASE IF NOT EXISTS emp_db;

-- �f�[�^�x�[�X�̎g�p�錾

USE emp_db;

DROP TABLE IF EXISTS emp;
DROP TABLE IF EXISTS dept;

-- dept�\�̒�`
CREATE TABLE dept (
  did CHAR(4) PRIMARY KEY,
  dname VARCHAR(20) NOT NULL
);

-- emp�\�̒�`
CREATE TABLE emp (
  id CHAR(6) PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  birthday DATE NOT NULL,
  dept_id CHAR(4) NOT NULL,
  CONSTRAINT fk_dept_id
  FOREIGN KEY (dept_id) REFERENCES dept (did)
);

-- �����f�[�^
INSERT INTO dept (did, dname) VALUES
('D001', '������'),
('D002', '�o����'),
('D003', '���c�ƕ�'),
('D004', '���c�ƕ�'),
('D005', '�J����'),
('D999', '-');

INSERT INTO emp (id, name, birthday, dept_id) VALUES
('EMP001', '���J �đ�', '1992-09-03', 'D004'),
('EMP002', '��K�� �ӂ�', '1994-09-21', 'D002'),
('EMP003', '�E�� �m��', '1979-05-07', 'D003'),
('EMP004', '�g�� �R���q', '1988-07-22', 'D001'),
('EMP005', '�n�� �N', '1950-03-11', 'D005');

-- �f�[�^�̕\��
SELECT * FROM dept;
SELECT * FROM emp;

-- �����\
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








