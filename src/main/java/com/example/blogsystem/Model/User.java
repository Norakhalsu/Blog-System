package com.example.blogsystem.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "UserName must be not empty ")
    @Size(min = 5 ,max = 15,message ="username length must be between 5-15" )
    @Column(columnDefinition = "varchar(15) UNIQUE NOT NULL")
    private String username;


    @NotEmpty(message = "Password must be not empty ")
    @Size(min = 8 ,max = 20,message ="username length must be between 8-20" )
    @Column(columnDefinition = "varchar(20) UNIQUE NOT NULL")
    private String password;

    @Email(message = "Email must be in valid format ")
    @NotEmpty(message = "Email must not empty")
    @Column(columnDefinition = "varchar(20) UNIQUE NOT NULL")
    private String email;

   @Column(columnDefinition = "datetime")
    private LocalDate registrationDate=LocalDate.now();




}
