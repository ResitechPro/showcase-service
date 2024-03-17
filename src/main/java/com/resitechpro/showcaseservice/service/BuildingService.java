package com.resitechpro.showcaseservice.service;

import com.resitechpro.showcaseservice.domain.entity.Building;
import com.resitechpro.showcaseservice.exception.customexceptions.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuildingService {
    List<Building> getAllBuildings();

    Building createBuilding(Building building) throws ValidationException;
}
