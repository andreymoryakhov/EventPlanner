package com.project.planner.service;

import com.project.planner.form.RegistrationUserForm;
import com.project.planner.model.User;
import com.project.planner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder ;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public void create(RegistrationUserForm registrationUserForm) {
        User user = new User();
        user.setUserName(registrationUserForm.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(registrationUserForm.getPassword()));
        userRepository.save(user);
    }
}
