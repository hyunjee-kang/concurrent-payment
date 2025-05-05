package com.example.concurrentpayment.domain.payment.usecase;

import com.example.concurrentpayment.domain.payment.domain.enumerated.PaymentStatus;
import com.example.concurrentpayment.domain.payment.dto.PaymentCreateDto;
import com.example.concurrentpayment.domain.payment.dto.PaymentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentUsecase {
    // 결제 요청
    PaymentDto createPayment(PaymentCreateDto paymentCreateDto);
    // 결제 요청 단건 조회
    PaymentDto getPaymentById(Long id);
    // 결제 요청 목록 조회
    Page<PaymentDto> getPayments(PaymentStatus status, Pageable pageable);
}