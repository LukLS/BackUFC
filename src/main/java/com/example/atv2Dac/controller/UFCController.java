package com.example.atv2Dac.controller;

import com.example.atv2Dac.dto.UFCDTO;
import com.example.atv2Dac.model.Lutador;
import com.example.atv2Dac.model.UFC;
import com.example.atv2Dac.service.UFCservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ufc")
public class UFCController {

    @Autowired
    private UFCservice ufcservice;

    @PostMapping()
    public ResponseEntity save(@RequestBody UFC ufc){
       UFCDTO ufcdto = ufcservice.save(ufc);
       URI location = getUri(ufc.getId());
       return ResponseEntity.created(location).build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @GetMapping()
    public ResponseEntity getUFC(){
         List<UFCDTO> ufc = ufcservice.getUFC();
       return ResponseEntity.ok(ufc);
    }
    @GetMapping("/{id}")
    public ResponseEntity busca(@PathVariable Long id){
         UFCDTO ufc = ufcservice.busca(id);
        return ResponseEntity.ok(ufc);
    }


    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id,@RequestBody UFC ufc){
        UFCDTO ufcdto = ufcservice.update(id, ufc);
        return ResponseEntity.ok(ufcdto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        ufcservice.delete(id);
    }



}
