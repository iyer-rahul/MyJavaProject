package com.FlightBookingSpringDataJPATransaction.demo.exception;

public class InsufficientAmountException extends RuntimeException {

    public InsufficientAmountException(String msg){
        super(msg);
    }
}
