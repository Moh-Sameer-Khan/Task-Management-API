package com.apiwiz.TaskManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Admin.class,property = "adminId")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    @NotBlank(message = "Admin Name can not be blank")
    private String adminName;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@admin\\.com$")
    @Column(unique = true)
    private String adminEmail;

    @NotBlank(message = "Password is Required")
    @Column(nullable = false)
    private String adminPassword;

}