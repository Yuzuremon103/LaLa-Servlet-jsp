package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		
		// データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// SELECT文を準備
			String sql = "SELECT id, name, age FROM employee";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表に格納されたレコードの内容を
			// Employeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	
	public boolean remove(String id) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "delete from employee where id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**
	 * IDが存在するかどうかを調べる
	 * @param id
	 * @return true  存在する<br>
	 *          false 存在しない
	 */ 
	public boolean isExistsId(String id) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id FROM employee WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
//			return false;
		}
		return false;
	}
	
	
	public boolean create(Employee emp) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO employee (id, name, age) VALUES (?, ?, ?)"; // SQLインジェクション
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, emp.getId());
			pStmt.setString(2, emp.getName());
			pStmt.setInt(3, emp.getAge());
			int result = pStmt.executeUpdate();  // 命令文を実行し、resultに格納する
			if(result != 1) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public Employee findById(String _id) {
		Employee emp = null;
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id, name, age FROM employee WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, _id);
			ResultSet rs = pStmt.executeQuery();  // 検索なのでQuery()の方。ResultSetも一緒に覚える
			if(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				emp = new Employee(id, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;   // データを何も取得できませんでした。
		}
		return emp;
	}
	
	public boolean update(Employee emp) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE employee SET name = ?, age = ? WHERE id = ?"; // SQLインジェクション
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, emp.getName());
			pStmt.setInt(2, emp.getAge());
			pStmt.setString(3, emp.getId());
			int result = pStmt.executeUpdate();  // 命令文を実行し、resultに格納する
			if(result != 1) {  // 変更点は1件のみなので1でなければfalse
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
