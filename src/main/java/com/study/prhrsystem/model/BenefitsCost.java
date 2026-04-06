package com.study.prhrsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "benefits_cost", schema = "payroll")
public class BenefitsCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer benefitCostId;

    private BigDecimal costToCompany;
    private BigDecimal costToEmployee;

    @ManyToOne
    @JoinColumn(name = "benefit_plan_id")
    private PayrollBenefitPlan benefitPlan;
}
