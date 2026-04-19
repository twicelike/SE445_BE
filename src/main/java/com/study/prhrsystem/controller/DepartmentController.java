package com.study.prhrsystem.controller;

import com.study.prhrsystem.dto.DepartmentDTO;
import com.study.prhrsystem.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDTO> getAllDepartment() {
        return departmentService.getAllDepartment();
    }
}
