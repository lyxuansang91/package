package com.sms.sender;

public class SMSObject {
	private String phoneNumber; 
	private String messageSMS;
	
	
	
	/**
	 * 
	 */
	public SMSObject() {
		super();
	}
	@Override
	public String toString() {
		return this.phoneNumber + " " + this.getMessageSMS();
	}
	/**
	 * @param phoneNumber
	 */
	public SMSObject(String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @param phoneNumber
	 * @param messageSMS
	 */
	public SMSObject(String phoneNumber, String messageSMS) {
		super();
		this.phoneNumber = phoneNumber;
		this.messageSMS = messageSMS;
	}
	/**
	 * @return the messageSMS
	 */
	public String getMessageSMS() {
		return messageSMS;
	}
	/**
	 * @param messageSMS the messageSMS to set
	 */
	public void setMessageSMS(String messageSMS) {
		this.messageSMS = messageSMS;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	} 
}
