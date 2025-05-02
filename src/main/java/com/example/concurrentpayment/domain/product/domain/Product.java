package com.example.concurrentpayment.domain.product.domain;

import com.example.concurrentpayment.support.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment")    // 매핑할 테이블 이름 (생략하면 클래스 이름으로 자동 매핑됨)
@Getter
@Setter                     // Lombok: getter, setter 자동 생성
@NoArgsConstructor          // Lombok: 기본 생성자 자동 생성
@AllArgsConstructor         // Lombok: 전체 필드 생성자 자동 생성
@Builder                    // Lombok: builder 패턴 지원
public class Product extends BaseTimeEntity {
    @Id  // 기본 키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long qty = 0L;

    @Column(nullable = false)
    private Long amount = 0L;
}
