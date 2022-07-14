package servlet.util;

import javax.servlet.http.HttpServletRequest;

import model.FindDeptByIdLogic;
import model.beans.Dept;
import model.beans.Emp;

public class GetParam {
	public static Emp receive(HttpServletRequest request) {
		String id = request.getParameter("id").toUpperCase();
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		System.out.println("birthday:" + birthday);
		String did = request.getParameter("did");
		Dept dept = getDept(did);
		Emp emp = new Emp(id, name, birthday, dept);
		return emp;
	}
	
	private static Dept getDept(String did) {
		FindDeptByIdLogic logic = new FindDeptByIdLogic();
		return logic.execute(did);
	}
}
