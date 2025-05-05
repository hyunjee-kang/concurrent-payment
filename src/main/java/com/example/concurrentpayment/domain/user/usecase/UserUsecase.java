package com.example.concurrentpayment.domain.user.usecase;

import com.example.concurrentpayment.domain.user.dto.UserCreateDto;
import com.example.concurrentpayment.domain.user.dto.UserLoginDto;
import com.example.concurrentpayment.domain.user.dto.UserLogoutDto;

public interface UserUsecase {
    // 사용자 로그인
    UserLoginDto.Response login(UserLoginDto.Request loginDto);

    // 사용자 로그아웃
    void logout(UserLogoutDto logoutDto);

    // 사용자 등록
    void register(UserCreateDto user);
}
