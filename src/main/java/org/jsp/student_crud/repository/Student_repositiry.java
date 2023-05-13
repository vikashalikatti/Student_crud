package org.jsp.student_crud.repository;

import java.util.List;

import org.jsp.student_crud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Student_repositiry extends JpaRepository<Student, Integer> {
	List<Student> findByMobile(long mobile);
}
