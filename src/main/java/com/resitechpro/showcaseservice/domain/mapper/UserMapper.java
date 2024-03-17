package com.resitechpro.showcaseservice.domain.mapper;

import com.resitechpro.showcaseservice.domain.dto.request.user.UserRequestDto;
import com.resitechpro.showcaseservice.domain.dto.response.user.UserResponseDto;
import com.resitechpro.showcaseservice.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserRequestDto userDto);
    UserResponseDto toDto(User user);

}
