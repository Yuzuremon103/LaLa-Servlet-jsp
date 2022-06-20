package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ユーザーから送られてきたのは以下ですよ
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		System.out.println("GET : お名前:" + name + "パスワード" + pass);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ユーザーから送られてきたのは以下ですよ
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		
		System.out.println("POST : id:" + id + "お名前:" + name + "パスワード" + password);
		
		
		// 今からユーザーに返すのは以下ですよ
//		response.setContentType("text/html charset=UTF-8");
//		
//		PrintWriter out = response.getWriter();
//		out.println("<html><body><p>");
//		out.println("");
//		
	}

}
