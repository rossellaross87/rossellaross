package com.ats.RCApplication.domain;

import java.io.Serializable;

public class Utenti implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Utenti(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	private Integer id;
	private String userName;
	private String password;
	private boolean isAdmin;
	private boolean isBanned;
	private String comments;
	private Integer adminOrNot;
	private Integer nrSegnalazioni;

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Utenti() {

	}

	public Utenti(Integer id, String userName, String password, boolean isAdmin, boolean isBanned) {
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

	public Utenti(String userName, String password, boolean isAdmin, boolean isBanned, String comments) {
		super();
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isBanned = isBanned;
		this.comments = comments;
	}

	public Utenti(Integer id, String userName, String password, boolean isAdmin, boolean isBanned, String comments) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isBanned = isBanned;
		this.comments = comments;
	}

	public Utenti(Integer id, String userName, String password, Integer adminOrNot, Integer nrSegnalazioni, String comments) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.adminOrNot = adminOrNot;
		this.comments = comments;

	}

	public Utenti(int id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public Integer getAdminOrNot() {
		return adminOrNot;
	}

	public void setAdminOrNot(Integer adminOrNot) {
		this.adminOrNot = adminOrNot;
	}

	public Integer getNrSegnalazioni() {
		return nrSegnalazioni;
	}

	public void setNrSegnalazioni(Integer nrSegnalazioni) {
		this.nrSegnalazioni = nrSegnalazioni;
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
