package servlet.seach;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetEmployeeByNameLogic;

@WebServlet("/seach")
public class SeachEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("name : " + name);
		GetEmployeeByNameLogic getName = new GetEmployeeByNameLogic();
		List<Employee> empList = getName.execute(name);
		
		String url = "/WEB-INF/jsp/empList.jsp";
		String mode = "seach";
		request.setAttribute("empList", empList);
		request.setAttribute("mode", mode);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
