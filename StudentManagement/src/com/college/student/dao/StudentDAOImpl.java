package com.college.student.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.college.student.bean.Student;
import com.college.student.exception.InvalidStudentException;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public int persist(Student student) throws InvalidStudentException {
		Connection conn = null;

		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQLConstants.SAVE_QUERY);
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getDepartmentName());
			ps.setString(3, Character.toString(student.getGender()));
			ps.setDate(4, Date.valueOf(student.getDob()));
			ps.setString(5, student.getMobileNumber());

			ps.executeUpdate();
			ResultSet rs = conn.createStatement().executeQuery(SQLConstants.SEQ_QUERY);
			if (rs.next())
				return rs.getInt(1);
			else
				return 0;
		} catch (SQLException e) {
			throw new InvalidStudentException(e.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public Student fetch(int id) throws InvalidStudentException {
		Student student = null;
		Connection conn = null;

		try {
			conn = JdbcUtil.getConnection();

			PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_QUERY);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student();
				student.setStudentName(rs.getString(1));
				student.setStudentId(rs.getInt(2));
				student.setDepartmentName(rs.getString(3));
				student.setGender(rs.getString(4).charAt(0));
				student.setDob(rs.getDate(5).toLocalDate());
				student.setMobileNumber(rs.getString(6));
			} else
				throw new InvalidStudentException("Wrong ID");
			return student;
		} catch (SQLException e) {
			throw new InvalidStudentException("Wrong ID");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public boolean remove(int id) throws InvalidStudentException {
		Connection conn = null;
		Student s = null;

		try {
			conn = JdbcUtil.getConnection();

			PreparedStatement ps = conn.prepareStatement(SQLConstants.REMOVE_QUERY);
			ps.setInt(1, id);

			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			throw new InvalidStudentException("Wrong ID");
		}

		finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public int update(Student student) throws InvalidStudentException {

		Connection conn = null;
		int success = 0;

		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQLConstants.UPDATE_QUERY);
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getDepartmentName());
			ps.setString(3, Character.toString(student.getGender()));
			ps.setDate(4, Date.valueOf(student.getDob()));
			ps.setString(5, student.getMobileNumber());
			ps.setInt(6, student.getStudentId());

			success = ps.executeUpdate();

		} catch (SQLException e) {
			throw new InvalidStudentException("Wrong ID");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return success;
	}
}