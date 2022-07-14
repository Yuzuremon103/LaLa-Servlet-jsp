package test;

import servlet.util.Validate;

public class DateTest {

	public static void main(String[] args) {
		String dateTxt = "2030/02/02";
		if (Validate.isDate(dateTxt)) {
			System.out.println("正しい日付です");
		} else {
			System.out.println("間違った日付です");
		}
	}

}
