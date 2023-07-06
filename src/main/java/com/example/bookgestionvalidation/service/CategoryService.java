package com.example.bookgestionvalidation.service;

import com.example.bookgestionvalidation.entity.Category;
import com.example.bookgestionvalidation.exception.NotFoundException;
import com.example.bookgestionvalidation.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category save (Category category){
        return categoryRepository.save(category);
    }

    public boolean delete(int id) throws NotFoundException {
        Category category = findById(id);
        categoryRepository.delete(category);
        return true;
    }

    public Category findById(int id) throws NotFoundException {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            return categoryOptional.get();
        }
        throw new NotFoundException();
    }

    public List<Category> findAll(){
        return (List<Category>) categoryRepository.findAll();
    }
}
