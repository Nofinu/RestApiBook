package com.example.bookgestionvalidation.dto;

import com.example.bookgestionvalidation.entity.Book;
import com.example.bookgestionvalidation.exception.NotFoundException;
import com.example.bookgestionvalidation.service.AutorService;
import com.example.bookgestionvalidation.service.BookDtoService;
import com.example.bookgestionvalidation.service.BookService;
import com.example.bookgestionvalidation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDtoToBook {
    @Autowired
    private BookDtoService bookService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private CategoryService categoryService;

    public Book convert(BookCreateDto bookCreateDto) throws NotFoundException {
        Book book = bookCreateDto.getId() != null ? bookService.findById(bookCreateDto.getId()) : new Book();
        book.setTitle(bookCreateDto.getTitle());
        book.setAutor(autorService.findById(bookCreateDto.getAutor()));
        book.setCategory(categoryService.findById(bookCreateDto.getCategory()));
        book.setPublicationDate(bookCreateDto.getPublicationDate());

        return book;
    }
}
