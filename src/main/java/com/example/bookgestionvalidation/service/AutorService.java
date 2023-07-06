package com.example.bookgestionvalidation.service;

import com.example.bookgestionvalidation.entity.Autor;
import com.example.bookgestionvalidation.exception.NotFoundException;
import com.example.bookgestionvalidation.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor save (Autor autor){
        return autorRepository.save(autor);
    }

    public boolean delete (int id) throws NotFoundException {
        Autor autor = findById(id);
        autorRepository.delete(autor);
        return true;
    }

    public Autor findById(int id) throws NotFoundException {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        if(autorOptional.isPresent()){
            return autorOptional.get();
        }
        throw new NotFoundException();
    }

    public List<Autor> findAll(){
        return (List<Autor>) autorRepository.findAll();
    }
}
