package sakila.query;

public class StatsQuery {
	public static final String INSERT_STATS = "INSERT INTO stats(day, cnt) VALUES(?,1)"; // ó�� �湮�� �Ͽ��� �� 
	public static final String UPDATE_STATS = "UPDATE stats SET cnt=cnt+1 WHERE day = ?"; // �湮 ī��Ʈ ���� ������
	public static final String SELCET_DAY = "SELECT * FROM stats WHERE day = ?"; // ��¥�� �ش�Ǵ� stats ������ ����
	public static final String TOTAL_COUNT = "SELECT sum(cnt) total_cnt FROM stats"; // ��� ī��Ʈ�� �� 
}
