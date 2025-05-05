package com.example.concurrentpayment.domain.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "users")
public class UserLoginDto {
    @Schema(description = "로그인 요청 DTO")
    @Data
    @AllArgsConstructor
    @Builder
    public static class Request {
        private String email;    // 이메일
        private String password; // 비밀번호
    }

    @Schema(description = "로그인 응답 DTO")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private String accessToken; // 액세스 토큰
        private String refreshToken; // 리프레시 토큰
    }
}
