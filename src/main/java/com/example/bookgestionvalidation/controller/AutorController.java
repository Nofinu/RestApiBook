package com.example.bookgestionvalidation.controller;

import com.example.bookgestionvalidation.entity.Autor;
import com.example.bookgestionvalidation.entity.Book;
import com.example.bookgestionvalidation.exception.NotFoundException;
import com.example.bookgestionvalidation.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping("/add")
    public ResponseEntity<Autor> addAutor(@RequestBody @Valid Autor autor){
        return new ResponseEntity<>( autorService.save(autor), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Integer id) throws NotFoundException {
        autorService.delete(id);
        return new ResponseEntity<>("autor delete",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> findById (@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(autorService.findById(id),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Autor>> findAll () {
        return new ResponseEntity<>(autorService.findAll(),HttpStatus.OK);
    }
}
