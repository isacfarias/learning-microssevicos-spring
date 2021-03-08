package com.farias.hrwork.resources;

import java.util.List;

import com.farias.hrwork.entities.Worker;
import com.farias.hrwork.repositories.WorkRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/workers")
public class WorkResource {

    @Autowired
    private WorkRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> listaWorkers() {

        List<Worker> workers = repository.findAll(); 

        return ResponseEntity.ok(workers);
    }



    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> worker(@PathVariable Long id) {

        Worker worker = repository.findById(id).get(); 

        return ResponseEntity.ok(worker);
    }

    
}
