package com.example.concurrentpayment.domain.payment.domain.mapper;

import com.example.concurrentpayment.domain.payment.domain.Payment;
import com.example.concurrentpayment.domain.payment.dto.PaymentCreateDto;
import com.example.concurrentpayment.domain.payment.dto.PaymentDto;
import com.example.concurrentpayment.support.base.BaseMapper;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface PaymentMapper extends BaseMapper<PaymentDto, Payment> {
    Payment toEntity(PaymentCreateDto dto); // 별도 매핑 추가 가능
}

