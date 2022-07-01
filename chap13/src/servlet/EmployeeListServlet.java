package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetEmployeeListLogic;

@WebServlet("/list")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetEmployeeListLogic logic = new GetEmployeeListLogic();
		List<Employee> empList = logic.execute();
		request.setAttribute("empList", empList);
		
//		request.setAttribute("pencil_png", Const.IMG_PENCIL);
//		request.setAttribute("trash_png", Const.IMG_TRASH);
		
		
		String url = "/WEB-INF/jsp/empList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		// request.getRequestDispatcher(url).forward(request, response);
	}
}
