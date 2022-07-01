package servlet.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CreateEmpLogic;
import model.Employee;
import util.GetParam;

@WebServlet("/inputRegister")
public class InputRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// id, name, age を受け取る
		Employee emp = GetParam.receive(request);
		CreateEmpLogic logic = new CreateEmpLogic();
		String msg = "";
		if (logic.execute(emp)) {
			msg = "登録しました";
		} else {
			msg = "登録に失敗しました";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("title", "社員登録");
		
		String url = "/WEB-INF/jsp/workDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
