package com.study.prhrsystem.repository;

import com.study.prhrsystem.model.PayrollUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollUserRepository extends JpaRepository<PayrollUser, Integer> {
}
