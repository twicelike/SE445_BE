package com.study.prhrsystem.service;

import com.study.prhrsystem.model.PayrollUser;
import com.study.prhrsystem.repository.PayrollUserRepository;
import com.study.prhrsystem.security.JwtUtil;
import com.study.prhrsystem.model.User;
import com.study.prhrsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PayrollUserRepository payrollUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Transactional
    public void createUser(String email, String password, String fullName) {

        User hrUser = new User();
        hrUser.setEmail(email);
        hrUser.setPassword(passwordEncoder.encode(password));
        hrUser.setFullName(fullName);

        hrUser = userRepository.save(hrUser);

        PayrollUser payrollUser = new PayrollUser();
        payrollUser.setId(hrUser.getId());
        payrollUser.setEmail(email);
        payrollUser.setPassword(passwordEncoder.encode(password));
        payrollUser.setFullName(fullName);

        payrollUserRepository.save(payrollUser);

    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}

