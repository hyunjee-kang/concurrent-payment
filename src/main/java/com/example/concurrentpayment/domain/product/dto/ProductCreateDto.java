package com.example.concurrentpayment.domain.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCreateDto {
    @NotBlank(message = "상품 이름은 필수입니다.")
    private String name; // 상품 이름

    @NotNull(message = "가격은 필수입니다.")
    @Min(value = 0, message = "가격은 0보다 크거나 같아야 합니다.")
    private Long price; // 상품 가격

    @NotNull(message = "수량은 필수입니다.")
    @Min(value = 0, message = "수량은 0보다 크거나 같아야 합니다.")
    private Long qty; // 상품 수량
}
