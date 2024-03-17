package com.resitechpro.showcaseservice.domain.dto.request.residence;

import com.resitechpro.showcaseservice.domain.dto.request.image.ImageRequestDto;
import com.resitechpro.showcaseservice.domain.dto.request.user.UserRequestDto;
import com.resitechpro.showcaseservice.domain.entity.Residence;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Residence}
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Getter
public class ResidenceRequestDto implements Serializable {
    private String id;
    @NotNull(message = "Label is required")
    private  String label;
    @NotNull(message = "Description is required")
    private  String description;
    @NotNull(message = "Location is required")
    private  String location;
    @NotNull(message = "Surface is required")
    @Min(message = "Surface cannot be negative", value = 0)
    private  Long surface;
    @NotNull(message = "longitude is required")
    private  Long longitude;
    @NotNull(message = "Latitude is required")
    private  Long latitude;
    private UserRequestDto owner;
    private List<ImageRequestDto> images;
}