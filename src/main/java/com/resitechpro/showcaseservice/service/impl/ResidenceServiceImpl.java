package com.resitechpro.showcaseservice.service.impl;

import com.resitechpro.showcaseservice.domain.entity.Residence;
import com.resitechpro.showcaseservice.exception.customexceptions.ValidationException;
import com.resitechpro.showcaseservice.repository.ResidenceRepository;
import com.resitechpro.showcaseservice.service.ResidenceService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResidenceServiceImpl implements ResidenceService {

    private final ResidenceRepository residenceRepository;

    public ResidenceServiceImpl(
        ResidenceRepository residenceRepository
    ) {
        this.residenceRepository = residenceRepository;
    }
    @Override
    public List<Residence> getAllResidences() {
        return residenceRepository.findAll();
    }

    @Override
    public Residence createResidence(Residence residence) throws ValidationException {
        return residenceRepository.save(residence);
    }
}
