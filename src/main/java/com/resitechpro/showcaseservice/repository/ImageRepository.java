package com.resitechpro.showcaseservice.repository;

import com.resitechpro.showcaseservice.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}