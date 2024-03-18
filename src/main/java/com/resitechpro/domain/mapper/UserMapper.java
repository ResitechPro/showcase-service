package com.resitechpro.domain.mapper;

import com.resitechpro.domain.dto.request.user.UserRequestDto;
import com.resitechpro.domain.dto.response.user.UserResponseDto;
import com.resitechpro.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserRequestDto userDto);
    UserResponseDto toDto(User user);

}
