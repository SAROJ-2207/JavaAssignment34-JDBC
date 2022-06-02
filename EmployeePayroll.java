package com.assignment34;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeePayroll {
		
			static String url = "jdbc:mysql://localhost:3306/employee_payroll?user=root&password=SAROJ@2207";
			
			public static void main(String[] args) throws ClassNotFoundException  {
				
				create();			
				insert();				
				update();
				delete();
				showTable();
			}	
			
			public static void create() throws ClassNotFoundException {
				String query = "create table employee_payroll(Id int unsigned NOT NULL AUTO_INCREMENT,Emp_Name Varchar(200),Phone_number varchar(200),Address varchar(200),Department varchar(200),Gender varchar(100),PRIMARY KEY(Id))";
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");								
					Connection connection = SingletonConnectionPayroll.getInstance();
					System.out.println("Connection create Established....");
					
					Statement stm = connection.createStatement();
					System.out.println("Established Create statement.....");
					
					stm.executeUpdate(query);
					System.out.println("Executed the create Update.....");
					
					connection.close();
					System.out.println("Connection Closed....");

				}catch(SQLException e) {
					e.printStackTrace();}
					
				}	
					
			public static Connection getConnection() throws SQLException {		
					Connection connection = DriverManager.getConnection(url);
					return connection;
			}
			
					// Insert Method
			public static void insert() {
								
				String query = "insert into employee_payroll values(null, 'Alexa','9658741255','Hariyana','Sales','M')";
				
				try {
					
					Connection connection = SingletonConnectionPayroll.getInstance();
					System.out.println("Connection Established....");
					Statement stm = connection.createStatement();
					System.out.println("Established insert statement.....");
					stm.executeUpdate(query);
					System.out.println("Executed the insert  Query.....");
					connection.close();
					System.out.println("Connection insert Closed....");
				}catch(SQLException e) {
					e.printStackTrace();
					}			
				}
			
			
		//Update Method  
			public static void update() {

				String query = "update employee_payroll set id= 3,name = 'A Reddy' where id = 50";
				
				try {
					
					Connection connection = SingletonConnectionPayroll.getInstance();
					System.out.println("Connection Established....");
					Statement stm = connection.createStatement();
					System.out.println("Established Update statement.....");
					stm.executeUpdate(query);
					System.out.println("Executed the Update Query.....");
					connection.close();
					System.out.println("Connection Update Closed....");
				}catch(SQLException e) {
					e.printStackTrace();
					}			
				}
			
			
			
			//Delete method 
			
			public static void delete() {

				String query = "delete from employee_payroll where id = 10";
				
				try {
					
					Connection connection = SingletonConnectionPayroll.getInstance();
					System.out.println("Connection Established....");
					Statement stm = connection.createStatement();
					System.out.println("Established delete statement.....");
					stm.executeUpdate(query);
					System.out.println("Executed the delete Query.....");
					connection.close();
					System.out.println("Connection delete Closed....");
				}catch(SQLException e) {
					e.printStackTrace();
					}			
			}
			
			//ShowTable Method
			public static void showTable() {
				String query = "select * from employee_payroll";
				
				try {
				
					Connection connection = SingletonConnectionPayroll.getInstance();
					System.out.println("Connection showTable....");
					Statement stm = connection.createStatement();
					ResultSet response = stm.executeQuery(query);
					System.out.println("Established statement showTable.....");
					stm.executeQuery(query);
					System.out.println("Executed the Query showTable .....");
					while(response.next()) {
						System.out.println(response.getString("id")+" "+response.getString("name"));
						
					}
					connection.close();
					System.out.println("Connection Closed showTable....");
				}catch(SQLException e) {
					e.printStackTrace();
					
				}			
			}
}


