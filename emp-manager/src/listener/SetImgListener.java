package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import util.Const;

@WebListener
public class SetImgListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
		context.setAttribute("pencil_png", Const.IMG_PENCIL);
		context.setAttribute("trash_png", Const.IMG_TRASH);
		context.setAttribute("find_png", Const.IMG_FIND);
		context.setAttribute("check_png", Const.IMG_CHECK);
    }
	
}
