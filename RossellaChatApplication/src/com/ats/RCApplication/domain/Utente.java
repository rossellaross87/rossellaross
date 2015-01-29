package com.ats.RCApplication.domain;

import java.io.Serializable;

public class Utente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Utente(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	private Integer id;
	private String userName;
	private String password;
	private boolean isAdmin;
	private boolean isBanned;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Utente() {

	}

	public Utente(Integer id, String userName, String password, boolean isAdmin, boolean isBanned) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isBanned = isBanned;
	}

	public String getUserName() {
		return userName;
	}

	public Utente(String userName, String password, boolean isAdmin, boolean isBanned) {
		super();
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isBanned = isBanned;
		
	}



	

	public Utente(int id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	

	public Utente(String userName) {
		this.userName=userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isBanned() {
		return isBanned;
	}

	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}

}
