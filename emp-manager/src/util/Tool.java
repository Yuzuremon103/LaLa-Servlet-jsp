package util;

public class Tool {
	public static int myParseInt(String s) {
		int ans = 0;
		try {
			ans = Integer.parseInt(s);
		} catch (NumberFormatException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			ans = 0;
		}
		return ans;
	}
}
