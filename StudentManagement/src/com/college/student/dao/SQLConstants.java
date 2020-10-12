package com.college.student.dao;

public class SQLConstants {

	protected static final String SAVE_QUERY = "insert into students values(?, SQNC_CODE.nextval, ?, ?, ?, ?)";

	protected static final String GET_QUERY = "select * from students where id = ?";

	protected static final String REMOVE_QUERY = "delete from students where id = ?";

	protected static final String UPDATE_QUERY = "update students set NAME = ?, DEPT = ?, GENDER = ?, DOB = ?, PHONE = ? where id = ? ";

	protected static final String SEQ_QUERY = " select SQNC_CODE.currval from dual";

}