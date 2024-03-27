package com.resitechpro.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "views")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate date;
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

}