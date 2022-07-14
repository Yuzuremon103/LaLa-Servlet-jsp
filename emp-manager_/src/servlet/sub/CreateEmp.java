package servlet.sub;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.util.GetParam;

public class CreateEmp {
	public static void input(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "新規社員登録");
		request.setAttribute("gotoUrl", "/createConfirm");
		String url = "/WEB-INF/jsp/editEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public static void confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// formからのパラメータを受け取る
		GetParam.receive(request);
		// バリケート
		// confirmEmp.jsp でユーザーに確認してもらう
	}
}
