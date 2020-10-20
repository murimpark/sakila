package sakila.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	 System.out.println("contextInitialized() 실행");
         try {
			Class.forName("org.mariadb.jdbc.Driver"); // Class.forName 실행
			System.out.println("mariadb 드라이브로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName()실행 실패");
			e.printStackTrace(); // 오류 출력
		}    }
	
}
