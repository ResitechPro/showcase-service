package com.resitechpro.domain.dto.response.user;

import lombok.*;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    private String id;
    private String personalEmail;
    private String email;
    private String firstName;
    private String lastName;
    private Set<String> rolePermissions;
    private Set<String> permissionGroupPermissions;
}
