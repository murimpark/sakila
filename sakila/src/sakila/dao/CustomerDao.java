package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.query.CustomerQuery;
import sakila.vo.Customer;

public class CustomerDao {
	public List<Customer> selectCustomerByPage(Connection conn, final int BEGIN_ROW, final int ROW_PER_PAGE) throws Exception {
		List<Customer> list = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement(CustomerQuery.SELECT_CUSTOMER_BY_PAGE);
		stmt.setInt(1, BEGIN_ROW);
		stmt.setInt(2, ROW_PER_PAGE);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Customer c = new Customer();
			c.setCustomerId(rs.getInt("customer_id"));
			c.setMyName(rs.getString("my_name"));
			c.setActive(rs.getInt("active"));
			list.add(c);
		}
		rs.close();
		stmt.close();

		return list;
	}
}
 