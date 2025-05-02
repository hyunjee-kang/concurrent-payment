package com.example.concurrentpayment.domain.payment.domain.enumerated;

import com.example.concurrentpayment.support.enumerated.BaseEnumConverter;

import java.util.Arrays;

public class PaymentStatusConverter extends BaseEnumConverter<PaymentStatus, String> {
    @Override
    protected PaymentStatus[] getValueList() {
        return PaymentStatus.values();
    }

    @Override
    public PaymentStatus convertToEntityAttribute(String dbData) {
        return Arrays.stream(PaymentStatus.values())
                .filter(paymentStatus -> paymentStatus.getValue().equals(dbData))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid payment status.") //TODO: 에러 재정의 필요
                );
    }
}