package com.resitechpro.domain.dto.response.stats;

import com.resitechpro.domain.dto.response.view.ViewResponseDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatsResponseDto {
    private Long totalProperties;
    private Long totalBuildings;
    private Long totalResidences;
    private Long totalViews;
    private List<ViewResponseDto> views;
}
