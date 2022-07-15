package model;

import dao.EmpDAO;
import model.beans.Emp;

public class CreateEmpLogic {
	public boolean execute(Emp emp) {
		EmpDAO dao = new EmpDAO();
		return dao.create(emp);
	}
}
