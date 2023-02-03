package com.example.demo.repository;

import com.example.demo.modal.produse;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;


public interface produseRepo extends CrudRepository<produse, Long> {

    List<produse>findAll();
    Optional<produse>FindById(Long id);
}

