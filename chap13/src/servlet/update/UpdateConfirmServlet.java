package servlet.update;

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

@WebServlet("/updateConfirm")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = GetParam.receive(request);
		System.out.println(emp);
		List<String> errMsgList = validate.check(emp, "update");
		String url = null;
		if(errMsgList.size() > 0) {
			request.setAttribute("errMsgList", errMsgList);
			url = "/WEB-INF/jsp/update/updateEmp.jsp";
		} else {
			url = "/WEB-INF/jsp/update/updateConfirm.jsp";
		}
		request.setAttribute("emp", emp);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
