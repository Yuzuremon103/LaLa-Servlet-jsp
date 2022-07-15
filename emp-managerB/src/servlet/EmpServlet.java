package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.sub.CreateEmp;
import servlet.sub.GetEmpList;

@WebServlet(urlPatterns = {"/list", "/create", "/createConfirm", "/fixInput", "createDone"})
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			             HttpServletResponse response) 
			            throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/list":
			GetEmpList.getList(request, response);
			break;
		case "/create":
			CreateEmp.input(request, response);
			break;
		default:
			response.sendRedirect(request.getContextPath() + "/404.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/createConfirm":
			CreateEmp.confirm(request, response);
			break;
		case "/fixInput":
			CreateEmp.fixInput(request, response);
			break;
		case "createDone":
			CreateEmp.createDone(request, response);
			break;
		default:
			response.sendRedirect(request.getContextPath() + "/404.html");
		}
	}

}
