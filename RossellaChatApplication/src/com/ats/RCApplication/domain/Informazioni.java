package com.ats.RCApplication.domain;

import java.io.Serializable;

public class Informazioni implements Serializable{
	/**
	 * 
	 */
	
	
    
	private static final long serialVersionUID = 1L;
	public Informazioni(String name, String lastName, String city, String sex,
			String country, Double height, String look, String relationship,
			String education, String job, String hobbies, Integer age) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.city = city;
		this.sex = sex;
		this.country = country;
		this.height = height;
		this.look = look;
		this.relationship = relationship;
		this.education = education;
		this.job = job;
		this.hobbies = hobbies;
		this.age = age;
	}
	public Informazioni(String name, String lastName, String city, String sex,
			String country, Double height, String look, String relationship,
			String education, String job, String hobbies, Integer idUser, Integer age) {
		
		this.name = name;
		this.lastName = lastName;
		this.city = city;
		this.sex = sex;
		this.country = country;
		this.height = height;
		this.look = look;
		this.relationship = relationship;
		this.education = education;
		this.job = job;
		this.hobbies = hobbies;
		this.idUser = idUser;
		this.age = age;
	}
	private Integer idInfo;
	private String name;
	private String lastName;
	private String city;
	private String sex;
	private String country;
	private Double height;
	private String look;
	private String relationship;
	private String education;
	private String job;
	private String hobbies;
	private Integer idUser;
	public Informazioni() {
		
	}
	public Informazioni(Integer idInfo, String name, String lastName, String city,
			String sex, String country, Double height, String look,
			String relationship, String education, String job, String hobbies,
			Integer idUser, Integer age) {
		
		this.idInfo = idInfo;
		this.name = name;
		this.lastName = lastName;
		this.city = city;
		this.sex = sex;
		this.country = country;
		this.height = height;
		this.look = look;
		this.relationship = relationship;
		this.education = education;
		this.job = job;
		this.hobbies = hobbies;
		this.idUser = idUser;
		this.age = age;
	}
	//METTO INTEGER PERCHE' IL VALORE PUO' ESSERE NULL PERCHE' INT NON PUO' ESSERE NULL
	private Integer age;
	public Integer getIdInfo() {
		return idInfo;
	}
	public void setIdInfo(Integer idInfo) {
		this.idInfo = idInfo;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public String getLook() {
		return look;
	}
	public void setLook(String look) {
		this.look = look;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

}
