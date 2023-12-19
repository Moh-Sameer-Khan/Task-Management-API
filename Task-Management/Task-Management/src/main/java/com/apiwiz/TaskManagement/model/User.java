package com.apiwiz.TaskManagement.model;

import com.apiwiz.TaskManagement.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotBlank(message = "User Name can not be blank")
    private String userName;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@suser\\.com$")
    @Column(unique = true)
    private String userEmail;

    @NotBlank(message = "Password is Required")
    @Column(nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private Gender gender;



}




