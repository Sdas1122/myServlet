package com;

public class Student {
	
	String sid,sname,address;

	public Student(String sid, String sname, String address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.address = address;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
