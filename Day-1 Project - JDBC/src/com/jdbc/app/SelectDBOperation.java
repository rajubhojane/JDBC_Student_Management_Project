package com.jdbc.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.utils.JDBCConnection;

public class SelectDBOperation {

	public static void getAllStudents() throws ClassNotFoundException, SQLException, IOException {
		
		Connection connection = JDBCConnection.getConnection();
		
		Statement statement = connection.createStatement() ;

		String query = "select * from student" ;
		ResultSet resultSet = statement.executeQuery(query) ;
		
		while( resultSet.next() ) {
			int id = resultSet.getInt("id") ;
			String name = resultSet.getString("name");
			double marks = resultSet.getDouble("marks");
			int rollNum = resultSet.getInt("rollNum") ;
			System.out.println("Student Name is: " + name);
			System.out.println("Student Marks are: " + marks);
			System.out.println("Student Roll Number is: " + rollNum);
			System.out.println("----------------------------------");
			// System.out.println(id + " >> " + name + " >> " + marks + " >> " + rollNum);
		}
	
		statement.close() ;
		
		
	}

}
