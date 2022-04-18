package com.tec.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tec.model.Students;
import com.tec.model.University;
import com.tec.repository.URepository;
import com.tec.repository.UintefaceStudents;

@Service
public class UServiceImplimentation1 implements USeriveInterface {

	@Autowired
	URepository uRepository;

	@Autowired
	UintefaceStudents uintefaceStudents;

	@Override
	public University add(University university) {

		return uRepository.save(university);
	}

	@Override
	public List<University> getAll() {
		List<University> list = uRepository.findAll();
		return list;
	}

	@Override
	public Optional<University> getMech(String string) {
		int a = 0;
		if (string.equalsIgnoreCase("mech")) {
			a = 1;
		} else if (string.equalsIgnoreCase("electrical")) {
			a = 2;

		} else if (string.equalsIgnoreCase("computers")) {
			a = 3;

		} else if (string.equalsIgnoreCase("physics")) {
			a = 4;

		}
		Optional<University> optional = uRepository.findById(a);

		return optional;
	}

	@Override
	public List<Students> lowperformanceByDep(String string) {

		int a = 0;
		if (string.equalsIgnoreCase("mech")) {
			a = 1;
		} else if (string.equalsIgnoreCase("electrical")) {
			a = 2;

		} else if (string.equalsIgnoreCase("computers")) {
			a = 3;

		} else if (string.equalsIgnoreCase("physics")) {
			a = 4;

		}
		Optional<University> optional = uRepository.findById(a);
		University university = optional.get();
		List<Students> stu = university.getStudents();
		List<Students> s = stu.stream().filter(i -> i.getMarks() < 40).collect(Collectors.toList());
		return s;

	}

	@Override
	public List<Students> getalllowperform() {

		List<University> all = uRepository.findAll();
		University university = all.get(0);
		List<Students> stu1 = university.getStudents();
		List<Students> list1 = stu1.stream().filter(i -> i.getMarks() < 40).collect(Collectors.toList());

		List<Students> stu2 = all.get(1).getStudents();
		List<Students> list2 = stu2.stream().filter(i -> i.getMarks() < 40).collect(Collectors.toList());

		List<Students> stu3 = all.get(2).getStudents();
		List<Students> list3 = stu3.stream().filter(i -> i.getMarks() < 40).collect(Collectors.toList());

		List<Students> stu4 = all.get(3).getStudents();
		List<Students> list4 = stu4.stream().filter(i -> i.getMarks() < 40).collect(Collectors.toList());

		List<Students> list = new ArrayList<Students>(list1);
		list.addAll(list2);
		list.addAll(list3);
		list.addAll(list4);

		// list.add((Students) list1);
//		list.add(list2);

		return list;

	}

	// 6. Add 10 marks to all high performing students (marks above 60)
	@Override
	public List<Students> add101() {
		List<Students> all = uintefaceStudents.findAll();
		List<Students> list = all.stream().filter(i -> i.getMarks() > 60).collect(Collectors.toList());

		for (Students s : list) {
			s.setMarks(s.getMarks() + 10);
			uintefaceStudents.save((s));

		}

		return list;

	}

//7. Restricate or Remove all the least performing students (marks below 10)
	@Override
	public void remove() {
		List<Students> list = uintefaceStudents.findAll();
		List<Students> list2 = list.stream().filter(i -> i.getMarks() < 10).collect(Collectors.toList());
		for (Students s : list2) {
//			
			uintefaceStudents.deleteById(s.getId());

		}

//			list2.remove(list2);
//			uRepository.deleteAll();
//			return list2;
	}

//8. Sort the students within their departments based on their name
	@Override
	public List<Students> sortNames() {

		List<University> list = uRepository.findAll();
		List<Students> list1 = list.get(0).getStudents().stream()
				.sorted((i, j) -> i.getName().compareToIgnoreCase(j.getName())).collect(Collectors.toList());

		List<Students> list2 = list.get(1).getStudents().stream()
				.sorted((i, j) -> i.getName().compareToIgnoreCase(j.getName())).collect(Collectors.toList());

		List<Students> list3 = list.get(2).getStudents().stream()
				.sorted((i, j) -> i.getName().compareToIgnoreCase(j.getName())).collect(Collectors.toList());

		List<Students> list4 = list.get(3).getStudents().stream()
				.sorted((i, j) -> i.getName().compareToIgnoreCase(j.getName())).collect(Collectors.toList());

		List<Students> list5 = new ArrayList<>();

		list5.addAll(list1);
		list5.addAll(list2);
		list5.addAll(list3);
		list5.addAll(list4);

		return list5;
	}

	

	// 8. Sort the students within their departments based on their marks
//	@Override
	
	public List<Students> sortBymarks(String dept) {
		List<University> list = uRepository.findAll();

		List<Students> list2 = new ArrayList<>();
		
		if (dept.equalsIgnoreCase("mech")) {
			list2 = list.get(0).getStudents();
			Collections.sort(list2, Comparator.comparing(Students::getMarks));
		} 
		else if (dept.equalsIgnoreCase("electrical")) 
		{
			list2 = list.get(1).getStudents();
			Collections.sort(list2, Comparator.comparing(Students::getMarks));
		}

		else if (dept.equalsIgnoreCase("computers")) 
		{
			list2 = list.get(2).getStudents();
			Collections.sort(list2, Comparator.comparing(Students::getMarks));
		} 
		else if (dept.equalsIgnoreCase("physics")) 
		{
			list2 = list.get(3).getStudents();
			Collections.sort(list2, Comparator.comparing(Students::getMarks));
		}
		
		
//		List<University> list3 = uRepository.findByDept(department);
//		List<Students> students = new ArrayList<>();
//		for(University u:list3)
//		{
//			students = u.getStudents();
//			Collections.sort(students, Comparator.comparing(Students::getMarks));
//		}

		return list2;
	}
	
	
	
	

}
