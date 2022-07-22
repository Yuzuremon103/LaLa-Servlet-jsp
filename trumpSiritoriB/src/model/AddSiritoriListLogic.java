package model;

import java.util.List;

public class AddSiritoriListLogic {
	public boolean execute(Siritori siritori, List<Siritori> SiritoriList) {
		return SiritoriList.add(siritori);
	}
}
