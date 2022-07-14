package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.Dept;

public class DeptDAO {
	
	// SQL文をフィールドとして入れる。
	// ほかのクラスから取得することはないのでprivateにする。
	private final String SQL_FIND_ALL = 
			"SELECT did, dname FROM dept"
			+ " ORDER BY did ASC";
	
	private final String SQL_FIND_BY_ID = 
			"SELECT did, dname FROM dept"
			+ " WHERE did = ?";

	public List<Dept> findAll() { // データを全て一覧する
		List<Dept> deptList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(Const.JDBC_URL, Const.DB_USER, Const.DB_PASS)) {
			System.out.println("Connected!");
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String did = rs.getString("did");
				String dname = rs.getString("dname");
				Dept dept = new Dept(did, dname);
				deptList.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return deptList;
	}
	
	public Dept findById(String _did) {
		Dept dept = null;
		try (Connection conn = DriverManager.getConnection(Const.JDBC_URL, Const.DB_USER, Const.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_ID);
			pStmt.setString(1, _did);
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				String did = rs.getString("id");
				String dname = rs.getString("dname");
				dept = new Dept(did, dname);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return dept;
	}
}
