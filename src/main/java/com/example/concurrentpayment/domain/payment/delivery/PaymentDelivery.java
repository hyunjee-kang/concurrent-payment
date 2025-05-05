package com.example.concurrentpayment.domain.payment.delivery;

import com.example.concurrentpayment.domain.payment.domain.enumerated.PaymentStatus;
import com.example.concurrentpayment.domain.payment.dto.PaymentCreateDto;
import com.example.concurrentpayment.domain.payment.dto.PaymentDto;
import com.example.concurrentpayment.domain.payment.usecase.PaymentUsecase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/apis/v1/payments")
@Tag(name = "payments", description = "payments api")
public class PaymentDelivery {
    private final PaymentUsecase paymentUsecase;

    public PaymentDelivery(PaymentUsecase paymentUsecase) {
        this.paymentUsecase = paymentUsecase;
    }

    // 결제 요청 API
    @Operation(
            summary = "create payment",
            description = "결제 요청",
            tags = {"payments"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "create payment successfully",
                            content = @Content(schema = @Schema(implementation = PaymentDto.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "invalid input value")
            }
    )
    @PostMapping
    public PaymentDto createPayment(@Valid @RequestBody PaymentCreateDto paymentDto) {
        return paymentUsecase.createPayment(paymentDto);
    }


    // 결제 요청 단건 조회 API
    @Operation(
            summary = "get payment by id",
            description = "ID 로 결제 요청 조회",
            tags = {"payments"}
    )
    @Parameters(
            value = {
                    @Parameter(name = "id", description = "결제 요청 아이디", in = ParameterIn.PATH)
            }
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "get payment successfully",
                            content = @Content(schema = @Schema(implementation = PaymentDto.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "no such payment")
            }
    )
    @GetMapping("/{id}")
    public PaymentDto getPaymentById(@PathVariable("id") Long paymentId) {

        return paymentUsecase.getPaymentById(paymentId);
    }


    // 결제 요청 다건 조회 API
    @Operation(
            summary = "get payment by id",
            description = "ID 로 결제 요청 조회",
            tags = {"payments"}
    )
    @Parameters(
            value = {
                    @Parameter(name = "id", description = "결제 요청 아이디", in = ParameterIn.PATH)
            }
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "get payment successfully",
                            content = @Content(schema = @Schema(implementation = PaymentDto.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "no such payment")
            }
    )
    @GetMapping
    public Page<PaymentDto> getPayments(
            @RequestParam(name = "status", required = false) PaymentStatus status,
            Pageable pageable
    ) {

        return paymentUsecase.getPayments(status, pageable);
    }
}