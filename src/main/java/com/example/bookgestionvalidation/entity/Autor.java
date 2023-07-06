package com.example.bookgestionvalidation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Invalid name : name null")
    @NotEmpty(message = "Invalid name : name empty")
    @Size(max = 50,message = "Invalid Name : name must be shorter then 50 characters")
    private String name;

   //@Pattern(regexp = "^[\\w-.]+@(editor\\.com)",message = "Invalid email : email must be ... @editor.com")
    @Email(regexp = "^[\\w-.]+@(editor\\.com)", message =  "Invalid email : email must be ... @editor.com")
    @NotNull(message = "Invalid email : email null")
    @NotEmpty(message = "Invalid email : email empty")
    @Column
    private String email;

}
