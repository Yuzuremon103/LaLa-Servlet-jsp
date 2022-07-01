package test2;

import model.CreateEmpLogic;
import model.Employee;

public class CreateEmpTest {

	public static void main(String[] args) {
		Employee emp = new Employee("EMP005", "木下藤吉郎", 23);
		CreateEmpLogic logic = new CreateEmpLogic();
		if(logic.execute(emp)) {
			System.out.println("登録しました");
		} else {
			System.out.println("失敗しました");
		}
	}

}
