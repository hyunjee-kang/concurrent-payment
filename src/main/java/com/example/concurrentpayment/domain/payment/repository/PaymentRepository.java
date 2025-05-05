package com.example.concurrentpayment.domain.payment.repository;

import com.example.concurrentpayment.domain.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
