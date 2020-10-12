package com.college.student.service;

import java.sql.Date;
import java.time.LocalDate;

import com.college.student.bean.Student;
import com.college.student.dao.StudentDAO;
import com.college.student.dao.StudentDAOImpl;
import com.college.student.exception.InvalidStudentException;

/**
 * This class is the implementation of the Service interface.
 * Some Business logic is here.	
 * @author Anurag
 * @version 1.0
 */
public class StudentServiceImpl implements StudentService {
	
	private StudentDAO dao;

	public StudentServiceImpl() {
		dao = new StudentDAOImpl();
	}

	@Override
	public boolean checkGender(char gender) {
		if (gender == 'M' || gender == 'F')
			return true;
		else
			return false;
	}

	@Override
	public boolean checkDOB(LocalDate date) {
		Date d1 = new Date(System.currentTimeMillis());
		Date d2 = Date.valueOf(date);
		if(d2.before(d1))
			return true;
		return false;
	}

	@Override
	public int saveStudent(Student student) throws InvalidStudentException {
		return dao.persist(student);
	}

	@Override
	public Student getStudent(int studentId) throws InvalidStudentException {
		return dao.fetch(studentId);
	}

	@Override
	public boolean removeStudent(int studentId) throws InvalidStudentException {
		return dao.remove(studentId);
	}

	@Override
	public int updateStudent(Student student) throws InvalidStudentException {
		return dao.update(student);
	}
}