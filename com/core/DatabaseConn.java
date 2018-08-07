package com.core;

import java.sql.*;
public class DatabaseConn {
	
	// JDBC driver name and database URL
	  // static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/bms";
	   static final String USER = "root";
	   static final String PASS = "";
	 public  Connection conn = null;
	public    Statement stmt=null;
	   
	   public void connection() 
	   {
		  
		   try{
			      //STEP 2: Register JDBC driver
				   Class.forName("com.mysql.cj.jdbc.Driver");

			      //STEP 3: Open a connection
			    //  System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			  //    stmt = conn.createStatement();
			      System.out.println("Conntected");
			      int ssn =12345;
			      stmt = conn.createStatement();
			      
			      String m = "delete from ssn where ssn_number='"+ssn+"'";
			      stmt.executeUpdate(m);
			      System.out.println("delet the file from the folder");
			      
			   }catch(SQLException se){
			      System.out.println("Not connected");
			  }catch(Exception  e)
			   {System.out.println("class not found");
			   System.out.println("could not delete form the table ");
			   } 
			    
			   
	   }
}
