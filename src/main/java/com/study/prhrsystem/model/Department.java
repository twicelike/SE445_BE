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
@Table(name = "departments", schema = "hr")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;

    private String departmentName;

    private Integer managerId;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
