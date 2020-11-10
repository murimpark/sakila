package sakila.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import sakila.dao.StatsDao;
import sakila.util.DButil;
import sakila.vo.Stats;

public class StatsService {
	public StatsDao statsDao;
	
	private Stats getToday() { 
		Calendar today = Calendar.getInstance(); 
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd"); 
		String day = dateformat.format(today.getTime()); 
		Stats stats = new Stats();
		stats.setDay(day); 
		return stats;
	}
	public long getTotalCount() { 
		statsDao = new StatsDao();
		Connection conn = null;
		DButil dbUtil = null;
		
		long totalCount = 0; 
		
		try {
			dbUtil = new DButil();
			conn = dbUtil.getConnection();
			
			totalCount = statsDao.selectTotalCount(conn);
			conn.commit();
			
		} catch(Exception e) { 
			try {
				conn.rollback(); 
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
		Connection conn = null;
		DButil dbUtil = null;
		
		Stats returnStats = null;
		
		try {
			dbUtil = new DButil();
			conn = dbUtil.getConnection();
			
			Stats stats = new Stats();
			stats.setDay(this.getToday().getDay()); // getToday.

			returnStats = statsDao.selectDay(conn, stats); // selectDay
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
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
		DButil dbUtil = null;
		
		try {
			dbUtil = new DButil();
			conn = dbUtil.getConnection();
			
			Stats stats = new Stats();
			stats.setDay(this.getToday().getDay());
			
			Stats todayStats = statsDao.selectDay(conn, stats);
			
			if(statsDao.selectDay(conn, stats) == null) { 
				statsDao.insertStats(conn, stats); //
			} else {
				statsDao.updateStats(conn, todayStats); 
			}
			conn.commit();
		} catch(Exception e) { 
			try {
				conn.rollback(); 
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
