package com.shadab.spring.cache.ehcache.model;

import java.io.Serializable;

public class Student implements Serializable{
	
	  String name;
	  String rollNumber;
	  String address;
	
	public Student(String name, String rollNumber, String address) {
 		this.name = name;
		this.rollNumber = rollNumber;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNumber=" + rollNumber + ", address=" + address + "]";
	}
}
