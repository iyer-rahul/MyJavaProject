package com.FlightBookingSpringDataJPATransaction.demo.entity;



import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor

@Entity
@Table(name = "passengerinfo")
@Access(AccessType.FIELD) // Set access type to FIELD explicitly
public class PassengerInfo {
    @Id
    @GeneratedValue
    @Column(name = "passengerid")
    private Long pid;
    private String name;
    private String email;
    private String source;
    private String destination;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date traveldate;
    private String pickuptime;
    private String arrivaltime;
    private double fare;
    
	public PassengerInfo() {}
	
	public PassengerInfo(Long pId, String name, String email, String source, String destination, Date travelDate,
			String pickupTime, String arrivalTime, double fare) {
		super();
		this.pid = pId;
		this.name = name;
		this.email = email;
		this.source = source;
		this.destination = destination;
		this.traveldate = travelDate;
		this.pickuptime = pickupTime;
		this.arrivaltime = arrivalTime;
		this.fare = fare;
	}

	public Long getpId() {
		return pid;
	}
	public void setpId(Long pId) {
		this.pid = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getTravelDate() {
		return traveldate;
	}
	public void setTravelDate(Date travelDate) {
		this.traveldate = travelDate;
	}
	public String getPickupTime() {
		return pickuptime;
	}
	public void setPickupTime(String pickupTime) {
		this.pickuptime = pickupTime;
	}
	public String getArrivalTime() {
		return arrivaltime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivaltime = arrivalTime;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
    
}
