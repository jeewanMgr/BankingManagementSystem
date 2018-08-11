package com.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminCustomerDlt {
	private  String cusername;
	private  String cpassword;
	 checkingInsert obj = new checkingInsert();
		Connection conn = obj.getconnection();
		Statement stmt;
		String name ;
		String pw;
		public AdminCustomerDlt(){}
		public AdminCustomerDlt(String username, String password) {
			// TODO Auto-generated constructor stub
			this.cusername = username;
			this.cpassword = password;
		}
		
	public String getCusername() {
			return cusername;
		}

		public String getCpassword() {
			return cpassword;
		}
		
		//getting username and password
		public AdminCustomerDlt getting( int ssn)
		{
			try {
				stmt = conn.createStatement();
				String customer = "SELECT Username, Password FROM newaccount WHERE ssn ='"+ssn+"'";
				ResultSet data = stmt.executeQuery(customer);
				while(data.next())
				{
					cusername = data.getString("Username");
					cpassword = data.getString("Password");
				}
			} catch(Exception e) {}
			AdminCustomerDlt customer = new AdminCustomerDlt(cusername,cpassword);
			
			
			return customer;
			
		}
		
		//deleting the data from the login table
		public  void dltlogin(String username,String password)
		{
			try {
				stmt = conn.createStatement();
				String dletingdata = "delete from login where Username='"+username+"' and Password='"+password+"'";
				stmt.executeUpdate(dletingdata);
			}catch(Exception e){}
		}

		//deleting the ssn number from the database
	public void ssndlt(int ssn)
	{
		try {
			stmt = conn.createStatement();
			String dlt = "delete from ssn where ssn_number='"+ssn+"'";
			stmt.executeUpdate(dlt);
		}catch (Exception e)
		{
			
		}
		
	}
	
	public void cdlt(int ssn)
	{
		try {
			AdminCustomerDlt datas=new AdminCustomerDlt();
			datas = datas.getting(ssn);
			String pw =datas.getCpassword();
			String username = datas.getCusername();
			dltlogin(username,pw);
			
			stmt = conn.createStatement();
			String dlt ="delete from newaccount where ssn='"+ssn+"'";
			String blcdlt ="delete from balance where ssn_number='"+ssn+"'";
			stmt.executeUpdate(dlt);
			stmt.executeUpdate(blcdlt);
			ssndlt( ssn);
			
			
		}catch(Exception e)
		{
			
		}
	}
	
	public static void main(String []args)
	{
		AdminCustomerDlt old = new AdminCustomerDlt();
		old = old.getting(258);
		String name = old.getCusername();
		String pw = old.getCpassword();
		old.dltlogin(name,pw);
		System.out.println("done!!!");
	}

}
