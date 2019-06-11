package service;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement
public class Account implements Serializable{
	private int code;
	private double balance;
	private Date DateCreation;
	public Account(int code, double balance, Date dateCreation) {
		super();
		this.code = code;
		this.balance = balance;
		DateCreation = dateCreation;
	}
	public Account() {
		super();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@XmlTransient
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
}
