package com.example.n01561393_Assignment01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
//import jakarta.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero(message = "ID should be positive")
    private  int id;

    @Size(min=5, max=20, message="User's  name cannot be shorter than 3 characters and longer than 8 characters!")
    private String name;

    @Min(value =  18, message = "Age must be at least 18 years")
    @Max(value = 50, message ="Age must not exceed 50 years")
    private int age;

    @NotBlank(message = "Gender cannot be empty!!")
    @Pattern(regexp = "^(?i)(Male|Female)$", message = "Gender must be either Male or Female")
    private String gender;

    @Email(message="Please enter valid email!!")
    private String email;

    @NotBlank(message="City cannot be empty!!")
    private String city;

    @Pattern(regexp = "\\d{4}/\\d{2}/\\d{2}", message = "Date of birth must be in the format yyyy/MM/dd")
    private String dateOfBirth;

}

