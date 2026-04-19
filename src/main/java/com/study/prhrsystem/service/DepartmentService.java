package com.study.prhrsystem.service;

import com.study.prhrsystem.dto.DepartmentDTO;
import com.study.prhrsystem.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getAllDepartment() {
        return  departmentRepository.findAllDepartmentAndBranch().stream()
                .map(department -> {
                    DepartmentDTO department1 = new DepartmentDTO();
                    department1.setDepartmentId(department.getDepartmentId());
                    department1.setDepartmentName(department.getDepartmentName());
                    department1.setBranchId(department.getBranchId());
                    department1.setBranchName(department.getBranchName());
                    return department1;
                }).toList();
    }
}
