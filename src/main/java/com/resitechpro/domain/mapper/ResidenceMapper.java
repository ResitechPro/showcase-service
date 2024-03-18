package com.resitechpro.domain.mapper;

import com.resitechpro.domain.dto.request.residence.ResidenceRequestDto;
import com.resitechpro.domain.dto.response.residence.ResidenceResponseDto;
import com.resitechpro.domain.entity.Residence;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ResidenceMapper {
    ResidenceResponseDto toDto(Residence residence);
    Residence toResidence(ResidenceRequestDto requestResidenceDto);
}