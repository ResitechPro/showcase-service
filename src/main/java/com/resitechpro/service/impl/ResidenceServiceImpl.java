package com.resitechpro.service.impl;

import com.resitechpro.repository.ImageRepository;
import com.resitechpro.repository.UserRepository;
import com.resitechpro.domain.entity.Residence;
import com.resitechpro.exception.customexceptions.ValidationException;
import com.resitechpro.repository.ResidenceRepository;
import com.resitechpro.service.ResidenceService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    public Residence createResidence(Residence residence) {
        /*Optional<Residence> optionalResidence = residenceRepository.findById(residence.getId());
        if(optionalResidence.isPresent()) return optionalResidence.get();*/
        if(residence.getOwner() != null && (userRepository.findById(residence.getOwner().getId()).isEmpty())){
                residence.setOwner(
                        userRepository.save(residence.getOwner())
                );
        }
        if( ! residence.getImages().isEmpty()){
            residence.setImages(
                    imageRepository.saveAll(residence.getImages())
            );
        }
        return residenceRepository.save(residence);
    }
}
