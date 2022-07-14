package test;

import java.util.List;

import model.GetEmpListLogic;
import model.beans.Emp;

public class Test1 {

	public static void main(String[] args) {
		GetEmpListLogic logic = new GetEmpListLogic();
		List<Emp> empList = logic.execute();
		
		for (Emp emp : empList) {
			System.out.println(emp);
		}
	}

}
