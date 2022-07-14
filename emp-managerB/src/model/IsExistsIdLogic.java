package model;

import dao.EmpDAO;

/**
* idが存在するかどうかを調べる
* @param id
* @return true 存在する<br>
*         false 存在しない
*/
public class IsExistsIdLogic {
	public boolean execute(String id) {
		EmpDAO dao = new EmpDAO();
		return dao.isExistsId(id);
	}

}
