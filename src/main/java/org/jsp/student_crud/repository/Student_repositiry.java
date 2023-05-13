package org.jsp.student_crud.repository;

import java.util.List;

import org.jsp.student_crud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Student_repositiry extends JpaRepository<Student, Integer> {
	List<Student> findByMobile(long mobile);
	
	List<Student> findByResult(String result);
	
	@Query("select x from Student x where name=?1 and percentage>=?2")
	List<Student> fetchbyResultNameandpercantage(String name, double percentage);
	
	
}
