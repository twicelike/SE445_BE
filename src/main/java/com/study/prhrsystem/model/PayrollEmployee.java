package com.study.prhrsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "payroll_employees", schema = "payroll")
public class PayrollEmployee {

    @Id
    private Integer employeeId;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "payrollEmployee")
    private List<Payroll> payrolls;
}
