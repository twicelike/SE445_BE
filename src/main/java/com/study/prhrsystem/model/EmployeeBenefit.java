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
@Table(name = "employee_benefits", schema = "hr")
public class EmployeeBenefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeBenefitId;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "benefit_plan_id")
    private BenefitPlan benefitPlan;
}
