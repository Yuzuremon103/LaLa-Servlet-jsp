package model;

import dao.EmployeeDAO;

/**
 * idが存在したら true さもなくば false
 * @author user
 *
 */
public class IsExistsIdLogic {
	public boolean execute(String id) {
		EmployeeDAO dao = new EmployeeDAO();
		return dao.isExistsId(id);
	}
}
