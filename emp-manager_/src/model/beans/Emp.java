package model.beans;

import java.io.Serializable;

public class Emp implements Serializable {
	private String id;
	private String name;
	private String birthday;
	private Dept dept; //外部キー（FOREIGN KEY）
	
	public Emp() {}
	public Emp(String id, String name, String birthday, Dept dept) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.dept = dept;
	}
	
	public String toString() {
		return id + ":" + name + ":" + birthday + ":" + dept.getDname();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
