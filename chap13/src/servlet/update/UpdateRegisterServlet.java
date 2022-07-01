package servlet.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.UpdateEmployeeLogic;
import util.GetParam;

@WebServlet("/updateRegister")
public class UpdateRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// id, name, age を受け取る
		Employee emp = GetParam.receive(request);
		UpdateEmployeeLogic logic = new UpdateEmployeeLogic();
		String msg = "";
		if (logic.execute(emp)) {
			msg = "更新しました";
		} else {
			msg = "更新に失敗しました";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("title", "社員更新");
		
		String url = "/WEB-INF/jsp/workDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
