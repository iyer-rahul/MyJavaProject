package com.FlightBookingSpringDataJPATransaction.demo.entity;


//import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Table;
//import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;



@Entity
@Table(name = "paymentinfo")
@Access(AccessType.FIELD) // Set access type to FIELD explicitly
public class PaymentInfo {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String paymentid;
    private String accountno;
    private double amount;
    private String cardtype;
    private Long passengerid;
    
	public PaymentInfo() {}
	
	public PaymentInfo(String paymentId, String accountNo, double amount, String cardType, Long passengerId) {
	
		this.paymentid = paymentId;
		this.accountno = accountNo;
		this.amount = amount;
		this.cardtype = cardType;
		this.passengerid = passengerId;
	}

	public String getPaymentId() {
		return paymentid;
	}
	public void setPaymentId(String paymentId) {
		this.paymentid = paymentId;
	}
	public String getAccountNo() {
		return accountno;
	}
	public void setAccountNo(String accountNo) {
		this.accountno = accountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCardType() {
		return cardtype;
	}
	public void setCardType(String cardType) {
		this.cardtype = cardType;
	}
	public Long getPassengerId() {
		return passengerid;
	}
	public void setPassengerId(Long passengerId) {
		this.passengerid = passengerId;
	}
    
}
