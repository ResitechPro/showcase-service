package com.resitechpro.showcaseservice.domain.dto.request.image;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ImageRequestDto implements Serializable {
    private String url;
}
