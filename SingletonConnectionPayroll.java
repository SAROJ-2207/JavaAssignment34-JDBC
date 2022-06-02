package com.assignment34;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnectionPayroll {

		static Connection connection = null;
		
			private SingletonConnectionPayroll() {
				
			}
			
			public static Connection getInstance() {
				 String url = "jdbc:mysql://localhost:3306/employee_payroll?user=root&password=SAROJ@2207";

				
				try {
					if(connection == null)
					connection = DriverManager.getConnection(url);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return connection;
			}
	}
