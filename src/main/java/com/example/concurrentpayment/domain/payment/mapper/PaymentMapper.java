package com.example.concurrentpayment.domain.payment.mapper;

import com.example.concurrentpayment.domain.payment.domain.Payment;
import com.example.concurrentpayment.domain.payment.dto.PaymentCreateDto;
import com.example.concurrentpayment.domain.payment.dto.PaymentDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PaymentDto toDto(Payment payment);



    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Payment toEntity(PaymentDto dto);

    List<PaymentCreateDto> toDtoList(List<Payment> payments);
}

