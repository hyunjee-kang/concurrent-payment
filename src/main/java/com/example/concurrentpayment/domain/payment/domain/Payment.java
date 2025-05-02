package com.example.concurrentpayment.domain.payment.domain;

import com.example.concurrentpayment.domain.product.domain.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity                     // JPA가 관리하는 Entity임을 표시
@Table(name = "payment")    // 매핑할 테이블 이름 (생략하면 클래스 이름으로 자동 매핑됨)
@Getter
@Setter                     // Lombok: getter, setter 자동 생성
@NoArgsConstructor          // Lombok: 기본 생성자 자동 생성
@AllArgsConstructor         // Lombok: 전체 필드 생성자 자동 생성
@Builder                    // Lombok: builder 패턴 지원
public class Payment {
    @Id  // 기본 키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // 결제한 사용자 ID

    private Long productId; // 결제한 상품 ID

    private Long amount; // 결제 금액

    @Column(nullable = false)
    private String status; // 결제 상태

    @Column(nullable = false)
    private LocalDateTime requestedAt;

    private LocalDateTime confirmedAt;
}
