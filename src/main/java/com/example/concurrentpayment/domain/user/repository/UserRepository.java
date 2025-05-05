package com.example.concurrentpayment.domain.user.repository;

import com.example.concurrentpayment.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 사용자 정보 조회
    Optional<User> findById(Long id);
    // 사용자 정보 저장
    User save(User user);
    // 사용자 정보 삭제
    void deleteById(Long id);
}
