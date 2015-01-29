package com.ats.rossellaBiblioteca.domain;

import java.util.Date;

public class Author {
	private int id;
	private String name;
	private String lastName;
	private Date birhDate;
	private String sex;
	private String phoneNumber;
	public Author(int id, String name, String lastName, Date birhDate,
			String sex, String phoneNumber, String address) {
		
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birhDate = birhDate;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirhDate() {
		return birhDate;
	}
	public void setBirhDate(Date birhDate) {
		this.birhDate = birhDate;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
