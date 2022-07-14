package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.Dept;
import model.beans.Emp;

public class EmpDAO {
	private final String SQL_FIND_ALL = 
					"SELECT e.id AS id, e.name AS name, "
					+ " DATE_FORMAT(e.birthday, '%Y/%m/%d') AS birthday," 
					+ " e.dept_id AS dept_id, d.dname AS dname"
					+ "   FROM emp e"
					+ "     INNER JOIN dept d"
					+ "     ON e.dept_id = d.did"
					+ " ORDER BY e.id ASC";
	
	private final String SQL_IS_EXISTS_ID =
					"SELECT id FROM emp WHERE id = ?";

	public List<Emp> findAll() {
		List<Emp> empList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(
				Const.JDBC_URL, Const.DB_USER, Const.DB_PASS)) {
			System.out.println("Connected!");
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String did = rs.getString("dept_id");
				String dname = rs.getString("dname");
				Dept dept = new Dept(did, dname);
				Emp emp = new Emp(id, name, birthday, dept);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	
	/**
	 * idが存在するかどうかを調べる
	 * @param id
	 * @return true 存在する<br>
	 *         false 存在しない
	 */
	public boolean isExistsId(String id) {
		try (Connection conn = DriverManager.getConnection(
				Const.JDBC_URL, Const.DB_USER, Const.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_IS_EXISTS_ID);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
