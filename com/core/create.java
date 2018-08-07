package com.core;

import java.sql.*;

import javax.swing.JOptionPane;
public class create {
	
	// JDBC driver name and database URL
		  // static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   static final String DB_URL = "jdbc:mysql://localhost/bms";
		   static final String USER = "root";
		   static final String PASS = "";
		   public  Connection conn = null;
		   public    Statement stmt=null;
		   
		
		public int insert(String uname,String pass,String fname,int ssn,String address) 
		{
				Connection conn = null;
			   Statement stmt=null;
			   try{
			      //STEP 2: Register JDBC driver
				   Class.forName("com.mysql.cj.jdbc.Driver");
				   
				        NewAccountCreate obj = new NewAccountCreate(uname,pass,fname,ssn,address);
				        String username = obj.getUsername();
				        String pw = obj.getPass();
				        String fullname = obj.getFullname();
				        int socialnumber = obj.getSsn();
				      //  String socialnum =String.valueOf(obj.getSsn());
				        String addr = obj.getAddress();
        		
			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			      
			      stmt = conn.createStatement();
			     // stmts = conn.createStatement();
			      String update ="UPDATE ssn set flag=1 where ssn_number= '"+socialnumber+"'";
				    
			     String valueInsert = "INSERT INTO login(Username,Password)  VALUES('"+username+"','"+pw+"')";
			   //  stmt.executeQuery(valueInsert);
			     String value2 = "INSERT INTO newaccount VALUES('"+username+"','"+pw+"','"+fullname+"','"+socialnumber+"','"+addr+"')";
			 
			     String checking ="select ssn_number from ssn where ssn_number='"+socialnumber+"'";
			     
			      ResultSet m = stmt.executeQuery(checking);
			    		  if(m.next())
			    		  {
			    			  int socailnumber = m.getInt("ssn_number");
			    			  if(socailnumber == socialnumber)
			    			  {
			    				  stmt.executeUpdate(valueInsert);
			                      stmt.executeUpdate(value2);
			                      stmt.executeUpdate(update);
			    			  }
			    		  } else {
			    			  JOptionPane.showMessageDialog(null,"Socail number could not found could you asked "+
			    		  " with the admin for the socal security number Thank you");
			    		  }
			      
			       
                   
                
			      
			   
			   }catch(SQLException se){
			      System.out.println("Not connected");
			  }catch(Exception  e)
			   {System.out.println("class not found");
			   }
				   
			   
			   finally {
				   
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
			   return 0;
			   }
		}


