package com.example.concurrentpayment.support.base;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass // 이 클래스의 필드들을 자식 엔티티의 컬럼으로 포함시킴
@Getter
public abstract class BaseTimeEntity {

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() { // insert 전에 생성·수정 시간 세팅.
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() { // update 전에 수정 시간 세팅.
        this.updatedAt = LocalDateTime.now();
    }
}


/*

    [abstract 로 선언한 이유]
    @MappedSuperclass는 이 클래스 자체를 테이블로 매핑하지 않고, 자식 엔티티의 공통 매핑 정보만 제공하는 용도

    따라서 BaseEntity 자체는 new BaseEntity()로 인스턴스를 만들어 사용할 일이 없다
    그냥 상속용 설계니까 추상화(abstract)로 만들어 “이건 혼자 쓰는 클래스가 아님”을 명시적으로 표현

*/