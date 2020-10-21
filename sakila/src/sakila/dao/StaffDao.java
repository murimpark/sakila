package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	// staff���̵�� ��й�ȣ�� Ȯ���ؼ� staffId�� username�� �ѱ�
	public Staff selectStaffByKey(Connection conn, Staff staff) throws Exception {
		Staff returnStaff = null;
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		stmt.setInt(1, staff.getStaffId());
		stmt.setString(2, "PASSWORD("+staff.getPassword()+")"); // PASSWORD()���·� ������
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setStaffId(rs.getInt("staffId"));
			returnStaff.setUsername(rs.getString("username"));
		}
		return returnStaff;
	}
}
