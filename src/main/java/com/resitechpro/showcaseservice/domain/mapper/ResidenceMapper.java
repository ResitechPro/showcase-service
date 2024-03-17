package com.resitechpro.showcaseservice.domain.mapper;

import com.resitechpro.showcaseservice.domain.dto.request.residence.ResidenceRequestDto;
import com.resitechpro.showcaseservice.domain.dto.response.residence.ResidenceResponseDto;
import com.resitechpro.showcaseservice.domain.entity.Residence;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ResidenceMapper {
    ResidenceResponseDto toDto(Residence residence);
    Residence toResidence(ResidenceRequestDto requestResidenceDto);
}