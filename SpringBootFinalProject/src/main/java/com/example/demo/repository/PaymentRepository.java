package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Custom queries if needed can be added here
	Payment findByBillId(Long billId );
}
