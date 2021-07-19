package com.project.planner.controller;

import com.project.planner.form.RegistrationUserForm;
import com.project.planner.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/mainPage")
    public String show() {
        return "mainPage";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new RegistrationUserForm());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid RegistrationUserForm registrationUserForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!registrationUserForm.getPassword().equals(registrationUserForm.getRepeatPassword())) {
            bindingResult.rejectValue("password", "", "Passwords don't match");
            return "registration";
        }
        userService.create(registrationUserForm);
        return "redirect:/login";
    }
}
