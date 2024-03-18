package com.resitechpro.service.impl;

import com.resitechpro.domain.entity.Property;
import com.resitechpro.exception.customexceptions.ValidationException;
import com.resitechpro.repository.ImageRepository;
import com.resitechpro.repository.PropertyRepository;
import com.resitechpro.service.PropertyService;
import com.resitechpro.service.BuildingService;
import org.springframework.stereotype.Component;

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
    public Property createProperty(Property property) {
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
