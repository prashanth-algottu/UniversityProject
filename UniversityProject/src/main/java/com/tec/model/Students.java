package com.tec.model;

import java.time.LocalDate;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Students 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int marks;
	private int age;
	private Date joiningdate;
	private Date passoutdate;
	private int credits;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getJoiningdate() {
		return joiningdate;
	}
	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}
	public Date getPassoutdate() {
		return passoutdate;
	}
	public void setPassoutdate(Date passoutdate) {
		this.passoutdate = passoutdate;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", marks=" + marks + ", age=" + age + ", joiningdate="
				+ joiningdate + ", passoutdate=" + passoutdate + ", credits=" + credits + "]";
	}
	public Students(int id, String name, int marks, int age, Date joiningdate, Date passoutdate,
			int credits) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.age = age;
		this.joiningdate = joiningdate;
		this.passoutdate = passoutdate;
		this.credits = credits;
	}
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	

	
	

}
