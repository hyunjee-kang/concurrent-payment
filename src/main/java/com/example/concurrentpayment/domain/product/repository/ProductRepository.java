package com.example.concurrentpayment.domain.product.repository;

import com.example.concurrentpayment.domain.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // 상품 정보 조회
    Optional<Product> findById(Long id);
    // 상품 정보 저장
    Product save(Product product);
    // 상품 정보 삭제
    void deleteById(Long id);
}
