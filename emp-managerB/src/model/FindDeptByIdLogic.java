package model;

import dao.DeptDAO;
import model.beans.Dept;

public class FindDeptByIdLogic {
	public Dept execute(String did) {
		DeptDAO dao = new DeptDAO();
		Dept dept = dao.findById(did);
		return dept;
	}
}
