package com.study.prhrsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employees", schema = "hr")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    private String firstName;
    private String lastName;
    private String gender;
    private String ethnicity;

    private LocalDate birthDate;
    private LocalDate hireDate;

    private String employmentType;
    private Boolean shareholderStatus;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "employee")
    private List<Vacation> vacations;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeBenefit> employeeBenefits;
}
