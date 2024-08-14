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
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;


    @Column(columnDefinition = "int")
    private Integer userId;


    @Column(columnDefinition = "int")
    private Integer postId;

    @NotEmpty(message = "Content must be not empty")
    @Size(min = 30,max = 300 ,message = "Content have character between 30-300")
    @Column(columnDefinition = "varchar(300) NOT NULL")
    private String content;

    @Column(columnDefinition = "datetime")
    private LocalDate commentDate=LocalDate.now();
}
