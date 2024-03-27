package com.resitechpro.repository;

import com.resitechpro.domain.dto.response.view.ViewResponseDto;
import com.resitechpro.domain.entity.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ViewRepository extends JpaRepository<View, Long> {
    @Query("select SUM(v.count) from View v ")
    Long getTotalContViews();

    @Query("select new com.resitechpro.domain.dto.response.view.ViewResponseDto(v.date,sum(v.count)) from View v group by v.date order by v.date asc ")
    List<ViewResponseDto> totalCountsByDate();

    @Query("select v from View v where v.property.id = :propertyId and v.date = :date")
    Optional<View> findByPropertyIdAndDate(String propertyId, LocalDate date);
}