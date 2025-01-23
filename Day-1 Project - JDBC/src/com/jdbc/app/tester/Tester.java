package com.jdbc.app.tester;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.app.DeleteDBOperation;
import com.jdbc.app.InsertDBOperation;
import com.jdbc.app.SelectDBOperation;
import com.jdbc.app.UpdateDBOperation;
import com.jdbc.utils.JDBCConnection;

public class Tester {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in) ;
		
		
		while (true) {
			System.out.println(
					"\t ****** Student Management System ******\n \t 1] List of Student \n \t 2] Insert Student \n \t "
					+ "3] Update Student \n \t 4] Delete Student \n \t 5] Exit");
			
			System.out.println("___________________________________________________");
			System.out.print("Enter Choice From Menu: ");
			int choice = sc.nextInt();
			
			if( choice == 1 ) {
				// list
				SelectDBOperation.getAllStudents();
				System.out.println("___________________________________________________");
			} else if (choice == 2) {
				// add
				InsertDBOperation.addStudent();
				System.out.println("___________________________________________________");
			} else if (choice == 3) {
				// update
				UpdateDBOperation.updateStudent();
				System.out.println("___________________________________________________");
			} else if (choice == 4) {
				// delete
				DeleteDBOperation.deleteStudent();
				System.out.println("___________________________________________________");
			} else if (choice == 5) {
				// exit
				JDBCConnection.closeConnection();
				break  ;
			}
			
		}

	}

}
