package com.tec.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class University {
	@Id
	private int id;

	private String department;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "uid",nullable = false)
	private List<Students> students;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "University [id=" + id + ", department=" + department + ", students=" + students + "]";
	}

	public University(int id, String department, List<Students> students) {
		super();
		this.id = id;
		this.department = department;
		this.students = students;
	}

	public University() {
		super();
		// TODO Auto-generated constructor stub
	}

}
