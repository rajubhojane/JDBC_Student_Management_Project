package com.jdbc.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.utils.JDBCConnection;

public class InsertDBOperation {

	public static void addStudent() throws ClassNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in);

		Connection connection = JDBCConnection.getConnection();

		String query = "insert into student(name , marks , rollNum) values (? , ? , ?)";
		PreparedStatement prestatement = connection.prepareStatement(query);
		System.out.println("Enter Student Name: ");
		String name = sc.next();

		System.out.println("Enter Student Marks: ");
		double marks = sc.nextDouble();

		System.out.println("Enter Student rollNum: ");
		int rollNum = sc.nextInt();

		prestatement.setString(1, name);
		prestatement.setDouble(2, marks);
		prestatement.setInt(3, rollNum);

		int row = prestatement.executeUpdate();
		if (row > 0) {
			System.out.println("data inserted !!!");
		} else {
			System.out.println("Somting went wrong data is not inserted !!!");
		}

		prestatement.close();
	

	}

}
