package com.core;

public class NewAccountCreate {
	
	private String username;
	private String pass;
	private String fullname;
	private int ssn;
	private String address;
	
	NewAccountCreate(String uname,String pass,String fname,int ssn,String address)
	{
		this.username=uname;
		this.pass=pass;
		this.fullname = fname;
		this.ssn=ssn;
		this.address=address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	 
	
	
}
