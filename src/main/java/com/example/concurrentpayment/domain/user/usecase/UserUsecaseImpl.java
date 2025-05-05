package com.example.concurrentpayment.domain.user.usecase;

import com.example.concurrentpayment.domain.user.dto.UserCreateDto;
import com.example.concurrentpayment.domain.user.dto.UserLoginDto;
import com.example.concurrentpayment.domain.user.dto.UserLogoutDto;
import com.example.concurrentpayment.domain.user.repository.UserRepository;

public class UserUsecaseImpl implements UserUsecase {

    private final UserRepository userRepository;

    public UserUsecaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserLoginDto.Response login(UserLoginDto.Request loginDto) {
        return null;
    }

    // 사용자 로그아웃
    @Override
    public void logout(UserLogoutDto logoutDto) {
        // 로그아웃 로직 구현
    }

    // 사용자 등록
    @Override
    public void register(UserCreateDto userDto) {
        // 사용자 등록 로직 구현
    }
}
