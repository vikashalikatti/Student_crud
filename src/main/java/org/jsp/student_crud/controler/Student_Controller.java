package org.jsp.student_crud.controler;

import java.util.List;

import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student_Controller {
	
	@Autowired
	Student_Service service;
	
	@PostMapping("students")
	public Student save(@RequestBody Student student) {
		return service.save(student) ;
	}
	
	@PostMapping("students/multiple")
	public List <Student> saveall(@RequestBody List<Student> student) {
		return service.saveall(student) ;
	}
}
