package org.jsp.student_crud.repository;

import org.jsp.student_crud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Student_repositiry extends JpaRepository<Student, Integer> {
	
}