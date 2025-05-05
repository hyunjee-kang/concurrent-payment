package com.example.concurrentpayment.domain.product.usecase;

import com.example.concurrentpayment.domain.product.dto.ProductCreateDto;
import com.example.concurrentpayment.domain.product.dto.ProductDto;
import com.example.concurrentpayment.domain.product.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductUsecaseImpl implements ProductUsecase {

    final ProductRepository productRepository;

    public ProductUsecaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 상품 정보 조회
    @Override
    public ProductDto getProductById(Long id) {
        // 상품 정보 조회 로직 구현
        return null;
    }

    // 상품 정보 저장
    @Override
    public ProductDto createProduct(ProductCreateDto productDto) {
        // 상품 정보 저장 로직 구현
        return null;
    }

    // 상품 목록 조회
    @Override
    public Page<ProductDto> getProducts(Pageable pageable) {
        // 상품 목록 조회 로직 구현
        return null;
    }
}
