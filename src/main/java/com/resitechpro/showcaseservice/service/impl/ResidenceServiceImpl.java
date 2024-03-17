package com.resitechpro.showcaseservice.service.impl;

import com.resitechpro.showcaseservice.domain.entity.Residence;
import com.resitechpro.showcaseservice.domain.entity.User;
import com.resitechpro.showcaseservice.exception.customexceptions.ValidationException;
import com.resitechpro.showcaseservice.repository.ImageRepository;
import com.resitechpro.showcaseservice.repository.ResidenceRepository;
import com.resitechpro.showcaseservice.repository.UserRepository;
import com.resitechpro.showcaseservice.service.ResidenceService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResidenceServiceImpl implements ResidenceService {

    private final ResidenceRepository residenceRepository;
    private final ImageRepository imageRepository;
    private final UserRepository userRepository;

    public ResidenceServiceImpl(
        ResidenceRepository residenceRepository,
        ImageRepository imageRepository,
        UserRepository userRepository) {
        this.residenceRepository = residenceRepository;
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
    }
    @Override
    public List<Residence> getAllResidences() {
        return residenceRepository.findAll();
    }

    @Override
    public Residence createResidence(Residence residence) throws ValidationException {
        if(residence.getOwner() != null && (userRepository.findById(residence.getOwner().getId()).isEmpty())){
                residence.setOwner(
                        userRepository.save(residence.getOwner())
                );
        }
        residence.setImages(
            imageRepository.saveAll(residence.getImages())
        );
        return residenceRepository.save(residence);
    }
}
