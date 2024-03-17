package com.resitechpro.showcaseservice.domain.dto.request.building;

import com.resitechpro.showcaseservice.domain.dto.request.image.ImageRequestDto;
import com.resitechpro.showcaseservice.domain.dto.request.residence.ResidenceRequestDto;
import com.resitechpro.showcaseservice.domain.entity.Image;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BuildingRequestDto implements Serializable {
    private String id;
    @NotNull(message = "Label is required")
    private String label;
    @NotNull(message = "Description is required")
    private String description;
    @NotNull(message = "Number of floors is required")
    @Min(message = "minimum floors number  is one", value = 1)
    private Integer numberFloors;
    @NotNull(message = "Residence label is required")
    private ResidenceRequestDto residence;
    private List<ImageRequestDto> images;
}