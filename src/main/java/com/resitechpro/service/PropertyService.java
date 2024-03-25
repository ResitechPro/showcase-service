package com.resitechpro.service;

import com.resitechpro.domain.dto.request.property.SearchPropertyRequestDto;
import com.resitechpro.exception.customexceptions.ValidationException;
import com.resitechpro.domain.entity.Property;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public interface PropertyService {

    List<Property> getAllProperties();

    List<Property> getPropertiesByBuildingLabel(String buildingLabel);

    Property createProperty(Property property) ;

    List<Property> searchProperties (SearchPropertyRequestDto propertyRequestDto);
}
