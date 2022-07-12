package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.sub.GetEmpList;

@WebServlet(urlPatterns = {"/list"})
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();   // アクセスしてきたURLパターンを取得
		
		switch (path) {
			case "/list":
				GetEmpList.getList(request, response);
				break;
			default:
				response.sendRedirect(request.getContextPath() + "/notFound.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
