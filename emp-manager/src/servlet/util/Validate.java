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
		
		// idのcheck
		if(isNull(emp.getId())) {
			errMsgList.add(Messages.ID_NULL_ERR);
		}
		else if(emp.getId().length() != Const.ID_LENGTH) {         // "create"
			errMsgList.add(Messages.ID_LENGTH_ERR);
		}
		else if(! emp.getId().matches(Const.ID_PATTERN)) {         // "update"
			errMsgList.add(Messages.ID_FORM_ERR);
		}
		else if (mode.equals("create") && isExistsId(emp.getId())) {   // ""
			errMsgList.add(Messages.ID_EXISTS_ERR);
		}
		
		
		// nameのcheck
		if(isNull(emp.getName())) {
			errMsgList.add(Messages.NAME_NULL_ERR);
		}
		else if (emp.getName().length() > Const.NAME_LENGTH) {
			errMsgList.add(Messages.NAME_LENGTH_ERR);
		}
		
		
		// birthdayのcheck
		if(! emp.getBirthday().matches("^[0-9{4}/[0-9]{2}/[0-9]{2}$]")) { 
			errMsgList.add(Messages.BIRTHDAY_FROM_ERR);
		} else if (! isDate(emp.getBirthday())) {
			errMsgList.add(Messages.BIRTHDAY_WRONG_ERR);
		}
		
		
		// deptIDのcheck
		// 省略
		// データベースにそのiDが存在していればtrue
		
		return errMsgList;
	}
	
	
	/**
	 * nullであるか空文字であるか 
	 * @param s 文字列
	 * @return true    null, もしくは空文字<br>
	 *          false   null,空文字ではない 
	 */
	private static boolean isNull(String s) {
		if(s == null || s.length() == 0) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * IDが存在するかをチェックする
	 * @param id 文字列
	 * @return true   その ID は既に使われている<br>
	 *          false  その ID は未使用である
	 */
	private static boolean isExistsId(String id) {
		IsExistsIdLogic logic = new IsExistsIdLogic();
		return logic.execute(id);
	}
	
	
	/**
	 * 日付の妥当性チェック (Java8以降) -- localDateを使用
	 * (参考) https://qiita.com/i_learnin/items/0e90036b2d7f664a249d
	 * @param dataTxt  -- 調べたい日付
	 * @return boolean -- true その日付は正しい
	 *                  -- false その日付は間違っている
	 */
	public static boolean isDate(String dataTxt) { 
		DateTimeFormatter df = DateTimeFormatter.ofPattern("uuuu/MM/dd")
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate.parse(dataTxt, df);
		} catch(DateTimeParseException e) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Java7以前
	 * Javaの歴史は長いので、7以前のも多い。故に両方作るべき。
	 * 
	 * @param datatxt
	 * @return
	 */
	public static boolean _isDate(String datatxt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);    // 厳格にチェックする(trueなら緩い)
		try {
			sdf.parse(datatxt);
			return true;
		} catch(ParseException e) {
			return false;
		}
	}
	
	
}
