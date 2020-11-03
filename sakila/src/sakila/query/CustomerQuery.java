package sakila.query;

public class CustomerQuery {
	// 고객의 아이디와 이름,  활성화여부를 페이지에 출력 
	public static final String SELECT_CUSTOMER_BY_PAGE = "SELECT customer_id, CONCAT(first_name,' ',Last_name) my_name, active FROM customer LIMIT ?,?"; 
	
	// 고객의 상세 정보 출력
	public static final String SELECT_CUSTOMER_DETAIL = "SELECT store_id, CONCAT(first_name,' ',Last_name) my_name, email FROM customer WHERE customer_id = ?";
	
}
