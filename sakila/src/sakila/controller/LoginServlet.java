package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StaffService;
import sakila.service.StatsService;
import sakila.vo.Staff;
import sakila.vo.Stats;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private StatsService statsService; // 방문자 카운트 서비스 
	private StaffService staffService; // 관리자 로그인 서비스
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		statsService = new StatsService(); // 방문자 서비스 객체 생성
		Stats stats = statsService.getStats();
		long totalCount = statsService.getTotalCount();
		request.setAttribute("stats", stats); 
		request.setAttribute("totalCount", totalCount);
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		staffService = new StaffService();
		Staff staff = new Staff();
		staff.setStaffId(Integer.parseInt(request.getParameter("staffId")));
		staff.setPassword(request.getParameter("password"));
		
		Staff returnStaff = staffService.getStaffByKey(staff);
		if(returnStaff != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginStaff", returnStaff); // 리턴스태프를 로그인 스태프란 이름으로 옮김
			request.getRequestDispatcher("/IndexServlet").forward(request, response); // IndexServlet으로 포워딩
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet"); // IndexServlet으로 페이지 전환
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/LoginServlet");	
		}
	}

}
