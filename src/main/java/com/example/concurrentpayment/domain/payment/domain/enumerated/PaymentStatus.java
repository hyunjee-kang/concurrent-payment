package com.example.concurrentpayment.domain.payment.domain.enumerated;

import com.example.concurrentpayment.support.base.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentStatus implements BaseEnum<String> {
    PAYMENT_CONFIRMED("CONFIRMED"), // 결제 완료
    PAYMENT_FAILED("FAILED"),       // 결제 실패
    PAYMENT_PENDING("PENDING"),     // 결제 대기 중
    PAYMENT_EXPIRED("EXPIRED"),     // 결제 만료
    ;

    private final String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    @JsonValue
    public String getValue() {
        return value;
    }
}
