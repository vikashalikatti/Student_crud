package org.jsp.student_crud.service;

import java.util.List;
import java.util.Optional;

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
		List<Student> list = dao.fetchbymob(mob);
		Response_structure<List<Student>> response_structure = new Response_structure<>();
		if (list.isEmpty()) {
			response_structure.setMessage("Data Not Found");
			response_structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			response_structure.setData(null);
		} else {
			response_structure.setMessage("Data Found");
			response_structure.setStatusCode(HttpStatus.FOUND.value());
			response_structure.setData(list);
		}
		return response_structure;
	}

	public Response_structure<List<Student>> fetchbyResult(String result) {
		// TODO Auto-generated method stub
		List<Student> list = dao.fetchbyresult(result);
		Response_structure<List<Student>> response_structure = new Response_structure<>();
		if (list.isEmpty()) {
			response_structure.setMessage("Data Not Found");
			response_structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			response_structure.setData(null);
		} else {
			response_structure.setMessage("Data Found");
			response_structure.setStatusCode(HttpStatus.FOUND.value());
			response_structure.setData(list);
		}
		return response_structure;

	}

	public Response_structure<List<Student>> fetchbyResultNameandpercantage(String name, double percentage) {
		List<Student> list = dao.fetchbyResultNameandpercantage(name, percentage);
		Response_structure<List<Student>> response_structure = new Response_structure<>();
		if (list.isEmpty()) {
			response_structure.setMessage("Data Not Found");
			response_structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			response_structure.setData(null);
		} else {
			response_structure.setMessage("Data Found");
			response_structure.setStatusCode(HttpStatus.FOUND.value());
			response_structure.setData(list);
		}
		return response_structure;
	}

	public Response_structure<List<Student>> fetchall() {
		List<Student> list = dao.fetchall();
		Response_structure<List<Student>> response_structure = new Response_structure<>();
		if (list.isEmpty()) {
			response_structure.setMessage("Data Not Found");
			response_structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			response_structure.setData(null);
		} else {
			response_structure.setMessage("Data Found");
			response_structure.setStatusCode(HttpStatus.FOUND.value());
			response_structure.setData(list);
		}
		return response_structure;
	}

	public Response_structure<Student> deletebyid(int id) {
		Response_structure<Student> response_structure = new Response_structure<>();
		dao.deletebyid(id);
		response_structure.setMessage("Data Found");
		response_structure.setStatusCode(HttpStatus.FOUND.value());
		response_structure.setData(null);
		return response_structure;
	}

	public Response_structure<Student> update(int studentId, Student student) {
	    Optional<Student> existingStudent = Optional.ofNullable(dao.fetchbyid(studentId));

	    if (existingStudent.isPresent()) {
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
	                    student.setResult("fail");
	                }
	            }
	        }

	        student.setId(existingStudent.get().getId()); // Set the ID of the student object to the existing student's ID
	        Response_structure<Student> response_structure = new Response_structure<>();
	        response_structure.setMessage("Data updated successfully");
	        response_structure.setStatusCode(HttpStatus.OK.value());
	        response_structure.setData(dao.save(student));
	        return response_structure;
	    } else {
	        Response_structure<Student> response_structure = new Response_structure<>();
	        response_structure.setMessage("Student not found");
	        response_structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	        response_structure.setData(null);
	        return response_structure;
	    }
	}

	public Response_structure<List<Student>> deleteall() {
	    dao.deleteall();  // Assuming deleteall() method is implemented in dao

	    Response_structure<List<Student>> response_structure = new Response_structure<>();
	    response_structure.setMessage("All students deleted successfully");
	    response_structure.setStatusCode(HttpStatus.OK.value());
	    response_structure.setData(null);

	    return response_structure;
	}




}
