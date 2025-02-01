package com.FlightBookingSpringDataJPATransaction.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.FlightBookingSpringDataJPATransaction.demo.dto.FlightBookingAcknowledgement;
import com.FlightBookingSpringDataJPATransaction.demo.dto.FlightBookingRequest;
import com.FlightBookingSpringDataJPATransaction.demo.entity.PassengerInfo;
import com.FlightBookingSpringDataJPATransaction.demo.entity.PaymentInfo;
import com.FlightBookingSpringDataJPATransaction.demo.exception.InsufficientAmountException;
import com.FlightBookingSpringDataJPATransaction.demo.repository.PassengerInfoRepository;
import com.FlightBookingSpringDataJPATransaction.demo.repository.PaymentInfoRepository;
import com.FlightBookingSpringDataJPATransaction.demo.utils.PaymentUtils;
import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional(rollbackFor = InsufficientAmountException.class)//(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) throws InsufficientAmountException  {

        PassengerInfo passengerInfo = request.getPassengerInfo();
        System.out.println(passengerInfo.getpId()+"-"+passengerInfo.getFare());
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();
      
       PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
      
        
        paymentInfo.setPassengerId(passengerInfo.getpId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);

    }
}