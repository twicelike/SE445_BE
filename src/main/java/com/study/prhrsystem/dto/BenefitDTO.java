package com.study.prhrsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenefitDTO {
    private String plan;
    private Double amount;
    private int year;
}
