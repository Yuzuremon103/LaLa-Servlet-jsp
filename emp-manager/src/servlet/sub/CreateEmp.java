package servlet.sub;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Emp;
import servlet.util.GetParam;
import servlet.util.Validate;

public class CreateEmp {
	public static void input(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "新規社員登録");
		request.setAttribute("gotoUrl", "/createConfirm");
		String url = "/WEB-INF/jsp/editEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public static void confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// formからのパラメータを受け取る
		Emp emp = GetParam.receive(request);
		List<String> errMsgList = Validate.check(emp, "create");
		
		request.setAttribute("emp", emp);
		request.setAttribute("title", "新規社員登録");
		String url = "";  // エラー時、nullが入っていないのでヌルポに飛ばされないことに注意
		
		if(errMsgList.size() > 0) {   // エラーがあればtrue
			request.setAttribute("errMsgList", errMsgList);
			request.setAttribute("gotoUrl", "/createComfirm");
			url = "/WEB-INF/jsp/editEmp.jsp";   // 打ち込み画面に戻す
			
		} else {
			request.setAttribute("submitBtnLabel", "登録");
			request.setAttribute("gotoUrl", "/createDone");
			url = "WEB-INF/jsp/comfirmEmp.jsp";  // 確認画面へ飛ばす
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
