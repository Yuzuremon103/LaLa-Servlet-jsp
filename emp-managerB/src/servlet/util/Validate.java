package servlet.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

import model.IsExistsIdLogic;
import model.beans.Emp;
import util.Const;
import util.Messages;

public class Validate {
	public static List<String> check(Emp emp, String mode) {
		List<String> errMsgList = new ArrayList<>();
		
		// id check
		if (isNull(emp.getId())) {
			errMsgList.add(Messages.ID_NULL_ERR);
		}
		else if (emp.getId().length() != Const.ID_LENGTH) {
			errMsgList.add(Messages.ID_LENGTH_ERR);
		}
		else if (! emp.getId().matches(Const.ID_PATTERN)) {
			errMsgList.add(Messages.ID_FORM_ERR);
		}
		else if (mode.equals("create") && isExistsId(emp.getId())) {
			errMsgList.add(Messages.ID_EXISTS_ERR);
		}
		
		// name check
		if (isNull(emp.getName())) {
			errMsgList.add(Messages.NAME_NULL_ERR);
		}
		else if (emp.getName().length() > Const.NAME_LENGTH) {
			errMsgList.add(Messages.NAME_LENGTH_ERR);
		}
		
		// birthday check
		if (! emp.getBirthday().matches("^[0-9]{4}/[0-9]{2}/[0-9]{2}$")) {
			errMsgList.add(Messages.BIRTHDAY_FORM_ERR);
		} else if (! isDate(emp.getBirthday())) {
			errMsgList.add(Messages.BIRTHDAY_WRONG_ERR);
		}
		
		// dept id check
		// 省略
		// データベースにそのidが存在していれば true
		return errMsgList;
	}
	
	/**
	 * ヌルであるか空文字であるか
	 * @param s 文字列
	 * @return true ヌル、もしくは空文字<br>
	 *         false ヌル・空文字ではない
	 */
	private static boolean isNull(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * IDが存在するかをチェック
	 * @param id 文字列
	 * @return true その ID はすでに使われている
	 *         false その ID は未使用である
	 */
	private static boolean isExistsId(String id) {
		IsExistsIdLogic logic = new IsExistsIdLogic();
		return logic.execute(id);
	}
	
	/**
	 * 日付の妥当性チェック
	 *https://qiita.com/i_learnin/items/0e90036b2d7f664a249d
	 * @param dateTxt　しらべたい日付
	 * @return　true その日付はただしい
				  false その日付は間違っている
	*/
	public static boolean isDate(String dateTxt) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("uuuu/MM/dd")
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate.parse(dateTxt, df);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Java7以前
	 * @param
	 * @return
	 * */
	public static boolean _isDate(String dateTxt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false); //厳格にチェックする
		try {
			sdf.parse(dateTxt);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
}
