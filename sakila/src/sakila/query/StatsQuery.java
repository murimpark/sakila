package sakila.query;

public class StatsQuery {
	public static final String INSERT_STATS = "INSERT INTO stats(day, cnt) VALUES(?,1)"; // 처음 방문을 하였을 때 
	public static final String UPDATE_STATS = "UPDATE stats SET cnt=cnt+1 WHERE day = ?"; // 방문 카운트 증가 쿼리문
	public static final String SELCET_DAY = "SELECT * FROM stats WHERE day = ?"; // 날짜에 해당되는 stats 데이터 보기
	public static final String TOTAL_COUNT = "SELECT sum(cnt) total_cnt FROM stats"; // 모든 카운트의 합 
}
