package sakila.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
	public Connection getConnection() throws Exception {
		
		final String URL = "jdbc:mariadb://localhost:3306/sakila";
		final String USER = "root";
		final String PASSWORD = "java1004";
		
		Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
		conn.setAutoCommit(false); // 자동 커밋을 하지않고 try 문 끝에 수동으로 커밋을 넣음.
		
		return conn;
	}
}
