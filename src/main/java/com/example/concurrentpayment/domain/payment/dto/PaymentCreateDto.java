package com.example.concurrentpayment.domain.payment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentCreateDto {
    private Long userId; // 결제한 사용자 ID
    private Long productId; // 결제한 상품 ID
    private Long amount; // 결제 금액
}
