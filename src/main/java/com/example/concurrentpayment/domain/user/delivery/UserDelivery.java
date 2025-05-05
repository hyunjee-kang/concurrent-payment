package com.example.concurrentpayment.domain.user.delivery;

import com.example.concurrentpayment.domain.user.dto.UserCreateDto;
import com.example.concurrentpayment.domain.user.dto.UserLoginDto;
import com.example.concurrentpayment.domain.user.dto.UserLogoutDto;
import com.example.concurrentpayment.domain.user.usecase.UserUsecase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/apis/v1/users")
@Tag(name = "users", description = "users api")
public class UserDelivery {
    private final UserUsecase userUsecase;

    public UserDelivery(UserUsecase userUsecase) {
        this.userUsecase = userUsecase;
    }

    // 유저 등록 API
    @Operation(
            summary = "user sign up",
            description = "유저 등록 API",
            tags = {"users"}
            )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "user signup successfully"),
                    @ApiResponse(responseCode = "400", description = "invalid input value")
            }
    )
    @PostMapping
    public void createUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        userUsecase.register(userCreateDto);
    }


    // 유저 로그인 API
    @Operation(
            summary = "login",
            description = "유저 로그인 API",
            tags = {"users"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "user login successfully",
                            content = @Content(schema = @Schema(implementation = UserLoginDto.Response.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "invalid input value")
            }
    )
    @PostMapping
    public UserLoginDto.Response createPayment(@Valid @RequestBody UserLoginDto.Request loginDto) {
        return userUsecase.login(loginDto);
    }


    // 유저 로그아웃 API
    @Operation(
            summary = "logout",
            description = "유저 로그아웃 API",
            tags = {"users"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "create payment successfully"),
                    @ApiResponse(responseCode = "400", description = "invalid input value")
            }
    )
    @PostMapping
    public void createPayment(@Valid @RequestBody UserLogoutDto logoutDto) {
        userUsecase.logout(logoutDto);
    }
}
