package com.example.demo.controller;

import com.example.demo.dto.ProduseDTO;
import com.example.demo.modal.produse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")

public class productsController {
    private static final Map<Long, ProduseDTO> productsMap = new HashMap<>();

    final com.example.demo.repository.produseRepo produseRepo;
    static {
        ProduseDTO p1 = new ProduseDTO();
        p1.setId(1L);
        p1.setNume("Mere");
        productsMap.put(p1.getId(),p1);
    }
    public productsController(com.example.demo.repository.produseRepo produseRepo) {
        this.produseRepo = produseRepo;

    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(produseRepo.findAll().stream().map(o -> new ProduseDTO(o.getId(), o.getNume(),
                o.getPretinceput(), o.getPretfinal(), o.getImagine(), o.getDescriere(), o.getLicitator(),o.getTimp(),
                o.getTimpexpirare())).collect(Collectors.toList()), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody ProduseDTO produseDTO){
        productsMap.put(produseDTO.getId(), produseDTO);
        produse produs = new produse();
        produs.setNume(produseDTO.getNume());
        produseRepo.save(produs);
        return new ResponseEntity<>("Produs creat", HttpStatus.OK);
    }
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> updateProdus(@PathVariable("id") Long id) {
        return new ResponseEntity<>(produseRepo.FindById(id).map(o -> new ProduseDTO(o.getId(), o.getNume(),
                o.getPretinceput(), o.getPretfinal(), o.getImagine(), o.getDescriere(), o.getLicitator(),o.getTimp(),
                o.getTimpexpirare())).orElse(null), HttpStatus.OK);
    }
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>updateProduct(@PathVariable("id") Long id, @RequestBody ProduseDTO produseDTO){
        produseRepo.FindById(id).ifPresent(p ->{
            p.setNume(produseDTO.getNume());
            produseRepo.save(p);
        });
        productsMap.remove(id);
        productsMap.put(id, produseDTO);
        return new ResponseEntity<>("Product updated", HttpStatus.OK);
    }
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
        ProduseDTO remove = productsMap.remove(id);
        produseRepo.deleteById(id);
        return new ResponseEntity<>(Optional.ofNullable(remove).map(p -> "Product deleted")
                .orElse("Product not found"),HttpStatus.OK);
    }
}
