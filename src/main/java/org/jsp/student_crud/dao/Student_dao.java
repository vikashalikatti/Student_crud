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
	public List<Student> fetchbymob(long mob) {
		return repositiry.findByMobile(mob);
		
	}
	public List<Student> fetchbyresult(String result) {
		// TODO Auto-generated method stub
		return repositiry.findByResult(result);
	}
	public List<Student> fetchbyResultNameandpercantage(String name, double percentage) {
		// TODO Auto-generated method stub
		return repositiry.fetchbyResultNameandpercantage(name,percentage);
	}
	public List<Student> fetchall() {
		// TODO Auto-generated method stub
		return repositiry.findAll();
	}
	public void deletebyid(int id) {
		// TODO Auto-generated method stub
		 repositiry.deleteById(id);
		 }
	public void deleteall() {
		repositiry.deleteAll();
	}
	
}
