package com.management.pojo;
/*
* 实体类
*主要是与数据库里面的表做对应
* @author by LiF
* */
public class Student {
	
	private long id; //学号
	private String name; //姓名
	private String sex; //性别
	private String clazz; //班级
	private long phone; //电话
	private String  date;//出生日期

	public Student() {}
	/**
	 * 构造函数
	 * @param id
	 * @param name
	 * @param sex
	 * @param clazz
	 * @param phone
	 * @param date
	 */
	public Student(long id, String name, String sex, String clazz, long phone, String date) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.clazz = clazz;
		this.phone = phone;
		this.date = date;
	}
	
	/** 下面是Getter和Setter方法 **/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	/**
	 * 改写toString,使得显示更好
	 */
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", clazz=" + clazz + ", phone=" + phone + ", date=" + date + "]";
	}
	
	
}
