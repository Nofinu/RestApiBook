package com.example.bookgestionvalidation.service;

import com.example.bookgestionvalidation.entity.Book;
import com.example.bookgestionvalidation.exception.NotFoundException;
import com.example.bookgestionvalidation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookDtoService {
    @Autowired
    private BookRepository bookRepository;
    public Book findById (int id) throws NotFoundException {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            return bookOptional.get();
        }
        throw new NotFoundException();
    }
}
