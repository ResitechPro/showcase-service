package com.resitechpro.showcaseservice.domain.dto.response.image;

import com.resitechpro.showcaseservice.domain.entity.Image;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Image}
 */
@AllArgsConstructor
@Getter
@Builder
@Setter
@NoArgsConstructor
public final class ImageResponseDto implements Serializable {
    private String url;
}