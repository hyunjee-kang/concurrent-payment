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
public class UserDto {
    private Long id; // 사용자 ID

    private String email; // 이메일

    private String name; // 이름

    private Long balance; // 잔액

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private String createdAt; // 생성일시

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private String updatedAt; // 수정일시
}
