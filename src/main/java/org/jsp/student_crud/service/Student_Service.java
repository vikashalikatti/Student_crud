package org.jsp.student_crud.service;

import java.util.List;

import org.jsp.student_crud.dao.Student_dao;
import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.helper.Response_structure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class Student_Service {

	@Autowired
	Student_dao dao;

	public Response_structure<Student> save(Student student) {
		// TODO Auto-generated method stub
		double percentage = (student.getEnglish_marks() + student.getMath_marks() + student.getScience_marks()
				+ student.getScience_marks()) / 4.0;
		student.setPercentage(percentage);
		if (percentage > 85) {
			student.setResult("Distinction");
		} else {
			if (percentage > 60) {
				student.setResult("First_Class");
			} else {
				if (percentage > 45) {
					student.setResult("Just Pass");
				} else {
					{
						student.setResult("fail");
					}
				}
			}
		}

		Response_structure<Student> response_structure = new Response_structure<>();
		response_structure.setMessage("Data saved Sucessfully");
		response_structure.setStatusCode(HttpStatus.CREATED.value());
		response_structure.setData(dao.save(student));

		return response_structure;
	}

	public Response_structure<List<Student>> saveall(List<Student> students) {
		for (Student student1 : students) {
			double percentage = (student1.getEnglish_marks() + student1.getMath_marks() + student1.getScience_marks()
					+ student1.getScience_marks()) / 4.0;
			student1.setPercentage(percentage);
			if (percentage > 85) {
				student1.setResult("Distinction");
			} else {
				if (percentage > 60) {
					student1.setResult("First_Class");
				} else {
					if (percentage > 45) {
						student1.setResult("Just Pass");
					} else {
						{
							student1.setResult("fail");
						}
					}
				}
			}
		}
		Response_structure<List<Student>> response_structure = new Response_structure<>();
		response_structure.setMessage("Data saved Sucessfully");
		response_structure.setStatusCode(HttpStatus.CREATED.value());
		response_structure.setData(dao.saveall(students));

		return response_structure;

	}

	public Response_structure<Student> fetchbyid(int id) {
		Response_structure<Student> response_structure = new Response_structure<>();
		Student dto = dao.fetchbyid(id);
		if (dto == null) {
			response_structure.setMessage("Data Not Found");
			response_structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			response_structure.setData(dto);
		} else {
			response_structure.setMessage("Data Found");
			response_structure.setStatusCode(HttpStatus.FOUND.value());
			response_structure.setData(dto);
		}
		return response_structure;

	}

	public Response_structure<List<Student>> fetchbymobile(long mob) {
	dao.fetchbyid(mob); 
	}
}
