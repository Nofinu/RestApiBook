package com.example.bookgestionvalidation.service;

import com.example.bookgestionvalidation.dto.BookCreateDto;
import com.example.bookgestionvalidation.dto.BookDtoToBook;
import com.example.bookgestionvalidation.entity.Book;
import com.example.bookgestionvalidation.exception.NotFoundException;
import com.example.bookgestionvalidation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookDtoToBook bookDtoToBook;

    public Book save(BookCreateDto bookCreateDto) throws NotFoundException {
        Book book = bookDtoToBook.convert(bookCreateDto);
        return bookRepository.save(book);
    }

    public boolean delete (int id) throws NotFoundException {
        Book book = findById(id);
        bookRepository.delete(book);
        return true;
    }

    public Book findById (int id) throws NotFoundException {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            return bookOptional.get();
        }
        throw new NotFoundException();
    }

    public List<Book> findAll (){
        return (List<Book>) bookRepository.findAll();
    }

}
