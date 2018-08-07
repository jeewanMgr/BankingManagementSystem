package com.core;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class jAccount {
	static  Statement stmt;
	static checkingInsert obj = new checkingInsert();
static	Connection conn = obj.getconnection();

   public void amountgetting(String username, String pw,float money)
	 {
		 new dataPlaying();
		float amount = dataPlaying.ssnanother(username, pw);
		 if(amount<=0 || amount<money)
		 {
			JOptionPane.showMessageDialog(null, "You don't have enoug balance");
		 } else {
			 
			  amount = amount - money;
			  try {
			  stmt = conn.createStatement();
			  String amtupdate = "Update balance set balance='"+amount+"'";
			  stmt.executeUpdate(amtupdate);
			  JOptionPane.showMessageDialog(null, "you take out: "+money);
			  }catch(Exception e)
			  {  
			  }
		 }
		 
	 }
   
   
   public void deposite(float amount,String uname,String pw)
   {
	   float money = dataPlaying.ssnanother(uname, pw);
	  float money1 = amount+money;
	   try {
		   stmt = conn.createStatement();
			  String amtupdate = "Update balance set balance='"+money1+"'";
			  stmt.executeUpdate(amtupdate);
			  JOptionPane.showMessageDialog(null, "you add: "+amount);
	   }catch(Exception e)
		  { 
   }
}
}
