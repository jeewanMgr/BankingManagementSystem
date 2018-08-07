package com.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class dataPlaying {
	static  Statement stmt;
		static checkingInsert obj = new checkingInsert();
	static	Connection conn = obj.getconnection();
	public static String username;
	public static String password;
	 
	 public static  int ssnNumber(String username,String password)
	  {
		
			//Account data = new Account();
			
			/*System.out.println("doing");
			System.out.println(username);
			System.out.println(password);
			System.out.println("done");
			*/
			int number;
			    
			try {
				stmt = conn.createStatement();
				   String account = "select ssn from newaccount where Username='"+username+"' "
				   		+ "AND Password='"+password+"'";
				   
				   ResultSet ssnace=stmt.executeQuery(account); 
				   
				   while(ssnace.next()){
					   
					    number = ssnace.getInt("ssn");
					
					   // System.out.println("You ssn number is : "+number);
					    return number;
					  
				   }				   
			}catch (Exception ex)
			{
				System.out.println("You dont have a balance");
			}
			
			return 0;
	  }
	 
	public static float ssnanother(String username,String password )
	{
		try {
		   
		String balance = "SELECT ssn_number, balance FROM balance where ssn_number='"+dataPlaying.ssnNumber(username,password)+"'";
		ResultSet blc =stmt.executeQuery(balance);
		int firstnum = ssnNumber(username,password);
		while(blc.next())
		{
		  //  float money = blc.getFloat("balance");
		    int ssnumber= blc.getInt("ssn_number");
		    if(firstnum == ssnumber)
		    {
		    	float money = blc.getFloat("balance");
		    	 return money;
		    }
		  
		}
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error!!!!!!!!!");
		} 
		return 0;
	}
	
	
	
	}


