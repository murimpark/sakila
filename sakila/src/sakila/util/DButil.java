package sakila.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
	public Connection getConnection() throws Exception {
		
		final String URL = "jdbc:mariadb://localhost:3306/sakila";
		final String USER = "root";
		final String PASSWORD = "java1004";
		
		Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
		conn.setAutoCommit(false); // 트랜잭션이 처리 될 경우를 대비, 자동커밋 하지않음
		
		return conn;
	}
}
