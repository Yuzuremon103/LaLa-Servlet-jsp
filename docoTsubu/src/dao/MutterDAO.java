package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	// データベース接続に使用する情報
	// クラス変数(フィールド) -- すべてのメソッドから参照できる
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/docoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	
	public List<Mutter> findAll() {
		List<Mutter> mutterList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// SQL文(SELECT文)の準備
			String sql = "SELECT id, name, text FROM mutter ORDER BY id DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SELECT文を実行
			ResultSet rs = pStmt.executeQuery(); 
			
			// SELECT文の結果をArrayListに格納
			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("name");
				String text = rs.getString("text");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return mutterList;
	}
	
	public boolean create(Mutter mutter) {
		
		// データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// INSERT文の準備(idは自動連番なので指定しなくてよい)
			String sql = "INSERT INTO mutter(name, text) VALUES (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setString(1, mutter.getUserName()); // 1つ目の？に代入
			pStmt.setString(2, mutter.getText());  // 2つ目の？に代入
			
			// INSERT文を実行(resultには追加された行数が代入される)
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
