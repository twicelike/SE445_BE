package com.study.prhrsystem.repository;

import com.study.prhrsystem.dto.DepartmentDTO;
import com.study.prhrsystem.dto.EmployeeDashboardRawDTO;
import com.study.prhrsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query(value = """
        SELECT 
            d.department_id as departmentId,
            d.department_name as departmentName,
            d.branch_id as branchId,
            b.branch_name as branchName
        FROM hr.departments d 
        JOIN hr.branches b ON d.branch_id = b.branch_id
    """, nativeQuery = true)
    List<DepartmentDTO> findAllDepartmentAndBranch();
}
