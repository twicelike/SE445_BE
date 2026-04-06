package com.study.prhrsystem.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.study.prhrsystem.DTO.BenefitDTO;
import com.study.prhrsystem.DTO.EarningDTO;
import com.study.prhrsystem.DTO.EmployeeDashboardDTO;
import com.study.prhrsystem.DTO.VacationDTO;
import com.study.prhrsystem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final Gson gson = new Gson();

    public List<EmployeeDashboardDTO> getDashboard() {

        Type earningType = new TypeToken<List<EarningDTO>>() {
        }.getType();
        Type vacationType = new TypeToken<List<VacationDTO>>() {
        }.getType();
        Type benefitType = new TypeToken<List<BenefitDTO>>() {
        }.getType();

        return employeeRepository.findAllEmployeeForDashboard()
                .stream()
                .map(raw -> {
                    EmployeeDashboardDTO dto = new EmployeeDashboardDTO();

                    dto.setId(raw.getId());
                    dto.setFirstName(raw.getFirstName());
                    dto.setLastName(raw.getLastName());
                    dto.setSex(raw.getSex());
                    dto.setEthnicity(raw.getEthnicity());
                    dto.setIsFullTime(raw.getIsFullTime());
                    dto.setIsShareholder(raw.getIsShareholder());
                    dto.setDepartmentId(raw.getDepartmentId());
                    dto.setHireDate(raw.getHireDate());
                    dto.setBirthDate(raw.getBirthDate());

                    dto.setEarnings(
                            raw.getEarnings() != null
                                    ? gson.fromJson(raw.getEarnings(), earningType)
                                    : List.of()
                    );

                    dto.setVacationDays(
                            raw.getVacationDays() != null ?
                                    gson.fromJson(raw.getVacationDays(), vacationType)
                                    : List.of()
                    );

                    dto.setBenefits(
                            raw.getBenefits() != null ?
                                    gson.fromJson(raw.getBenefits(), benefitType)
                                    : List.of()
                    );

                    return dto;
                })
                .toList();
    }
}