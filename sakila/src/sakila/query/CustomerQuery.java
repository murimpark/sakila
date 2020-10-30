package sakila.query;

public class CustomerQuery {
	// 고객의 아이디와 이름, 핸드폰번호, 활성화여부를 페이지에 출력 
	public static final String SELECT_CUSTOMER_BY_PAGE = "SELECT c.customer_id, CONCAT(first_name,' ',Last_name) my_name, a.phone, c.active FROM customer c INNER JOIN address a ON c.address_id = a.address_id LIMIT ?, ?"; 
	
	// 고객의 상세 정보 출력
	public static final String SELECT_CUSTOMER_DETAIL = "SELECT c.store_id, CONCAT(first_name,' ',Last_name) my_name, a.phone, CONCAT(a.address,', ',ci.city,', ',co.country) my_address, c.email FROM customer c INNER JOIN address a ON c.address_id = a.address_id INNER JOIN city ci ON a.city_id=ci.city_id INNER JOIN country co ON ci.country_id=co.country_id WHERE c.customer_id = ?";
	
}
