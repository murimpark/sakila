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
    	 System.out.println("contextInitialized() ����");
         try {
			Class.forName("org.mariadb.jdbc.Driver"); // Class.forName ����
			System.out.println("mariadb ����̺�ε� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName()���� ����");
			e.printStackTrace(); // ���� ���
		}    }
	
}
