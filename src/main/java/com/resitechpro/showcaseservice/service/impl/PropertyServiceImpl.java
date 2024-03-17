package com.resitechpro.showcaseservice.service.impl;

import com.resitechpro.showcaseservice.domain.entity.Building;
import com.resitechpro.showcaseservice.domain.entity.Image;
import com.resitechpro.showcaseservice.domain.entity.Property;
import com.resitechpro.showcaseservice.exception.customexceptions.ValidationException;
import com.resitechpro.showcaseservice.repository.BuildingRepository;
import com.resitechpro.showcaseservice.repository.ImageRepository;
import com.resitechpro.showcaseservice.repository.PropertyRepository;
import com.resitechpro.showcaseservice.service.BuildingService;
import com.resitechpro.showcaseservice.service.PropertyService;
import com.resitechpro.showcaseservice.utils.ErrorMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final ImageRepository imageRepository;
    private final BuildingService buildingService;

    public PropertyServiceImpl
    (
        PropertyRepository propertyRepository,
        ImageRepository imageRepository,
        BuildingService buildingService
    ) {
        this.propertyRepository = propertyRepository;
        this.imageRepository = imageRepository;
        this.buildingService = buildingService;
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public List<Property> getPropertiesByBuildingLabel(String buildingLabel) {
        return propertyRepository.findByBuildingLabel(buildingLabel);
    }

    @Override
    public Property createProperty(Property property) throws ValidationException {
        if(property.getBuilding() != null){
            property.setBuilding(
                    buildingService.createBuilding(property.getBuilding())
            );
        }
        if( ! property.getImages().isEmpty()){
            property.setImages(
                    imageRepository.saveAll(property.getImages())
            );
        }
        return propertyRepository.save(property);
    }
}
