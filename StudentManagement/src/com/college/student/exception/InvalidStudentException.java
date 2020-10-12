package com.college.student.exception;

public class InvalidStudentException extends Exception {

	public InvalidStudentException() {
		super();
	}

	public InvalidStudentException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public InvalidStudentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidStudentException(String arg0) {
		super(arg0);
	}

	public InvalidStudentException(Throwable arg0) {
		super(arg0);
	}
}