package com.example.concurrentpayment.domain.product.delivery;

import com.example.concurrentpayment.domain.payment.dto.PaymentDto;
import com.example.concurrentpayment.domain.product.dto.ProductCreateDto;
import com.example.concurrentpayment.domain.product.dto.ProductDto;
import com.example.concurrentpayment.domain.product.usecase.ProductUsecase;
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
@RequestMapping(path = "/apis/v1/products")
@Tag(name = "products", description = "products api")
public class ProductDelivery {
    private final ProductUsecase productUsecase;

    public ProductDelivery(ProductUsecase productUsecase) {
        this.productUsecase = productUsecase;
    }

    // 상품 등록 API
    @Operation(
            summary = "create product",
            description = "상품 생성",
            tags = {"products"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "create products successfully",
                            content = @Content(schema = @Schema(implementation = ProductDto.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "invalid input value")
            }
    )
    @PostMapping
    public ProductDto createProduct(@Valid @RequestBody ProductCreateDto productDto) {
        return productUsecase.createProduct(productDto);
    }


    // 상품 단건 조회 API
    @Operation(
            summary = "get product by id",
            description = "ID 로 상품 조회",
            tags = {"products"}
    )
    @Parameters(
            value = {
                    @Parameter(name = "id", description = "상품 아이디", in = ParameterIn.PATH)
            }
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "get product successfully",
                            content = @Content(schema = @Schema(implementation = PaymentDto.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "no such product")
            }
    )
    @GetMapping("/{id}")
    public ProductDto getPaymentById(@PathVariable("id") Long productId) {

        return productUsecase.getProductById(productId);
    }


    // 상품 다건 조회 API
    @Operation(
            summary = "get products",
            description = "상품 목록 조회",
            tags = {"products"}
    )
    @Parameters(
            value = {
                    @Parameter(name = "page", description = "페이지 번호", in = ParameterIn.QUERY),
                    @Parameter(name = "size", description = "페이지 사이즈", in = ParameterIn.QUERY)
            }
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "get products successfully",
                            content = @Content(schema = @Schema(implementation = ProductDto.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "no such product")
            }
    )
    @GetMapping
    public Page<ProductDto> getPayment(Pageable pageable) {
        return productUsecase.getProducts(pageable);
    }
}
