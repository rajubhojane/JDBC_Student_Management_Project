package com.jdbc.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.utils.JDBCConnection;

public class DeleteDBOperation {

	public static void deleteStudent() throws ClassNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in) ;
		
		Connection connection = JDBCConnection.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id=?");
		
		System.out.println("Enter Student id to delete Student: ");
		preparedStatement.setInt(1, sc.nextInt());
		System.out.println(4);

		int row = preparedStatement.executeUpdate() ;
		if(row > 0) {
			System.out.println("data deleted !!!");
		} else {
			System.out.println("Somting went wrong data is not deleted !!!");
		}
		
		preparedStatement.close() ;
		
	}

}
