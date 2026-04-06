package com.study.prhrsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "benefit_plans", schema = "hr")
public class BenefitPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer benefitPlanId;

    private String planName;
    private String description;
    private String provider;

    @OneToMany(mappedBy = "benefitPlan")
    private List<EmployeeBenefit> employeeBenefits;
}
