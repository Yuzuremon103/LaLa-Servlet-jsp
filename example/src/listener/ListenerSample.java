package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class ListenerSample implements ServletContextListener {

    public ListenerSample() {

    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("============リスナー終了=============");
    }
	
    
    public void contextInitialized(ServletContextEvent sce) {
    	ServletContext context = sce.getServletContext();
    	Integer count = 0;
    	context.setAttribute("count", count);
    	System.out.println("count" + count + "をセット");
    }
}
