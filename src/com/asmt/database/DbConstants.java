package com.asmt.database;

public class DbConstants {
	
	final static int DB_VERSION = 1;
	final static String DB_NAME = "AsmtDb";
	final static String TB_NAME = "Students";
	final static String _ID = "id";
	final static String ST_NAME = "Name";
	final static String ST_ROLL = "Roll";
	final static String CREATE_QUERY = "CREATE TABLE "+TB_NAME+" ("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
										ST_NAME+" VARCHAR(255),"+
										ST_ROLL+" VARCHAR(10));";
	final static String DELETE_QUERY = "DELETE TABLE IF EXIST "+TB_NAME;
}
