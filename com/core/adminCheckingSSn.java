package com.core;

import java.sql.*;

import javax.swing.JOptionPane;
public class adminCheckingSSn {
	
	 checkingInsert obj = new checkingInsert();
		Connection conn = obj.getconnection();
		Statement stmt;
	
	public boolean ssnChecking(int ssn)
	{
		try {
			stmt = conn.createStatement();
			String numberSSN = "select ssn_number from ssn";
			
			ResultSet SSN = stmt.executeQuery(numberSSN);
			while(SSN.next())
			{
				int data = SSN.getInt("ssn_number");
				if(data == ssn)
				{
					return true;
				} 
			}
			
		}catch(Exception e)
		{
			
		}
		return false;
	}
	
	public void insertSSn(int ssn)
	{
		try {
			stmt = conn.createStatement();
			String insert = "INSERT INTO ssn(ssn_number)"
					+ "values('"+ssn+"')";
			stmt.executeUpdate(insert);
		}catch(Exception e)
		{
			
		}
	}
	
	private boolean checkingAdmincreate(String username,String password)
	{
		if(username.isEmpty() == true || password.isEmpty()== true)
		{
			return true;
		}
		return false;
	}
	
	private void create(String username, String password)
	{
		Statement stmt;
		checkingInsert obj = new checkingInsert();
		Connection conn = obj.getconnection();
		try {
			stmt = conn.createStatement();
			String inserted ="insert into adminlogin(username, password) values('"+username+"','"+password+"')";
			stmt.executeUpdate(inserted);
			
		}catch (Exception e)
		{
			
		}
	}
	
	public void AdminAccount(String username, String password)
	{
		if(checkingAdmincreate(username,password)== true)
		{
			JOptionPane.showMessageDialog(null, "MISSING USERNAME AND PASSWORD", "ERROR!!!",JOptionPane.ERROR_MESSAGE);
		} 
		
		
		//	int dialogButton = JOptionPane.YES_NO_OPTION;
			/*int yes = JOptionPane.YES_OPTION;
			int no = JOptionPane.NO_OPTION;*/
			int what =JOptionPane.showConfirmDialog(null, "Everthing is good");
			// 0(zero)=yess,  1 = no, and 2=cancel
			if(what == 0)
			{
				create(username,password);
				JOptionPane.showMessageDialog(null, "YOU CREATE YOUR ACCOUNT", "SUCESS!!!!!!!!!", JOptionPane.CLOSED_OPTION);
			} 
			if(what == 2 || what ==1)
				JOptionPane.showMessageDialog(null, "You cancel to create account", "CANCELL!!!!", JOptionPane.CLOSED_OPTION);
			} 

}
