package com.example.bookgestionvalidation.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateDto {

    @Min(value = 1,message = "Invalid id : id must be at least 1")
    private Integer id;

    @NotNull(message = "Invalid title : title null")
    @NotEmpty(message = "Invalid title : title empty")
    private String title;

    @NotNull(message = "Invalid autor : autor null")
    @Min(value = 1,message = "Invalid AutorId : AutorId must be at least 1")
    private Integer autor;

    @NotNull(message = "Invalid category : category null")
    @Min(value = 1,message = "Invalid categoryId : categoryId must be at least 1")
    private Integer category;

    @Max(value = 2023,message = "Invalid publicationDate : publicationDate need to be before 2023")
    @NotNull(message = "Invalid publicationDate : category publicationDate")
    private Integer publicationDate;
}
