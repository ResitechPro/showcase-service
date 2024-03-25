package com.resitechpro.service;

import com.resitechpro.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUserWithOwnerRole(User user);

    List<User> getAllPartners();
}
