package com.FlightBookingSpringDataJPATransaction.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightBookingSpringDataJPATransaction.demo.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String> {
}
