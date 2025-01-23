package com.jdbc.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.utils.JDBCConnection;

public class UpdateDBOperation {

	public static void updateStudent() throws ClassNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in) ;
		
		Connection connection = JDBCConnection.getConnection();
	
		PreparedStatement preparedStatement = connection.prepareStatement("update student set name=? where id=?") ;
		System.out.println("Enter Updated Name: ");
		preparedStatement.setString(1, sc.next());
		
		System.out.println("Enter Student ID: ");
		preparedStatement.setInt(2, sc.nextInt());
		
		int row = preparedStatement.executeUpdate() ;
		if(row > 0) {
			System.out.println("data updated !!!");
		} else {
			System.out.println("Somting went wrong data is not updated !!!");
		}
		
		preparedStatement.close() ;
		
		
	}

}
