package org.jsp.student_crud.helper;

import lombok.Data;

@Data
public class Response_structure<T> {
	String message;
	int statusCode;
	T data;
}
