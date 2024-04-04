package com.demo.Demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="s_id")
   private int stud_id;
	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", stud_name=" + stud_name + ", stud_email=" + stud_email + "]";
	}
	@Column(name="name",length = 30,nullable = false)
   private String stud_name;
	@Column(name="email",length = 30,nullable= false)
   private String stud_email;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int stud_id, String stud_name, String stud_email) {
	super();
	this.stud_id = stud_id;
	this.stud_name = stud_name;
	this.stud_email = stud_email;
}
public int getStud_id() {
	return stud_id;
}
public void setStud_id(int stud_id) {
	this.stud_id = stud_id;
}
public String getStud_name() {
	return stud_name;
}
public void setStud_name(String stud_name) {
	this.stud_name = stud_name;
}
public String getStud_email() {
	return stud_email;
}
public void setStud_email(String stud_email) {
	this.stud_email = stud_email;
}

}
