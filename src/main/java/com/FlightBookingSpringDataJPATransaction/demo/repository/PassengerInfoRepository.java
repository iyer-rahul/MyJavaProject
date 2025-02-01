package com.FlightBookingSpringDataJPATransaction.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightBookingSpringDataJPATransaction.demo.entity.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {
}
