package com.study.prhrsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vacation", schema = "hr")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vacationId;

    private LocalDate startDate;
    private LocalDate endDate;
    private Integer totalDays;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
