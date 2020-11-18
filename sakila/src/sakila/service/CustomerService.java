package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import sakila.dao.CustomerDao;
import sakila.util.DButil;
import sakila.vo.Customer;

public class CustomerService {
	private CustomerDao customerDao;
	public List<Customer> getCustomerByPage(int currentPage, int rowPerPage) {
		List<Customer> list = null;
		customerDao  = new CustomerDao();
		Connection conn = null;
		DButil dbUtil = null;
		
		try {
			int beginRow = (currentPage-1)*rowPerPage;
			dbUtil = new DButil();
			conn = dbUtil.getConnection();
			
			list = customerDao.selectCustomerByPage(conn, beginRow, rowPerPage);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
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
		
		
		return list;
	}
}
