package com.resitechpro.showcaseservice.domain.mapper;

import com.resitechpro.showcaseservice.domain.dto.response.image.ImageResponseDto;
import com.resitechpro.showcaseservice.domain.entity.Image;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ImageMapper {
    ImageResponseDto toDto(Image image);

}