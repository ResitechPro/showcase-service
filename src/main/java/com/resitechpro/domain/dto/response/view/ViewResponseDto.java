package com.resitechpro.domain.dto.response.view;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewResponseDto {
    private LocalDate date;
    private Long count;
}
