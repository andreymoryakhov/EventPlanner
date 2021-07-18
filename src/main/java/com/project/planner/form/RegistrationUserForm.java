package com.project.planner.form;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class RegistrationUserForm {

    private Long id;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @NotBlank
    private String repeatPassword;

    public RegistrationUserForm() {
    }
}
