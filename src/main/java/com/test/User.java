package com.test;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

	@Id
	private String id;
	private String userid;
	private String fname;
	private String lname;
	
	public User(){}
	
	public User(String userid, String fname, String lname){
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
	}
	
	public String getUserid(){
		return userid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getId(){
		return id;
	}
	@Override
	public String toString(){
		return "userid: " + getUserid(); 
	}
}
