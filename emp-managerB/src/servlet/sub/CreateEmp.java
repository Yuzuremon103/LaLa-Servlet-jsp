package servlet.sub;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CreateEmpLogic;
import model.beans.Emp;
import servlet.util.GetParam;
import servlet.util.Validate;

public class CreateEmp {
	public static void input(HttpServletRequest request,
			                 HttpServletResponse response) 
			            throws ServletException, IOException {
		request.setAttribute("title", "新規社員登録");
		request.setAttribute("gotoUrl", "/createConfirm");
		String url = "/WEB-INF/jsp/editEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	public static void confirm(HttpServletRequest request,
            HttpServletResponse response) 
            		throws ServletException, IOException {
			// formからのパラメータを受け取る
			Emp emp = GetParam.receive(request);
			List<String> errMsgList = Validate.check(emp, "create");
			
			request.setAttribute("emp", emp);
			request.setAttribute("title", "新規社員登録");

			String url = null;
			if (errMsgList.size() > 0) {
				request.setAttribute("errMsgList",errMsgList);
				request.setAttribute("gotoUrl","/createConfirm");


				url = "/WEB-INF/jsp/editEmp.jsp";
			} else {
				request.setAttribute("submitBtnLabel","登録");
				request.setAttribute("gotoUrl","/createDone");
				request.setAttribute("fix_link", "/fixInput");

				url = "/WEB-INF/jsp/confirmEmp.jsp";

			}
			request.getRequestDispatcher(url).forward(request,response);
			
	}
	
	
	public static void fixInput(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// formからのパラメータを受け取る
		Emp emp = GetParam.receive(request);
		request.setAttribute("emp", emp);
		request.setAttribute("title", "新規社員登録");
		request.setAttribute("gotoUrl", "/createConfirm");
		String url = "/WEB-INF/jsp/editEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	
	
	public static void createDone (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// formからのパラメータを受け取る
		Emp emp = GetParam.receive(request);
		CreateEmpLogic logic = new CreateEmpLogic();
		String msg = "";
		
		if(logic.execute(emp)) {
			// 登録成功
			msg = "登録しました";
			
		} else {
			// 登録失敗
			msg = "失敗しました";
			
		}
		request.setAttribute("msg", msg);
		request.setAttribute("title", "新規社員登録");
		String url = "/WEB-INF/jsp/workDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

} 