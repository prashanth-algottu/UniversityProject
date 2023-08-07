package com.tec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tec.model.University;

@Repository
public interface URepository extends JpaRepository<University, Integer> {

	  
	 

}
