package com.example.bookgestionvalidation.controller;

import com.example.bookgestionvalidation.entity.Book;
import com.example.bookgestionvalidation.entity.Category;
import com.example.bookgestionvalidation.exception.NotFoundException;
import com.example.bookgestionvalidation.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory (@RequestBody @Valid Category category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Integer id) throws NotFoundException {
        categoryService.delete(id);
        return new ResponseEntity<>("Category delete",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById (@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(categoryService.findById(id),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> findAll () {
        return new ResponseEntity<>(categoryService.findAll(),HttpStatus.OK);
    }
}
