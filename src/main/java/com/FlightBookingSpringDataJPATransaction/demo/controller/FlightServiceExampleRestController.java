package com.FlightBookingSpringDataJPATransaction.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FlightBookingSpringDataJPATransaction.demo.dto.FlightBookingAcknowledgement;
import com.FlightBookingSpringDataJPATransaction.demo.dto.FlightBookingRequest;
import com.FlightBookingSpringDataJPATransaction.demo.exception.InsufficientAmountException;
import com.FlightBookingSpringDataJPATransaction.demo.service.FlightBookingService;

@RestController
@EnableTransactionManagement
public class FlightServiceExampleRestController {

	@Autowired
	private FlightBookingService service;

	// who is creating "request" object ?
	@PostMapping("/bookFlightTicket")
	public ResponseEntity<FlightBookingAcknowledgement> bookFlightTicket(@RequestBody FlightBookingRequest request){
		
		//return service.bookFlightTicket(request);
		
		  try {
	            return ResponseEntity.ok(service.bookFlightTicket(request));
	        } catch (InsufficientAmountException e) {
	            // Create and return a failed response
	            FlightBookingAcknowledgement ack = new FlightBookingAcknowledgement("FAILED", request.getPassengerInfo().getFare(), e.getMessage(), request.getPassengerInfo());
	            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(ack);
	        }
		
	}

	
	
	
}
