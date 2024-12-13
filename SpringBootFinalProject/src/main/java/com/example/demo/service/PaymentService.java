package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Payment;

public interface PaymentService {
    List<Payment> getAllPayments();
    Optional<Payment> getPaymentById(Long payId);
    Payment savePayment(Payment payment);
    void deletePayment(Long payId);
}
