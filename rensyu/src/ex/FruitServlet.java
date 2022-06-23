package ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FruitServlet")
public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fruit fruit = new Fruit("いちご", 700);
		ServletContext application = this.getServletContext();
		application.setAttribute("fruit", fruit);

		
//		HttpSession session = request.getSession();
//		session.setAttribute("fruit", fruit);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ex/fruit.jsp");
		dispatcher.forward(request, response);
		
//		request.setAttribute("fruit", fruit);
//		
//		String url = "WEB-INF/ex/fruit.jsp";
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		dispatcher.forward(request, response);
	}
}
