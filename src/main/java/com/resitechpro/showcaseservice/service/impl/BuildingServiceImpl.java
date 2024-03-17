package com.resitechpro.showcaseservice.service.impl;

import com.resitechpro.showcaseservice.domain.entity.Building;
import com.resitechpro.showcaseservice.domain.entity.Image;
import com.resitechpro.showcaseservice.domain.entity.Residence;
import com.resitechpro.showcaseservice.exception.customexceptions.ValidationException;
import com.resitechpro.showcaseservice.repository.BuildingRepository;
import com.resitechpro.showcaseservice.repository.ImageRepository;
import com.resitechpro.showcaseservice.repository.ResidenceRepository;
import com.resitechpro.showcaseservice.service.BuildingService;
import com.resitechpro.showcaseservice.service.ResidenceService;
import com.resitechpro.showcaseservice.utils.ErrorMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    public Building createBuilding(Building building) throws ValidationException {
        building.setResidence(
            residenceService.createResidence(building.getResidence())
        );
        building.setImages(
                imageRepository.saveAll(building.getImages())
        );
        return buildingRepository.save(building);
    }
}
