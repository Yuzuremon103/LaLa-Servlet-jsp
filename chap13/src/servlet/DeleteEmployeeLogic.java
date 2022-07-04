package servlet;

import dao.EmployeeDAO;
import model.Employee;
import model.interf.EmployeeLogic;

public class DeleteEmployeeLogic implements EmployeeLogic {
	public boolean execute(Employee emp) {
		 EmployeeDAO dao = new EmployeeDAO();
		 return dao.remove(emp.getId());
	}
}
