package com.tec.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import com.tec.model.Students;
import com.tec.model.University;

public interface USeriveInterface 
{
	// adding
	public University add(University university);
	
	//getall
	public List<University> getAll();

	//get mech
	public Optional<University> getMech(String string);

	//low performance by department
	public List<Students> lowperformanceByDep(String string);

	//get all low perfromance
	public List<Students> getalllowperform();

	//6. Add 10 marks to all high performing students (marks above 60)
	//public List<Students> add10();

	public List<Students> add101();

	//7. Restricate or Remove all the least performing students (marks below 10)
	public void remove();

//	8. Sort the students within their departments based on their name
	public List<Students> sortNames();

	
	
//	8. Sort the students within their departments based on their marks
	

	public List<Students> sortBymarks(String department);

	
	

}
