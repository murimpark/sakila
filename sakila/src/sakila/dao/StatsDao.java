package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	
	public Stats selectDay(Connection conn, Stats stats) throws Exception {
		Stats returnStats = null;
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELCET_DAY);
		stmt.setString(1, stats.getDay());
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day"));
			returnStats.setCount(rs.getLong("cnt"));
		}
		return returnStats;
	}
	
	public long selectTotalCount(Connection conn) throws Exception {
		long totalCount = 0;
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.TOTAL_COUNT);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			totalCount = rs.getLong("total_cnt");
		}
		
		return totalCount;
	}
		
	// 첫 접속 인원 카운팅
	public void insertStats(Connection conn, Stats stats) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS);
		stmt.setString(1, stats.getDay());
		stmt.executeUpdate();
	}
	
	// 인원 카운팅 증가
	public void updateStats(Connection conn, Stats stats) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		stmt.setString(1, stats.getDay());
		stmt.executeUpdate();
	}
	
}
