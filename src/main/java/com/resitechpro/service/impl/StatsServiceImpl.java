package com.resitechpro.service.impl;

import com.resitechpro.domain.dto.response.stats.StatsResponseDto;
import com.resitechpro.domain.entity.Property;
import com.resitechpro.domain.entity.View;
import com.resitechpro.repository.BuildingRepository;
import com.resitechpro.repository.PropertyRepository;
import com.resitechpro.repository.ResidenceRepository;
import com.resitechpro.repository.ViewRepository;
import com.resitechpro.service.StatsService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class StatsServiceImpl implements StatsService {

    private final ResidenceRepository residenceRepository;
    private final BuildingRepository buildingRepository;
    private final PropertyRepository propertyRepository;

    private final ViewRepository viewRepository;

    public StatsServiceImpl(
            ResidenceRepository residenceRepository,
            BuildingRepository buildingRepository,
            PropertyRepository propertyRepository,
            ViewRepository viewRepository
    ){
        this.residenceRepository = residenceRepository;
        this.buildingRepository = buildingRepository;
        this.propertyRepository = propertyRepository;
        this.viewRepository = viewRepository;
    }

    @Override
    public StatsResponseDto getLatestStats() {
        return StatsResponseDto.builder()
                .totalBuildings(buildingRepository.count())
                .totalResidences(residenceRepository.count())
                .totalProperties(propertyRepository.count())
                .totalViews(viewRepository.getTotalContViews())
                .views(
                        viewRepository.totalCountsByDate()
                )
                .build();
    }

    @Override
    public Boolean submitView(String propertyId) {

        Optional<View> todayPropertyView = viewRepository.findByPropertyIdAndDate(propertyId, LocalDate.now());
        if(todayPropertyView.isPresent()) {
            View view = todayPropertyView.get();
            view.setCount(view.getCount() + 1);
            viewRepository.save(view);
        } else {
            Optional<Property> optionalProperty = propertyRepository.findById(propertyId);
            if(optionalProperty.isEmpty()) {
                return false;
            }else {
                viewRepository.save(
                        View.builder()
                                .property(optionalProperty.get())
                                .count(1)
                                .date(LocalDate.now())
                                .build()
                );
            }
        }
        return true;
    }
}
