package com.resitechpro.domain.dto.request.property;

import com.resitechpro.domain.dto.request.building.BuildingRequestDto;
import com.resitechpro.domain.dto.request.image.ImageRequestDto;
import com.resitechpro.domain.entity.Property;
import com.resitechpro.domain.enums.PropertyType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Property}
 */
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class PropertyRequestDto implements Serializable {
    private String id;
    @NotNull(message = "Label is required")
    private String label;
    @NotNull(message = "Description is required")
    private String description;
    @NotNull(message = "Property Type is required")
    private PropertyType propertyType;
    @NotNull(message = "Surface is required")
    @Min(message = "Surface cannot be negative", value = 0)
    private Long surface;
    private Integer numberRooms;
    private Integer numberBathrooms;
    private Integer numberBedrooms;
    private Integer numberWindows;
    @NotNull(message = "Floor number is required")
    private String floorNumber;
    @NotNull(message = "Rent price is required")
    private String rentValue;

    private BuildingRequestDto building;
    private List<ImageRequestDto> images;
}
