package model;

public class TextLogic {
	public static String textLogic(String lastChar, String text) {
		System.out.println("textLogic内のlastChar : " + lastChar);
		System.out.println("textLogic内のtext : " + text);
		String n = "ん";
		if(lastChar.equals("ん") || lastChar.equals("ー")) {
			lastChar = text.substring(text.length() - 2, text.length() - 1);
		}
		if(lastChar.equals("ぁ")) {
			lastChar = "あ";
		}
		if(lastChar.equals("ぃ")) {
			lastChar = "い";
		}
		if(lastChar.equals("ぅ")) {
			lastChar = "う";
		}
		if(lastChar.equals("ぇ")) {
			lastChar = "え";
		}
		if(lastChar.equals("ぉ")) {
			lastChar = "お";
		}
		if(lastChar.equals("っ")) {
			lastChar = "つ";
		}
		if(lastChar.equals("ゃ")) {
			lastChar = "や";
		}
		if(lastChar.equals("ゅ")) {
			lastChar = "ゆ";
		}
		if(lastChar.equals("ょ")) {
			lastChar = "よ";
		}
		if(lastChar.equals("ゎ")) {
			lastChar = "わ";
		}
		if(lastChar.equals("ゐ")) {
			lastChar = "い";
		}
		if(lastChar.equals("ゑ")) {
			lastChar = "え";
		}
		return lastChar;
	}
}
