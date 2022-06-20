package ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/testenq")
public class Execise2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String qtype = request.getParameter("qtype");
		String body = request.getParameter("body");
		
		System.out.println("名前:" + name);
		System.out.println("タイプ:" + qtype);
		System.out.println( "内容:" + body);
		
		
		// フォワード処理
		String url = "/WEB-INF/jsp/sample.jsp";  // urlはプロジェクト名を省略し、WebContent直下から書く
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
		
//		request.getRequestDispatcher(url).forward(request,response);
	}

}
