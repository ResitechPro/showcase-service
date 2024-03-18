package com.resitechpro.config.kafka.consumer;

import com.resitechpro.domain.dto.response.residence.ResidenceResponseDto;
import com.resitechpro.domain.entity.Building;
import com.resitechpro.domain.entity.Property;
import com.resitechpro.domain.entity.Residence;
import com.resitechpro.exception.customexceptions.ValidationException;
import com.resitechpro.service.BuildingService;
import com.resitechpro.service.PropertyService;
import com.resitechpro.service.ResidenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    private final ResidenceService residenceService;
    private final PropertyService propertyService;
    private final BuildingService buildingService;

    public KafkaConsumer(
        ResidenceService residenceService,
        PropertyService propertyService,
        BuildingService buildingService
    ) {
        this.residenceService = residenceService;
        this.propertyService = propertyService;
        this.buildingService = buildingService;
    }
    @KafkaListener(topics = "residences", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeResidences(Residence residence) {
        log.info("Consumed residence By label {}", residence.getLabel());
        residenceService.createResidence(residence);
    }

    @KafkaListener(topics = "buildings", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeBuildings(Building building) {
        log.info("Consumed building By label {}", building.getLabel());
        buildingService.createBuilding(building);
    }

    @KafkaListener(topics = "properties", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeProperties(Property property) {
        log.info("Consumed property By label {}", property.getLabel());
        propertyService.createProperty(property);
    }
}
