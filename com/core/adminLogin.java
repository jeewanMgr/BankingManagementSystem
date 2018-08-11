package com.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class adminLogin {
	  Statement stmt;
	 checkingInsert obj = new checkingInsert();
	Connection conn = obj.getconnection();

	public boolean login(String uname , String pw)
	{
		try {
			stmt = conn.createStatement();
			String sql = "select username, password from adminlogin";
			ResultSet result = stmt.executeQuery(sql);
			while(result.next())
			{
				String jname = result.getString("username");
				String jpw = result.getString("password");
				if(uname.equals(jname) && pw.equals(jpw));
				{
					return true;
				}
			}
		}catch(Exception e)
		{
			
		}
		return false;
	}
}
