package com.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class checkingInsert {
	
	
	public checkingInsert()
	{
	}
	
	 static final String DB_URL = "jdbc:mysql://localhost/bms";
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   public Connection getconnection()
	   {
		   Connection con = null;
		   try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   con = DriverManager.getConnection(DB_URL, USER, PASS);
			 //  System.out.println("connected!!!!!!!!!");
		   }catch(Exception e)
		   {
			   System.out.println("Did not connected");
		   }
		   return con;
	   }
	   
	   
	   
	public void insert( String username,String pass)
	{
		Connection conn = null;
		Statement stmt=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      
		      stmt = conn.createStatement();
		     // stmts = conn.createStatement();
		      
		     String valueInsert = "INSERT INTO login(Username,Password)  VALUES('"+username+"','"+pass+"')";
		     
		    //  String je = "select * from login";
		    //  stmt.executeQuery(je);
		    // stmt.executeQuery(valueInsert);
		    stmt.executeUpdate(valueInsert);
		    /* if(me.next())
		     {
		    	  username = me.getString("Username");
		    	 pass= me.getString("Password");
		    	 System.out.println("Username: "+username);
		    	 System.out.println("Password: "+pass);
		     }*/
			System.out.println("connected");
		}catch(SQLException se){
		      System.out.println("Not connected");
		  }catch(Exception  e)
		   {System.out.println("class not found");
		   }finally {
			   
				      //finally block used to close resources
				      try{
				         if(stmt!=null)
				            conn.close();
				      }catch(SQLException se){
				      }// do nothing
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
		    	
	   
	}
	}

}
