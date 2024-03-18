package com.resitechpro.service.impl;

import com.resitechpro.domain.entity.Building;
import com.resitechpro.exception.customexceptions.ValidationException;
import com.resitechpro.repository.BuildingRepository;
import com.resitechpro.repository.ImageRepository;
import com.resitechpro.service.BuildingService;
import com.resitechpro.service.ResidenceService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;

    private final ImageRepository imageRepository;

    private final ResidenceService residenceService;

    public BuildingServiceImpl
    (
        BuildingRepository buildingRepository,
        ImageRepository imageRepository,
        ResidenceService residenceService
    ) {
        this.buildingRepository = buildingRepository;
        this.imageRepository = imageRepository;
        this.residenceService = residenceService;
    }
    @Override
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    @Override
    public Building createBuilding(Building building)  {
        if(building.getResidence() != null){
            building.setResidence(
                    residenceService.createResidence(building.getResidence())
            );
        }
        if( ! building.getImages().isEmpty()){
            building.setImages(
                    imageRepository.saveAll(building.getImages())
            );
        }
        return buildingRepository.save(building);
    }
}
