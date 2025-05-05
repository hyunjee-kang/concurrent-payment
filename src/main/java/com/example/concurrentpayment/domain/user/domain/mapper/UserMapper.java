package com.example.concurrentpayment.domain.user.domain.mapper;

import com.example.concurrentpayment.domain.user.domain.User;
import com.example.concurrentpayment.domain.user.dto.UserCreateDto;
import com.example.concurrentpayment.domain.user.dto.UserDto;
import com.example.concurrentpayment.support.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDto, User> {
    User toEntity(UserCreateDto dto);
}
