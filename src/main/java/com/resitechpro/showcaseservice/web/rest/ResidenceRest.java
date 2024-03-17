package com.resitechpro.showcaseservice.web.rest;

import com.resitechpro.showcaseservice.domain.dto.request.residence.ResidenceRequestDto;
import com.resitechpro.showcaseservice.domain.dto.response.residence.ResidenceResponseDto;
import com.resitechpro.showcaseservice.domain.mapper.ResidenceMapper;
import com.resitechpro.showcaseservice.exception.customexceptions.ValidationException;
import com.resitechpro.showcaseservice.service.ResidenceService;
import com.resitechpro.showcaseservice.utils.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/residences")
public class ResidenceRest {
    private final ResidenceService residenceService;
    private final ResidenceMapper residenceMapper;

    public ResidenceRest(
            ResidenceService residenceService,
            ResidenceMapper residenceMapper
    ) {
        this.residenceService = residenceService;
        this.residenceMapper = residenceMapper;
    }
    @GetMapping
    public ResponseEntity<Response<List<ResidenceResponseDto>>> getAllResidences() {
        Response<List<ResidenceResponseDto>> response = new Response<>();
        response.setResult(
                residenceService.getAllResidences().stream()
                        .map(residenceMapper::toDto)
                        .toList()
        );
        response.setMessage("Residences retrieved successfully");
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response<ResidenceResponseDto>> createResidence(@Valid @RequestBody ResidenceRequestDto requestResidenceDto) throws ValidationException {
        Response<ResidenceResponseDto> response = new Response<>();
        response.setResult(
                residenceMapper.toDto(
                        residenceService.createResidence(residenceMapper.toResidence(requestResidenceDto))
                )
        );
        response.setMessage("Residence created successfully");
        return ResponseEntity.ok(response);
    }
}
