package model;

public class RegisterUserLogic {
	public boolean execute(User user) {
		// 登録処理(サンプルでは登録処理を行わない)
		int num = (int) (Math.random() * 10) + 1;
		if(num % 3 == 0) {
			return false;
		}
 		return true;
	}
}
