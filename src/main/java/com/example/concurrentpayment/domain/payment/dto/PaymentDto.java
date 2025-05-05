package com.example.concurrentpayment.domain.payment.dto;

import com.example.concurrentpayment.domain.payment.domain.enumerated.PaymentStatusConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Convert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(description = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
    private Long id;

    private Long userId; // 결제한 사용자 ID

    private Long productId; // 결제한 상품 ID

    private Long amount; // 결제 금액

    @Convert(converter = PaymentStatusConverter.class)
    private String status; // 결제 상태

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime requestedAt;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime confirmedAt;
}
