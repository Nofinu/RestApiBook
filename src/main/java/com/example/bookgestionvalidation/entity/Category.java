package com.example.bookgestionvalidation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Invalid name : name null")
    @NotEmpty(message = "Invalid name : name empty")
    @Size(max = 10,message = "Invalid name : name must be shorter than 50 characters")
    private String name;

    @NotNull(message = "Invalid Description : Description null")
    @NotEmpty(message = "Invalid Description : Description empty")
    @Size(max=200,message = "Invalid Description : description must be shorter than 200 characters")
    private String description;
}
