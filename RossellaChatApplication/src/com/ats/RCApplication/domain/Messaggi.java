package com.ats.RCApplication.domain;

import java.io.Serializable;
import java.util.Date;

public class Messaggi implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Messaggi(int idSender, int idReceiver, String text, String dateMessString) {
		super();
		this.idSender = idSender;
		this.idReceiver = idReceiver;
		
		this.text = text;
		this.dateMessString = dateMessString;
	}
	public Messaggi(int idSender, int idReceiver, String text) {
		super();
		this.idSender = idSender;
		this.idReceiver = idReceiver;
		this.text = text;
	}
	private int idMessage;
	private int idSender;
	private int idReceiver;
	private String userSender;
	private String userReceiver;
	public String getUserSender() {
		return userSender;
	}
	public void setUserSender(String userSender) {
		this.userSender = userSender;
	}
	public String getUserReceiver() {
		return userReceiver;
	}
	public void setUserReceiver(String userReceiver) {
		this.userReceiver = userReceiver;
	}
	private String text;
	private String dateMessString;
	public Messaggi(int idMessage, int idSender, int idReceiver, String text, String dateMessString) {
		super();
		this.idMessage = idMessage;
		this.idSender = idSender;
		this.idReceiver = idReceiver;
		this.text = text;
		this.dateMessString = dateMessString;
	}
	public String getDateMessString() {
		return dateMessString;
	}
	public void setDateMessString(String dateMessString) {
		this.dateMessString = dateMessString;
	}
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	public Messaggi() {
		
	}
	public Messaggi(int idMessage, int idSender, int idReceiver, String text) {
		super();
		this.idMessage = idMessage;
		this.idSender = idSender;
		this.idReceiver = idReceiver;
		this.text = text;
	}
	public int getIdSender() {
		return idSender;
	}
	public void setIdSender(int idSender) {
		this.idSender = idSender;
	}
	public int getIdReceiver() {
		return idReceiver;
	}
	public void setIdReceiver(int idReceiver) {
		this.idReceiver = idReceiver;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
