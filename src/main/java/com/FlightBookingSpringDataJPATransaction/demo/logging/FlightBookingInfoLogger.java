package com.FlightBookingSpringDataJPATransaction.demo.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.FlightBookingSpringDataJPATransaction.demo.dto.FlightBookingRequest;

@Aspect
@Component
public class FlightBookingInfoLogger {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightBookingInfoLogger.class);
	@Before("execution(public * com.FlightBookingSpringDataJPATransaction.demo.controller.FlightServiceExampleRestController.bookFlightTicket(..))")
	public void log() {
	//System.out.println("ticket booking logged");
		
		LOGGER.info("ticket booking logged");
	}

}
