package com.management.pojo;
/*
* ʵ����
*��Ҫ�������ݿ�����ı�����Ӧ
* @author by LiF
* */
public class Student {
	
	private long id; //ѧ��
	private String name; //����
	private String sex; //�Ա�
	private String clazz; //�༶
	private long phone; //�绰
	private String  date;//��������

	public Student() {}
	/**
	 * ���캯��
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
	
	/** ������Getter��Setter���� **/
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
	 * ��дtoString,ʹ����ʾ����
	 */
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", clazz=" + clazz + ", phone=" + phone + ", date=" + date + "]";
	}
	
	
}
