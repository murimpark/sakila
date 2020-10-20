package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;

@WebListener
public class StatsListener implements HttpSessionListener {
	//���� �̺�Ʈ
	private StatsService statsService;
	
    public StatsListener() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent se)  { 
        // ������ ���ο� �����Դϱ�? true, false
    	if(se.getSession().isNew()) {
        	 statsService = new StatsService();
        	 statsService.countStats(); 
        }
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
