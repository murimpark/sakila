package sakila.query;

public class StaffQuery {
	// 이메일과 패스워드 입력으로 이메일과 사용자 이름을 가져옴.
	public final static String SELECT_STAFF_BY_KEY = "SELECT email, username FROM staff WHERE email = ? AND password = PASSWORD(?)"; 
}
