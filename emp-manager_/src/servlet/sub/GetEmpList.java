package servlet.sub;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetEmpListLogic;
import model.beans.Emp;

public class GetEmpList {
	public static void getList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		GetEmpListLogic logic = new GetEmpListLogic();
		List<Emp> empList = logic.execute();
		request.setAttribute("empList", empList);
		request.setAttribute("title", "社員一覧");
		String url = "/WEB-INF/jsp/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
