package com.resitechpro.domain.mapper;

import com.resitechpro.domain.dto.response.view.ViewResponseDto;
import com.resitechpro.domain.entity.View;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ViewMapper {
    ViewResponseDto toDto(View view);

}