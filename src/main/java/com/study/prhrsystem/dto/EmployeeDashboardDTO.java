package com.study.prhrsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDashboardDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String sex;
    private String ethnicity;
    private Boolean isShareholder;
    private Boolean isFullTime;
    private String departmentId;
    private LocalDate hireDate;
    private LocalDate birthDate;

    private List<EarningDTO> earnings;
    private List<VacationDTO> vacationDays;
    private List<BenefitDTO> benefits;
}
