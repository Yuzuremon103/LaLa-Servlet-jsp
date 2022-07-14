package model;

import java.util.List;

import dao.DeptDAO;
import model.beans.Dept;

public class GetDeptListLogic {
	public List<Dept> execute() {
		DeptDAO dao = new DeptDAO();
		List<Dept> deptList = dao.findAll();
		return deptList;
	}
}
