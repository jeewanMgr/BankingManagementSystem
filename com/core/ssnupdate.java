package com.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class ssnupdate {
	
	Statement stmt;
	checkingInsert obj = new checkingInsert();
	Connection conn = obj.getconnection();
	
	boolean flage;
	public boolean ssnupdatehere()
	{
		try{
			stmt = conn.createStatement();
			String upd = "select flag from ssn ";
			ResultSet here = stmt.executeQuery(upd);
			while(here.next())
				flage = here.getBoolean("flag");
			    if(flage == true)
			    {
			    	return false;
			    }
			return true;
		}catch(Exception e)
		{
			
		}
		return false;
		
	}

}
