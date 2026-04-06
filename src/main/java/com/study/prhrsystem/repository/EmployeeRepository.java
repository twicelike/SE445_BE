package com.study.prhrsystem.repository;


import com.study.prhrsystem.DTO.EmployeeDashboardRawDTO;
import com.study.prhrsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = """
        SELECT 
            e.employee_id AS id,
            e.first_name AS "firstName",
            e.last_name AS "lastName",
            e.gender AS sex,
            e.ethnicity,
            (e.employment_type = 'FULL_TIME') AS "isFullTime",
            e.shareholder_status AS "isShareholder",
            e.department_id AS "departmentId",
            e.hire_date AS "hireDate",
            e.birth_date AS "birthDate",

            (
                SELECT bp.plan_name
                FROM hr.employee_benefits eb
                JOIN hr.benefit_plans bp 
                    ON bp.benefit_plan_id = eb.benefit_plan_id
                WHERE eb.employee_id = e.employee_id
                ORDER BY eb.start_date DESC
                LIMIT 1
            ) AS "benefitsPlan",

            (
                SELECT COALESCE(json_agg(
                    jsonb_build_object(
                        'month', EXTRACT(MONTH FROM p.pay_period_start),
                        'year', EXTRACT(YEAR FROM p.pay_period_start),
                        'basicSalary', p.base_salary,
                        'overtime', p.overtime_pay,
                        'bonus', p.bonus
                    )
                    ORDER BY p.pay_period_start
                ), '[]')::text
                FROM payroll.payroll p
                WHERE p.employee_id = e.employee_id
            ) AS earnings,

            (
                SELECT COALESCE(json_agg(
                    jsonb_build_object(
                        'year', EXTRACT(YEAR FROM v.start_date),
                        'daysUsed', v.total_days,
                        'daysAccumulated', v.days_accumulated
                    )
                ), '[]')::text
                FROM hr.vacation v
                WHERE v.employee_id = e.employee_id
            ) AS "vacationDays",

            (
                SELECT COALESCE(json_agg(
                    jsonb_build_object(
                        'plan', bp.plan_name,
                        'amount', bc.cost_to_employee,
                        'year', EXTRACT(YEAR FROM eb.start_date)
                    )
                ), '[]')::text
                FROM hr.employee_benefits eb
                JOIN hr.benefit_plans bp 
                    ON bp.benefit_plan_id = eb.benefit_plan_id
                JOIN payroll.benefits_cost bc 
                    ON bc.benefit_plan_id = eb.benefit_plan_id
                WHERE eb.employee_id = e.employee_id
            ) AS benefits

        FROM hr.employees e
    """, nativeQuery = true)
    List<EmployeeDashboardRawDTO> findAllEmployeeForDashboard();
}
