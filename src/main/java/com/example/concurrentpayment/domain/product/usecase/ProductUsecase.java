package com.example.concurrentpayment.domain.product.usecase;

import com.example.concurrentpayment.domain.product.dto.ProductCreateDto;
import com.example.concurrentpayment.domain.product.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductUsecase {
    // 상품 정보 조회
    ProductDto getProductById(Long id);

    // 상품 정보 저장
    ProductDto createProduct(ProductCreateDto productDto);

    // 상품 목록 조회
    Page<ProductDto> getProducts(Pageable pageable);
}
