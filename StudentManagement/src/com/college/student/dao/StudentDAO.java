package com.college.student.dao;

import com.college.student.bean.Student;
import com.college.student.exception.InvalidStudentException;

public interface StudentDAO {
	
	int persist(Student student)throws InvalidStudentException;
	
	Student fetch(int id) throws InvalidStudentException;
	
	boolean remove(int id) throws InvalidStudentException;
	
	int update(Student student) throws InvalidStudentException;
}