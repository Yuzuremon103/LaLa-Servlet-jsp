package model;

public class TextLogic {
	public static String textLogic(String lastChar, String text) {
		System.out.println("textLogic内のlastChar : " + lastChar);
		System.out.println("textLogic内のtext : " + text);
		if(lastChar.equals("ん") || lastChar.equals("ー") || lastChar.equals("ン")) {
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
		if(lastChar.equals("ア")) {
			lastChar = "あ";
		}
		if(lastChar.equals("ァ")) {
			lastChar = "あ";
		}
		if(lastChar.equals("イ")) {
			lastChar = "い";
		}
		if(lastChar.equals("ィ")) {
			lastChar = "い";
		}
		if(lastChar.equals("ウ")) {
			lastChar = "う";
		}
		if(lastChar.equals("ゥ")) {
			lastChar = "う";
		}
		if(lastChar.equals("エ")) {
			lastChar = "え";
		}
		if(lastChar.equals("ェ")) {
			lastChar = "え";
		}
		if(lastChar.equals("オ")) {
			lastChar = "お";
		}
		if(lastChar.equals("ォ")) {
			lastChar = "お";
		}
		if(lastChar.equals("カ")) {
			lastChar = "か";
		}
		if(lastChar.equals("ガ")) {
			lastChar = "が";
		}
		if(lastChar.equals("キ")) {
			lastChar = "き";
		}
		if(lastChar.equals("ギ")) {
			lastChar = "ぎ";
		}
		if(lastChar.equals("ク")) {
			lastChar = "く";
		}
		if(lastChar.equals("グ")) {
			lastChar = "ぐ";
		}
		if(lastChar.equals("ケ")) {
			lastChar = "け";
		}
		if(lastChar.equals("ゲ")) {
			lastChar = "げ";
		}
		if(lastChar.equals("コ")) {
			lastChar = "こ";
		}
		if(lastChar.equals("ゴ")) {
			lastChar = "ご";
		}
		if(lastChar.equals("サ")) {
			lastChar = "さ";
		}
		if(lastChar.equals("ザ")) {
			lastChar = "ざ";
		}
		if(lastChar.equals("シ")) {
			lastChar = "し";
		}
		if(lastChar.equals("ジ")) {
			lastChar = "じ";
		}
		if(lastChar.equals("ス")) {
			lastChar = "す";
		}
		if(lastChar.equals("ズ")) {
			lastChar = "ず";
		}
		if(lastChar.equals("セ")) {
			lastChar = "せ";
		}
		if(lastChar.equals("ゼ")) {
			lastChar = "ぜ";
		}
		if(lastChar.equals("ソ")) {
			lastChar = "そ";
		}
		if(lastChar.equals("ゾ")) {
			lastChar = "ぞ";
		}
		if(lastChar.equals("タ")) {
			lastChar = "た";
		}
		if(lastChar.equals("チ")) {
			lastChar = "ち";
		}
		if(lastChar.equals("ツ")) {
			lastChar = "つ";
		}
		if(lastChar.equals("テ")) {
			lastChar = "て";
		}
		if(lastChar.equals("ト")) {
			lastChar = "と";
		}
		if(lastChar.equals("ダ")) {
			lastChar = "だ";
		}
		if(lastChar.equals("ヂ")) {
			lastChar = "ぢ";
		}
		if(lastChar.equals("ヅ")) {
			lastChar = "づ";
		}
		if(lastChar.equals("デ")) {
			lastChar = "で";
		}
		if(lastChar.equals("ド")) {
			lastChar = "ど";
		}
		if(lastChar.equals("ッ")) {
			lastChar = "つ";
		}
		if(lastChar.equals("ナ")) {
			lastChar = "な";
		}
		if(lastChar.equals("ニ")) {
			lastChar = "に";
		}
		if(lastChar.equals("ヌ")) {
			lastChar = "ぬ";
		}
		if(lastChar.equals("ネ")) {
			lastChar = "ね";
		}
		if(lastChar.equals("ノ")) {
			lastChar = "の";
		}
		if(lastChar.equals("ハ")) {
			lastChar = "は";
		}
		if(lastChar.equals("ヒ")) {
			lastChar = "ひ";
		}
		if(lastChar.equals("フ")) {
			lastChar = "ふ";
		}
		if(lastChar.equals("ヘ")) {
			lastChar = "へ";
		}
		if(lastChar.equals("ホ")) {
			lastChar = "ほ";
		}
		if(lastChar.equals("バ")) {
			lastChar = "ば";
		}
		if(lastChar.equals("ビ")) {
			lastChar = "び";
		}
		if(lastChar.equals("ブ")) {
			lastChar = "ぶ";
		}
		if(lastChar.equals("ベ")) {
			lastChar = "べ";
		}
		if(lastChar.equals("ボ")) {
			lastChar = "ぼ";
		}
		if(lastChar.equals("パ")) {
			lastChar = "ぱ";
		}
		if(lastChar.equals("ピ")) {
			lastChar = "ぴ";
		}
		if(lastChar.equals("プ")) {
			lastChar = "ぷ";
		}
		if(lastChar.equals("ペ")) {
			lastChar = "ぺ";
		}
		if(lastChar.equals("ポ")) {
			lastChar = "ぽ";
		}
		if(lastChar.equals("マ")) {
			lastChar = "ま";
		}
		if(lastChar.equals("ミ")) {
			lastChar = "み";
		}
		if(lastChar.equals("ム")) {
			lastChar = "む";
		}
		if(lastChar.equals("メ")) {
			lastChar = "め";
		}
		if(lastChar.equals("モ")) {
			lastChar = "も";
		}
		if(lastChar.equals("ヤ")) {
			lastChar = "や";
		}
		if(lastChar.equals("ユ")) {
			lastChar = "ゆ";
		}
		if(lastChar.equals("ヨ")) {
			lastChar = "よ";
		}
		if(lastChar.equals("ャ")) {
			lastChar = "や";
		}
		if(lastChar.equals("ュ")) {
			lastChar = "ゆ";
		}
		if(lastChar.equals("ョ")) {
			lastChar = "よ";
		}
		if(lastChar.equals("ラ")) {
			lastChar = "ら";
		}
		if(lastChar.equals("リ")) {
			lastChar = "り";
		}
		if(lastChar.equals("ル")) {
			lastChar = "る";
		}
		if(lastChar.equals("レ")) {
			lastChar = "れ";
		}
		if(lastChar.equals("ロ")) {
			lastChar = "ろ";
		}
		if(lastChar.equals("ワ")) {
			lastChar = "わ";
		}
		if(lastChar.equals("ヮ")) {
			lastChar = "わ";
		}
		if(lastChar.equals("ヲ")) {
			lastChar = "を";
		}
		if(lastChar.equals("ヰ")) {
			lastChar = "い";
		}
		if(lastChar.equals("ヱ")) {
			lastChar = "え";
		}
		return lastChar;
	}
}
