package com.tec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tec.model.Students;

@Repository
public interface UintefaceStudents extends JpaRepository<Students, Integer> {

}
