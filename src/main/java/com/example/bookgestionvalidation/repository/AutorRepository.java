package com.example.bookgestionvalidation.repository;

import com.example.bookgestionvalidation.entity.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor,Integer> {
}
