package com.example.bookgestionvalidation.dto;

import com.example.bookgestionvalidation.entity.Autor;
import com.example.bookgestionvalidation.entity.Book;
import com.example.bookgestionvalidation.entity.Category;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;

@Component
public class BookToBookDto {

    public BookReadDto convert(Book book){
        return BookReadDto.builder()
                .autorName(book.getAutor().getName())
                .categoryName(book.getCategory().getName())
                .title(book.getTitle())
                .publicationDate(book.getPublicationDate()).build();
    }

}
