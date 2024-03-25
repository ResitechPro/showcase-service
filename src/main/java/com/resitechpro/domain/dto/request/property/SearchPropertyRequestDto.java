package com.resitechpro.domain.dto.request.property;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SearchPropertyRequestDto {
    private String location;
    private String propertyType;
}
