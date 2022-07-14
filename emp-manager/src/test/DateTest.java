package test;

import servlet.util.Validate;

public class DateTest {

	public static void main(String[] args) {
		String datetxt = "2022/02/29";
		
		if(Validate.isDate(datetxt)) {
			System.out.println("正しい日付です");
		} else {
			System.out.println("間違った日付です");
		}

	}

}
