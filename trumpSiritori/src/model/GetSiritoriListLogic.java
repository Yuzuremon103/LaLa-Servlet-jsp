package model;

import java.util.List;

import dao.EmpDAO;
import model.beans.Emp;

public class GetSiritoriListLogic {
	public List<> execute() {
		EmpDAO dao = new EmpDAO();
		List<Emp> empList = dao.findAll();
		return empList;
	}
}
