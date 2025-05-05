package com.example.concurrentpayment.domain.product.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(description = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id; // 상품 ID

    private String name; // 상품 이름

    private Long price; // 상품 가격

    private Long qty; // 상품 수량

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt; // 생성일시

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedAt; // 수정일시
}
