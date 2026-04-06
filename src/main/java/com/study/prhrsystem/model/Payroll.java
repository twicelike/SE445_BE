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
@Table(name = "payroll", schema = "payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payrollId;

    private LocalDate payPeriodStart;
    private LocalDate payPeriodEnd;

    private BigDecimal baseSalary;
    private BigDecimal bonus;
    private BigDecimal netPay;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private PayrollEmployee payrollEmployee;
}
