package com.tec.controller;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tec.model.Students;
import com.tec.model.University;
import com.tec.service.USeriveInterface;

@RestController
public class UController 
{
	@Autowired(required = true)
	USeriveInterface uSeriveInterface;
	
	//3. Add a student with given details to Computers dept using payload
	@PostMapping("/add")
	public String adding(@RequestBody University university  )
	{
		
		uSeriveInterface.add(university);
		return "Sucssesfully Inserted";
	}

	//1. Fetch all the students details from the university
	@GetMapping("/getAll")
	public List<University> getAll()
	{
		return uSeriveInterface.getAll();
	}
	
	//2. Fetch only Mech students from the university
	@GetMapping("/getOnly/{string}")
	public Optional<University> getMech(@PathVariable String string)
	{
		return uSeriveInterface.getMech(string);
	}
	
	//4. Fetch only low performing (marks below 40) students from Physics dept
	@GetMapping("/lowperformance/{string}")
	public List<Students> lowper(@PathVariable String string )
	{
		return uSeriveInterface.lowperformanceByDep(string);
	}
	
	
	//5. Fetch low performing (marks below 40) students from all depts
	@GetMapping("/lowperformancefromall")
	public List<Students> lowfromall()
	{
		return uSeriveInterface.getalllowperform();
	}
	
	//6. Add 10 marks to all high performing students (marks above 60)
	@PutMapping("/add10")
	public List<Students> add10()
	{
		return uSeriveInterface.add101();
	}
	
	//7. Restricate or Remove all the least performing students (marks below 10)
	@DeleteMapping("/remove")
	public String removelow()
	{
		uSeriveInterface.remove();
		return "removed";
	}
	
	//8. Sort the students within their departments based on their name or marks
	@GetMapping("/sortbynames")
	public List<Students> sorames()
	{
		return uSeriveInterface.sortNames();
	}
	
	//8. Sort the students within their departments based on their marks
	
	@GetMapping("/sortmarks/{department}")
	public List<Students> sort(@PathVariable String department)
	{
		return uSeriveInterface.sortBymarks(department);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
