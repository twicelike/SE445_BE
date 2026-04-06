package com.study.prhrsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "payroll_history", schema = "payroll")
public class PayrollHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payrollHistoryId;

    private LocalDate changeDate;

    private BigDecimal oldSalary;
    private BigDecimal newSalary;

    private String reason;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private PayrollEmployee payrollEmployee;
}
