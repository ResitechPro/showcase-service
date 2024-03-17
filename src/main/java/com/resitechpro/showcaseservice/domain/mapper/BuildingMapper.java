package com.resitechpro.showcaseservice.domain.mapper;

import com.resitechpro.showcaseservice.domain.dto.request.building.BuildingRequestDto;
import com.resitechpro.showcaseservice.domain.dto.response.building.BuildingResponseDto;
import com.resitechpro.showcaseservice.domain.entity.Building;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BuildingMapper {

    @Mapping(target = "residence.label", source = "residenceLabel")
    Building toBuilding(BuildingRequestDto buildingResponseDto);

    BuildingResponseDto toDto(Building building);

}