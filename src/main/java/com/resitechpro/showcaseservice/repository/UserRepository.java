package com.resitechpro.showcaseservice.repository;

import com.resitechpro.showcaseservice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("select u from User u where u.personalEmail = :personalEmail")
    Optional<User> findByPersonalEmail(String personalEmail);

    @Query("select u from User u where u.email = :email")
    Optional<User> findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.organizationName = :organizationName")
    Optional<User> findByOrganizationName(String organizationName);
}
