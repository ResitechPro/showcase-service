package com.resitechpro.showcaseservice.service;

import com.resitechpro.showcaseservice.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createUserWithOwnerRole(User user);
}
