package com.example.concurrentpayment.domain.payment.repository;

import com.example.concurrentpayment.domain.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // 결제 요청 단건 조회
    Optional<Payment> findById(Long id);
    // 결제 요청 저장
    Payment save(Payment payment);
    // 결제 요청 삭제
    void deleteById(Long id);
}
