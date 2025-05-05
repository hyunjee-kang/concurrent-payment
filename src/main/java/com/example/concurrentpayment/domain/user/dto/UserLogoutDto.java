package com.example.concurrentpayment.domain.user.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLogoutDto {
    private String email; // 이메일
}