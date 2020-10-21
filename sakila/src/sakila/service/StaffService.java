package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;

import sakila.dao.StaffDao;
import sakila.util.DButil;
import sakila.vo.Staff;

public class StaffService {
	private StaffDao staffDao;
	public Staff getStaffByKey(Staff staff) {
		staffDao = new StaffDao();
		Connection conn = null;
		DButil dbUtil = null;
		
		Staff returnStaff = null;
		try {
			dbUtil = new DButil();
			conn= dbUtil.getConnection();
			
			returnStaff = staffDao.selectStaffByKey(conn, returnStaff);
			conn.commit();
		} catch(Exception e) { // 예외처리
			try {
				conn.rollback(); //
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
		return returnStaff;
	}
}
