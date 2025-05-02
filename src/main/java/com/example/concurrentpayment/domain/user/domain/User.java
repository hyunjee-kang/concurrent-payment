package com.example.concurrentpayment.domain.user.domain;

import com.example.concurrentpayment.support.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity                     // JPA가 관리하는 Entity임을 표시
@Table(name = "user")       // 매핑할 테이블 이름 (생략하면 클래스 이름으로 자동 매핑됨)
@Getter
@Setter                     // Lombok: getter, setter 자동 생성
@NoArgsConstructor          // Lombok: 기본 생성자 자동 생성
@AllArgsConstructor         // Lombok: 전체 필드 생성자 자동 생성
@Builder                    // Lombok: builder 패턴 지원
public class User extends BaseTimeEntity {

    @Id  // 기본 키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long balance = 0L; // 잔액 (User 도메인에 안맞지만 간단한 개발을 위해 이곳에 추가함)
}


