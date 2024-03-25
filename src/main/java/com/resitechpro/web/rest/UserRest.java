package com.resitechpro.web.rest;

import com.resitechpro.domain.dto.response.user.UserResponseDto;
import com.resitechpro.domain.mapper.UserMapper;
import com.resitechpro.service.UserService;
import com.resitechpro.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/showcase/users")
public class UserRest {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserRest(
        UserService userService,
        UserMapper userMapper
    ) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<Response<List<UserResponseDto>>> getPartners() {
        Response<List<UserResponseDto>> response = new Response<>();
        response.setMessage("Partners retrieved successfully");
        response.setResult(
            userService.getAllPartners().stream()
                .map(userMapper::toDto)
                .toList()
        );
        return ResponseEntity.ok(response);
    }
}
