package com.example.bookgestionvalidation.controller;

import com.example.bookgestionvalidation.dto.BookCreateDto;
import com.example.bookgestionvalidation.dto.BookDtoToBook;
import com.example.bookgestionvalidation.entity.Book;
import com.example.bookgestionvalidation.exception.NotFoundException;
import com.example.bookgestionvalidation.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody @Valid BookCreateDto bookCreateDto) throws NotFoundException {
        return new ResponseEntity<>(bookService.save(bookCreateDto), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deletebook (@PathVariable Integer id) throws NotFoundException {
        bookService.delete(id);
        return new ResponseEntity<>("book delete",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById (@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(bookService.findById(id),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> findAll () {
        return new ResponseEntity<>(bookService.findAll(),HttpStatus.OK);
    }
}
