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
		context.setAttribute("back", Const.IMG_BACK);
		context.setAttribute("one", Const.IMG_ONE);
		context.setAttribute("two", Const.IMG_TWO);
		context.setAttribute("three", Const.IMG_THREE);
		context.setAttribute("four", Const.IMG_FOUR);
		context.setAttribute("five", Const.IMG_FIVE);
		context.setAttribute("six", Const.IMG_SIX);
		context.setAttribute("seven", Const.IMG_SEVEN);
		context.setAttribute("eight", Const.IMG_EIGHT);
		context.setAttribute("nine", Const.IMG_NINE);
		context.setAttribute("ten", Const.IMG_TEN);
		context.setAttribute("eleven", Const.IMG_ELEVEN);
		context.setAttribute("twelve", Const.IMG_TWELVE);
		context.setAttribute("thirteen", Const.IMG_THIRTEEN);
		context.setAttribute("joker", Const.IMG_JOKER);
    }
	
}
