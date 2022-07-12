package model;

import java.util.List;

import dao.EmpDAO;
import model.beans.Emp;

public class GetEmpListLogic {
	public List<Emp> execute() {
		EmpDAO dao = new EmpDAO();
		List<Emp> empList = dao.findAll();
		return empList;
	}
}
