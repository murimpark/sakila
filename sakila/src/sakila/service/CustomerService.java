package sakila.service;

import java.sql.Connection;
import java.util.List;

import sakila.dao.CustomerDao;
import sakila.vo.Customer;

public class CustomerService {
	private CustomerDao customerDao;
	public List<Customer> getCustomerByPage(int currentPage, int rowPerPage) {
		List<Customer> list = null;
		Connection conn = null;
		
		
		return null;
	}
}
