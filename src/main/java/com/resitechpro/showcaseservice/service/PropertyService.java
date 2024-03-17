package com.resitechpro.showcaseservice.service;

import com.resitechpro.showcaseservice.domain.entity.Property;
import com.resitechpro.showcaseservice.exception.customexceptions.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService {

    List<Property> getAllProperties();

    List<Property> getPropertiesByBuildingLabel(String buildingLabel);

    Property createProperty(Property property) throws ValidationException;
}
