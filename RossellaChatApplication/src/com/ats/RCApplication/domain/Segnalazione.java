package com.ats.RCApplication.domain;

import java.io.Serializable;

public class Segnalazione implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private int idBan;
	private int idBanner;
	private int idBanned;
	private String dateBanString;
	private String userNameBanner;
	private String userNameBanned;
	
	public int getIdBan() {
		return idBan;
	}
	public void setIdBan(int idBan) {
		this.idBan = idBan;
	}
	public int getIdBanner() {
		return idBanner;
	}
	public void setIdBanner(int idBanner) {
		this.idBanner = idBanner;
	}
	public int getIdBanned() {
		return idBanned;
	}
	public void setIdBanned(int idBanned) {
		this.idBanned = idBanned;
	}
	public String getDateBanString() {
		return dateBanString;
	}
	public void setDateBanString(String dateBanString) {
		this.dateBanString = dateBanString;
	}
	
	public Segnalazione(int idBan, int idBanner, int idBanned, String dateBanString) {
		super();
		this.idBan = idBan;
		this.idBanner = idBanner;
		this.idBanned = idBanned;
		this.dateBanString = dateBanString;
		
	}
	public Segnalazione(int idBanner, int idBanned, String dateBanString) {
		super();
		this.idBanner = idBanner;
		this.idBanned = idBanned;
		this.dateBanString = dateBanString;
		
	}
	public String getUserNameBanner() {
		return userNameBanner;
	}
	public void setUserNameBanner(String userNameBanner) {
		this.userNameBanner = userNameBanner;
	}
	public String getUserNameBanned() {
		return userNameBanned;
	}
	public void setUserNameBanned(String userNameBanned) {
		this.userNameBanned = userNameBanned;
	}
	
	
	
	
}
