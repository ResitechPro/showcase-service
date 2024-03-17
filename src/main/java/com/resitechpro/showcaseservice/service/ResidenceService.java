package com.resitechpro.showcaseservice.service;

import com.resitechpro.showcaseservice.domain.entity.Residence;
import com.resitechpro.showcaseservice.exception.customexceptions.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResidenceService {

    List<Residence> getAllResidences();

    Residence createResidence(Residence residence) throws ValidationException;
}
