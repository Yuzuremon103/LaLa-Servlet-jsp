package model;

public class NumLogic {
	public static boolean three(int number) {
		if(number <= 3) {   // 1,2,3
			return true;
		}
		return false;
	}
	
	public static boolean six(int number) {
		if(number >= 4 && number <=  6) {     // 4,5,6 
			return true;
		}
		return false;
	}

	public static boolean nine(int number) {
		if(number >= 7 && number <= 9) {    // 7,8,9
			return true;
		}
		return false;
	}
	
	public static boolean ten(int number) {
		if(number >= 10 && number <= 13) {    // 10,11,12,13
			return true;
		}
		return false;
	}

} 
