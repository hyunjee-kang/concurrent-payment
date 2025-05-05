package com.example.concurrentpayment.domain.product.domain.mapper;

import com.example.concurrentpayment.domain.product.domain.Product;
import com.example.concurrentpayment.domain.product.dto.ProductCreateDto;
import com.example.concurrentpayment.domain.product.dto.ProductDto;
import com.example.concurrentpayment.support.base.BaseMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<ProductDto, Product> {
    Product toEntity(ProductCreateDto dto); // 별도 매핑 추가 가능
}
