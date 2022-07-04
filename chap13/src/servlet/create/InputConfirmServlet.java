package servlet.create;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import util.GetParam;
import util.validate;

@WebServlet("/inputConfirm")
public class InputConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = GetParam.receive(request);
		System.out.println(emp);
		List<String> errMsgList = validate.check(emp, "create");
		String url = null;
		if(errMsgList.size() > 0) {
			request.setAttribute("errMsgList", errMsgList);
			request.setAttribute("title", "新規社員登録");
			request.setAttribute("goToUrl", "/inputConfirm");
			request.setAttribute("mode", "create");
			url = "/WEB-INF/jsp/editEmp.jsp";
		} else {
			request.setAttribute("title", "新規社員登録");
			request.setAttribute("goToUrl", "/inputRegister");
			request.setAttribute("submitBtnLabel", "登録");
			url = "/WEB-INF/jsp/confirmEmp.jsp";
		}
		request.setAttribute("emp", emp);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
