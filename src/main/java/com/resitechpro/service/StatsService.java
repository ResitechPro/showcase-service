package com.resitechpro.service;

import com.resitechpro.domain.dto.response.stats.StatsResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface StatsService {
    StatsResponseDto getLatestStats();

    Boolean submitView(String propertyId);
}
