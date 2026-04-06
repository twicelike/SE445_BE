package com.study.prhrsystem.DTO;

import java.time.LocalDate;

public interface EmployeeDashboardRawDTO {

    Integer getId();
    String getFirstName();
    String getLastName();
    String getSex();
    String getEthnicity();
    Boolean getIsShareholder();
    Boolean getIsFullTime();
    String getDepartmentId();
    LocalDate getHireDate();
    LocalDate getBirthDate();

    String getEarnings();       // JSON string
    String getVacationDays();   // JSON string
    String getBenefits();       // JSON string
}
