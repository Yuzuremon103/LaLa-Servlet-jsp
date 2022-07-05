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
import util.GetParam;

@WebServlet(urlPatterns = {"/input", "/update", "/delete", "/fix_input", "/fix_update"})
public class GetUrlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setReq(request);
		String url = "/WEB-INF/jsp/editEmp.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
	private void setReq(HttpServletRequest request) {
		request.setAttribute("title", "新規社員登録");
		request.setAttribute("goToUrl", "/inputConfirm");
		request.setAttribute("mode", "create");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = null;
		String path = request.getServletPath();  // 今どのURLパターンできたかを調べる
		if(path.equals("/fix_input") || path.equals("/fix_update")) {
			emp = GetParam.receive(request);
		} else {
			String id = request.getParameter("id");
			GetEmployeeByIdLogic logic = new GetEmployeeByIdLogic();
			emp = logic.execute(id);
		}
		
		
		request.setAttribute("emp", emp);
		
		String url = "";
		if(path.equals("/update") || path.equals("/fix_update")) { // 編集(えんぴつ)押したとき
			request.setAttribute("title", "社員情報更新");
			request.setAttribute("goToUrl", "/updateConfirm");
			request.setAttribute("mode", "update");
			url = "/WEB-INF/jsp/editEmp.jsp";
		} else if(path.equals("/delete")) {  // 削除(ゴミ箱)押したとき
			request.setAttribute("title", "社員情報削除");
			request.setAttribute("goToUrl", "/deleteDone");
			request.setAttribute("submitBtnLabel", "delete");
			request.setAttribute("mode", "delete");
			url = "/WEB-INF/jsp/confirmEmp.jsp";
		} else if(path.equals("/fix_input")) {
			setReq(request);
			url = "/WEB-INF/jsp/editEmp.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
