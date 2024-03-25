package com.resitechpro.service.impl;

import com.resitechpro.domain.entity.User;
import com.resitechpro.repository.UserRepository;
import com.resitechpro.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUserWithOwnerRole(User user) {
        return null;
    }

    @Override
    public List<User> getAllPartners() {
        return userRepository.getUsers();
    }
}
