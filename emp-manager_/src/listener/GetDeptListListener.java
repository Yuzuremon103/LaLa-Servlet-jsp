package listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.GetDeptListLogic;
import model.beans.Dept;

@WebListener
public class GetDeptListListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         GetDeptListLogic logic = new GetDeptListLogic();
         List<Dept> deptList = logic.execute();
         ServletContext context = sce.getServletContext();
         context.setAttribute("deptList", deptList);
    }
	
}
