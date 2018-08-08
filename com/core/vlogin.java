package com.core;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class vlogin {
	private  String username;
     private String pw;
     
     public vlogin()
     {
    	 username =null;
    	 pw = null;
     }
     
    public  vlogin(String username, String pw)
     {
    	this.username = username;
    	 this.pw=pw;
     }
    
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}



	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/bms";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	  
	   
	public boolean checking()
	{
			Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
			   Class.forName("com.mysql.cj.jdbc.Driver");

		      //STEP 3: Open a connection
		    //  System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      String se = "select Username,Password from login";
		      stmt = conn.createStatement();
		      ResultSet re = stmt.executeQuery(se);
		      boolean setflag = false;
		      while(re.next())
		      {
		    	String  uname = re.getString("Username");
		    	String  pass=re.getString("Password");
		    	
		    	if(uname.equals(username) && pass.equals(pw))
		    	{
		    		setflag =true;
		    		
		    		
		    	} 
		    	
		    	 /* System.out.println("Username: "+uname);
		    	  System.out.println("Pass: "+pass);*/

		      }
		      
		     if(setflag==true)
		     {
		    	// System.out.println("setflag: "+setflag);
		    	 return true;
		     }else
		     {
		    	 System.out.println("setflag: "+setflag);
		     }
		   //  System.out.println("setflag: "+setflag);
		   }catch(SQLException se){
		      System.out.println("Not connected"); 
		  }catch(Exception  e)
		   {System.out.println("class not found");
		   }   finally {
				   
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
		   
		   return false;
	
	}
	
	
	   }
	
	

