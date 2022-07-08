package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.Emp;

public class EmpDAO {
	public List<Emp> findAll() {
		List<Emp> empList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(Const.JDBC_URL, Const.DB_USER, Const.DB_PASS)) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}
}
