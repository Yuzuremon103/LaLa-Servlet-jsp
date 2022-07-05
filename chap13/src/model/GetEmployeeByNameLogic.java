package model;

import java.util.List;

import dao.EmployeeDAO;

public class GetEmployeeByNameLogic {
	public List<Employee> execute(String name) {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> empList = dao.findByName(name);
		return empList;
	}
}
