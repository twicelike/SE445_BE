package com.study.prhrsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Integer departmentId;
    private String departmentName;
    private Integer branchId;
    private String branchName;
}
