package com.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class allchecking {
	private String username;
	private String pass;
	private String fullname;
	private int ssn;
	private String address;
	
	public allchecking()
	{
		username = null;
		pass=null;
		fullname=null;
		address=null;
		
	}
	
   public allchecking(String username,String pass,String fullname,int ssn,String address)
    {
    	this.username=username;
    	this.pass=pass;
    	this.fullname=fullname;
    	this.ssn=ssn;
    	this.address=address;
    }
    
	public boolean fieldchecking()
	{
		
		if(username==" " || username == null || pass==" "  || pass== "")
			return false;
		else if(fullname=="" || fullname == null || ssn != (int)ssn || address==" " || address==null)
			return false;
		else 
			return true;
		
	}
		
 public boolean Numberchecking(String ssn)
 { 
	 return toString().matches("^\\d+$");
 }
 
   public boolean SSNchecking(String number)
   {
	   checkingInsert conn = new checkingInsert();
	   Connection join = conn.getconnection();
	   Statement stmt ;
	   try {
	   stmt = join.createStatement();
	   String ssn = "SELECT ssn_number FROM ssn";
	  ResultSet rs = stmt.executeQuery(ssn);
	  
	  while(rs.next())
	  {
		  String numberdata =(String) rs.getString("ssn_number");
		  if(numberdata.equals(number))
		  {
			  //System.out.println(numberdata);
			 // System.out.println("ssn number is match");
			  break;
		  } else {
			  return false;
		  }
		 
		  
	  }
	   
		   return true;
	   }
	   catch (Exception ex){
		   
	   }
	   
	   return false;
   }

}
