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
@WebServlet({"/","/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private StatsService statsService;  
	private StaffService staffService; 
	
	//로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginStaff") != null) { // 이미 로그인을 했다면 인덱스 페이지로 보냄
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		statsService = new StatsService();
		Stats stats = statsService.getStats();
		long totalCount = statsService.getTotalCount();
		request.setAttribute("stats", stats); 
		request.setAttribute("totalCount", totalCount);
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	//로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		staffService = new StaffService();
		Staff staff = new Staff();
		staff.setEmail(request.getParameter("email"));
		staff.setPassword(request.getParameter("password"));
		
		Staff returnStaff = staffService.getStaffByKey(staff); //
		
		if(returnStaff != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginStaff", returnStaff); // 
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet"); 
		} else {
			response.sendRedirect(request.getContextPath()+"/LoginServlet");	
		}
	}

}
