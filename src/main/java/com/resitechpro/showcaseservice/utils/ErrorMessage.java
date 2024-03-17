package com.resitechpro.showcaseservice.utils;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private String field;
    private String message;
}
