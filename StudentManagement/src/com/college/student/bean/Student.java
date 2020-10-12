package com.college.student.bean;

import java.time.LocalDate;
/**
 * This is the BEAN class for Student.
 * Here we have defined what 
 * students' attributes will be.
 * @author Anurag
 * @version 1.0
 */
public class Student {

	private String studentName;
	private int studentId;
	private String departmentName;
	private char gender;
	private LocalDate dob;
	private String mobileNumber;
	
	public Student() {
	}

	public Student(String studentName, int studentId, String departmentName, char gender,
			String mobileNumber) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.departmentName = departmentName;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "\n Name: "+studentName+"\n ID: "+studentId+"\n Department :"+ departmentName+" \n Gender: "+ gender+"\n DOB: "+ dob +"\n Mob: "+mobileNumber+"\n";
	}
	
}