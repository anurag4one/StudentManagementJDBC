package com.college.student.service;

import java.time.LocalDate;
import com.college.student.bean.Student;
import com.college.student.exception.InvalidStudentException;

// Create students, Read Students, Update Students, Delete Students.
public interface StudentService {
	
	default boolean validateName(String name) {
		boolean b = name.matches(StudentServiceConstants.NAME_RULE);
		return b;
	}
	
	default boolean validateDepartment(String department) {
		boolean b =  department.matches(StudentServiceConstants.DEPARTMENT_RULE);
		return b;
	}

	boolean checkGender(char gender);
	boolean checkDOB(LocalDate date);
		
	//Business Logic Methods
	int saveStudent(Student student) throws InvalidStudentException;
	
	Student getStudent(int studentId) throws InvalidStudentException;
	
	boolean removeStudent(int studentId) throws InvalidStudentException;
	
	int updateStudent(Student student)  throws InvalidStudentException;;
	
}