package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetEmployeeByIdLogic;

@WebServlet(urlPatterns = {"/input", "/update", "/delete"})
public class GetUrlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("title", "新規社員登録");
		request.setAttribute("goToUrl", "/inputConfirm");
		request.setAttribute("mode", "create");
		
		String url = "/WEB-INF/jsp/editEmp.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		GetEmployeeByIdLogic logic = new GetEmployeeByIdLogic();
		Employee emp = logic.execute(id);
		request.setAttribute("emp", emp);
		
		String path = request.getServletPath();  // 今どのURLパターンできたかを調べる
		String url = "";
		if(path.equals("/update")) { // 編集(えんぴつ)押したとき
			request.setAttribute("title", "社員情報更新");
			request.setAttribute("goToUrl", "/updateConfirm");
			request.setAttribute("mode", "update");
			url = "/WEB-INF/jsp/editEmp.jsp";
		} else if(path.equals("/delete")) {  // 削除(ゴミ箱)押したとき
			request.setAttribute("title", "社員情報削除");
			request.setAttribute("goToUrl", "/deleteDone");
			request.setAttribute("submitBtnLabel", "delete");
			url = "/WEB-INF/jsp/confirmEmp.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
