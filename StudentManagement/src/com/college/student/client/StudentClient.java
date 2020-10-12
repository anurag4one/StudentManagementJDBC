package com.college.student.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

import com.college.student.bean.Student;
import com.college.student.exception.InvalidStudentException;
import com.college.student.service.StudentService;
import com.college.student.service.StudentServiceImpl;

/** This is the Client class,
 * We will Run this to see
 * how student management works functionally
 * @author Anurag
 */
public class StudentClient {

	private static Scanner console;
	private static BufferedReader br;
	private static StudentService service;

	static {
		console = new Scanner(System.in);
		br = new BufferedReader(new InputStreamReader(System.in));
		service = new StudentServiceImpl();
	}

	public static void main(String[] args) throws IOException {

		int option = 0;
		while (true) {
			System.out.println("--------- Choose anyone: -----------");
			System.out.println("1. Add a new Student");
			System.out.println("2. Search for a Student");
			System.out.println("3. Remove a Student");
			System.out.println("4. Update a student ");
			System.out.print("Enter a value: ");
			option = console.nextInt();
			System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");

			switch (option) {
			case 1:
				addStudent();
				break;
			case 2:
				searchStudent();
				break;
			case 3:
				deleteStudent();
				break;
			case 4:
				updateStudent();
				break;
			default:
				System.out.println("Use your Brain !!");
			}

			System.out.println("Wish to continue? if yes then press \"Y\" else \"N\" ");
			String wish = console.next();
			if (wish.toUpperCase().equals("N"))
				break;
		}
	}

	/**
	 * This method is used to add a new Student into the Database
	 * 
	 * @throws IOException
	 */
	private static void addStudent() throws IOException {

		Student student = createNewStudent();

		try {
			int studentID = service.saveStudent(student);
			System.out.println("Student saved with ID: " + studentID);
		} catch (InvalidStudentException e) {
			System.out.println("Details couldn't be saved");
		}
	}

	/**
	 * This method is used to take input for creating a new student and validates those inputs to be of correct format
	 * @return Student
	 * @throws IOException
	 */
	private static Student createNewStudent() throws IOException {

		System.out.println("----- Enter Student details: -----");

		String name;
		String department;
		char gender;
		LocalDate dob;
		String mobile;

		do {
			System.out.println("Enter Student Name (ex: Doland Trumpet): ");
			name = br.readLine();
		} while (!service.validateName(name));

		do {
			System.out.println("Enter Department Name (Only 2 words accepted. eg: Politcal Sanse): ");
			department = br.readLine();
		} while (!service.validateDepartment(department));

		do {
			System.out.println("Enter Gender (ex: M/F, no third Gender): ");
			String g = br.readLine();
			gender = g.charAt(0);
			gender = Character.toUpperCase(gender);
		} while (!service.checkGender(gender));

		do {
			System.out.println("Enter Student Date Of Birth (yyyy-MM-dd): ");
			String dateOfBirth = br.readLine();
			dob = LocalDate.parse(dateOfBirth);
		} while (!service.checkDOB(dob));

		System.out.println("Enter Mobile Number (10 Digit Numbers accepted.):");
		mobile = br.readLine();

		Student student = new Student();
		student.setStudentName(name);
		student.setDepartmentName(department);
		student.setGender(gender);
		student.setDob(dob);
		student.setMobileNumber(mobile);

		return student;
	}

	/**
	 * This method is used to search a student in the database
	 * @throws IOException
	 */
	private static void searchStudent() throws IOException {

		System.out.println("Enter Student ID: ");

		int id = Integer.parseInt(br.readLine());

		Student student = null;
		try {
			student = service.getStudent(id);
			System.out.println(student.toString());
		} catch (InvalidStudentException e) {
			System.out.println("Invalid ID Received " + e.getMessage());
		}
	}
	
	/** 
	 * This method is used to delete a student record from the DB
	 * @throws IOException
	 */
	private static void deleteStudent() throws IOException {
		System.out.println("Enter Student ID: ");

		int id = Integer.parseInt(br.readLine());

		try {
			boolean b = service.removeStudent(id);
			if (b)
				System.out.println("Student with id " + id + " successfully removed");
			else
				System.out.println("Operation Failed");
		} catch (InvalidStudentException e) {
			System.out.println("Wrong ID received " + e.getMessage());
		}

	}

	/**
	 * This method is used to Update an existing student detail already present in the DB
	 * @throws IOException
	 */
	private static void updateStudent() throws IOException {
		System.out.println("Enter Student ID to fetch current details: ");
		int id = Integer.parseInt(br.readLine());

		Student student = null;

		try {
			student = service.getStudent(id);
		} catch (InvalidStudentException e) {
			System.out.println("Wrong ID received " + e.getMessage());
		}
		System.out.println("Current Details of Student:\n" + student.toString());

		student = createNewStudent();
		student.setStudentId(id);

		int success = 0;
		try {
			success = service.updateStudent(student);
		} catch (InvalidStudentException e) {
			System.out.println("Wrong ID received " + e.getMessage());
		}
		if (success == 1) {
			System.out.println("Updated Successfully");
			try {
				student = service.getStudent(id);
				System.out.println("New Details of Student:\n" + student.toString());
			} catch (InvalidStudentException e) {
				System.out.println("Wrong ID received " + e.getMessage());
			}
		} else
			System.out.println("Update Failed");
	}
}