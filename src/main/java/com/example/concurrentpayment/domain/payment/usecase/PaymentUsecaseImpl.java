package com.example.concurrentpayment.domain.payment.usecase;

import com.example.concurrentpayment.domain.payment.domain.enumerated.PaymentStatus;
import com.example.concurrentpayment.domain.payment.dto.PaymentCreateDto;
import com.example.concurrentpayment.domain.payment.dto.PaymentDto;
import com.example.concurrentpayment.domain.payment.repository.PaymentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentUsecaseImpl implements PaymentUsecase {
    private final PaymentRepository paymentRepository;

    public PaymentUsecaseImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentDto createPayment(PaymentCreateDto paymentCreateDto) {
        return null;
    }

    @Override
    public PaymentDto getPaymentById(Long id) {
        return null;
    }

    @Override
    public Page<PaymentDto> getPayments(PaymentStatus status, Pageable pageable) {
        return null;
    }
}
