package sakila.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import sakila.dao.StatsDao;
import sakila.vo.Stats;


/*
 * 방문자
 */
public class StatsService {
	public StatsDao statsDao;
	
	final String URL = "jdbc:mariadb://localhost:3306/sakila";
	final String USER = "root";
	final String PASSWORD = "java1004";
	
	private Stats getToday() { // 오늘 날짜 가져오기 메서드
		Calendar today = Calendar.getInstance(); // 오늘 날짜 가져오기
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd"); // 데이터 포멧 변경
		String day = dateformat.format(today.getTime()); // 오늘 날짜의 데이터 포멧을 바꿈
		Stats stats = new Stats();
		stats.setDay(day); // State의 데이터에 오늘 날짜 입력 
		return stats;
	}
	public long getTotalCount() { // 모든 카운트 가져오기
		statsDao = new StatsDao();
		long totalCount = 0; 
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			conn.setAutoCommit(false);
			
			totalCount = statsDao.selectTotalCount(conn);
			conn.commit();
			
		} catch(Exception e) { // 예외처리
			try {
				conn.rollback(); //
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				 conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalCount;
	}
	
	
	public Stats getStats() {
		statsDao = new StatsDao();
		Stats returnStats = null;
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			conn.setAutoCommit(false);
			
			Stats stats = new Stats();
			stats.setDay(this.getToday().getDay()); // getToday. 메서드 가져오기

			Stats todayStats = statsDao.selectDay(conn, stats); // 오늘 날짜의 인원 상태를 가져오기
			
			returnStats = statsDao.selectDay(conn, todayStats); // selectDay 데이터 가져오기
			conn.commit();
			
		} catch(Exception e) { // 예외처리
			try {
				conn.rollback(); //
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				 conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnStats;
	}
	
	public void countStats() {
		statsDao = new StatsDao();
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			conn.setAutoCommit(false);
			
			Stats stats = new Stats();
			stats.setDay(this.getToday().getDay());
			
			Stats todayStats = statsDao.selectDay(conn, stats);
			

			if(statsDao.selectDay(conn, stats) == null) { // selectDay값이 없다면 true
				statsDao.insertStats(conn, stats); // 첫 방문자면 오늘 날짜에 카운터 1 입력
			} else {
				statsDao.updateStats(conn, todayStats); // 오늘 방문자가 이미 있다면 기존 방문자 수에 +1을 함
			}
			conn.commit();
		} catch(Exception e) { // 예외처리
			try {
				conn.rollback(); // 롤백
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				 conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
