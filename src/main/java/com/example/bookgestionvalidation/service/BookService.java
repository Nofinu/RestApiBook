package com.example.bookgestionvalidation.service;

import com.example.bookgestionvalidation.dto.BookCreateDto;
import com.example.bookgestionvalidation.dto.BookDtoToBook;
import com.example.bookgestionvalidation.dto.BookReadDto;
import com.example.bookgestionvalidation.dto.BookToBookDto;
import com.example.bookgestionvalidation.entity.Book;
import com.example.bookgestionvalidation.exception.NotFoundException;
import com.example.bookgestionvalidation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookDtoToBook bookDtoToBook;
    @Autowired
    private BookToBookDto bookToBookDto;

    public BookReadDto save(BookCreateDto bookCreateDto) throws NotFoundException {
        Book book = bookDtoToBook.convert(bookCreateDto);
        return bookToBookDto.convert(bookRepository.save(book));
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

    public BookReadDto findByIdDto (int id) throws NotFoundException {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            return bookToBookDto.convert(bookOptional.get()) ;
        }
        throw new NotFoundException();
    }

    public List<BookReadDto> findAll (){
        List<BookReadDto> bookReadDtos = new ArrayList<>();
        for (Book b:bookRepository.findAll()) {
            bookReadDtos.add(bookToBookDto.convert(b));
        }
        return bookReadDtos ;
    }

}
