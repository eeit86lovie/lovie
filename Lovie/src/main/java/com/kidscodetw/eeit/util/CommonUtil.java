package com.kidscodetw.eeit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CommonUtil {
	
	public static void main(String[] args){
		
	}

	public static Connection connectMysql2() {
		Connection conn = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/eeit86");
			try {
				conn = ds.getConnection();
				return conn;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (NamingException e) {

			e.printStackTrace();
		}
		return conn;
	}

	public static Connection connectMysql() {
		String user = "eeit86";
		String password = "eeit86";
		String database = "eeit86";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connUrl = "jdbc:mysql://eeit.kidscodetw.com:3306/" + database + "?characterEncoding=utf8";
			Connection conn = DriverManager.getConnection(connUrl, user, password);
			return conn;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println("can't connect to MySQL");
		return null;
	}
	
	public static Connection connectMysql1() {
		String user = "eeit86";
		String password = "eeit86";
		String database = "eeit86";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connUrl = "jdbc:mysql://eeit.kidscodetw.com:3306/" + database + "?characterEncoding=utf8";
			Connection conn = DriverManager.getConnection(connUrl, user, password);
			return conn;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println("can't connect to MySQL");
		return null;
	}
}
