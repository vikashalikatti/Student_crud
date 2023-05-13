package org.jsp.student_crud.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.repository.Student_repositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Student_dao {
	@Autowired 
	Student_repositiry repositiry;
	
	public Student save(Student student) {
		return repositiry.save(student);
	}
	public List<Student> saveall(List<Student> students) {
		return repositiry.saveAll(students);
	}
	public Student fetchbyid(int id) {
		Optional<Student> optional = repositiry.findById(id);
		if(optional.isEmpty()) {
			return null;
		}else {
			return optional.get();
		}
	}
	public List<Student> fetchbyid(long mob) {
		return repositiry.findByMobile(mob);
		
	}
	
}
