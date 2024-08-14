package com.example.blogsystem.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(columnDefinition = "int")
    private Integer userId;


    @Column(columnDefinition = "int")
    private Integer categoryId;

    @NotEmpty(message = "Title must be not empty")
    @Size(min = 8,max = 25, message = "Title size length must be between 8-20")
    @Column(columnDefinition = "varchar(25) UNIQUE NOT NULL")
    private String title;

    @NotEmpty(message = "Content must be not empty")
    @Size(min = 30,max = 300 ,message = "Content have character between 30-300")
    @Column(columnDefinition = "varchar(300) NOT NULL")
    private String content;

    @Column(columnDefinition = "datetime")
    private LocalDate publishDate = LocalDate.now();



}
