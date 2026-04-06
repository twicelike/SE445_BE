package com.study.prhrsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "payroll_benefit_plans", schema = "payroll")
public class PayrollBenefitPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer benefitPlanId;

    private String benefitPlanName;

    @OneToMany(mappedBy = "benefitPlan")
    private List<BenefitsCost> benefitsCosts;
}
