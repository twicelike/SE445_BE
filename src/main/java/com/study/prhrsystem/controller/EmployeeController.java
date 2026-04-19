package com.study.prhrsystem.controller;

import com.study.prhrsystem.dto.EmployeeDashboardDTO;
import com.study.prhrsystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDashboardDTO> getAllEmployee() {
        return employeeService.getDashboard();
    }
}
