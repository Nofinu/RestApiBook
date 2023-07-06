package com.example.bookgestionvalidation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookReadDto {
    private String title;

    private String autorName;

    private String categoryName;

    private Integer publicationDate;
}
