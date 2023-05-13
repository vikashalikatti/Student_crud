package org.jsp.student_crud.controler;

import java.util.List;

import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.helper.Response_structure;
import org.jsp.student_crud.service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student_Controller {
	
	@Autowired
	Student_Service service;
	
	@PostMapping("students")
	public Response_structure<Student> save(@RequestBody Student student) {
		return service.save(student) ;
	}
	
	@PostMapping("students/multiple")
	public Response_structure<List<Student>> saveall(@RequestBody List<Student> student) {
		return service.saveall(student) ;
	}
	
	@GetMapping("students")
	public Response_structure<Student> fetchid(@RequestParam int id){
		return service.fetchbyid(id);
	}
	
	@GetMapping("students/{id}")
	public Response_structure<Student> fetchbyid2(@PathVariable int id){
		return service.fetchbyid(id);
	}
	
	@GetMapping("students/mobile/{mob}")
	public Response_structure<List<Student>> fetchbymobile(@PathVariable long mob){
		return service.fetchbymobile(mob);
	}
	
	@GetMapping("students/result/{result}")
	public Response_structure<List<Student>> fetchbyResult(@PathVariable String result){
		return service.fetchbyResult(result);
	}
	
	@GetMapping("students/{name}/{percentage}")
	public Response_structure<List<Student>> fetchbyResultNameandpercantage(@PathVariable String name ,@PathVariable double percentage){
		return service.fetchbyResultNameandpercantage(name,percentage);
	}
	
	@GetMapping("Fetchall")
	public Response_structure<List<Student>> fetchall(){
		return service.fetchall();
	}
}
