package com.study.prhrsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EarningDTO {
    private int month;
    private int year;
    private Double basicSalary;
    private Double overtime;
    private Double bonus;
}
