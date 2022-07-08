package test;

import java.util.List;

import dao.EmpDAO;
import model.beans.Emp;

public class Test1 {

	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		List<Emp> empList = dao.findAll();
	}

}
