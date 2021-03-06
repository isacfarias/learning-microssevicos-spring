package com.farias.hrwork.resources;

import java.util.List;

import com.farias.hrwork.entities.Worker;
import com.farias.hrwork.repositories.WorkRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping( value = "/workers")
public class WorkResource {

    private static Logger log = LoggerFactory.getLogger(WorkResource.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment env;

    @Autowired
    private WorkRepository repository;


    @GetMapping(value = "/config")
    public ResponseEntity<Void> config() {
        log.info("CONFIG: "+ testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> listaWorkers() {

        List<Worker> workers = repository.findAll(); 

        return ResponseEntity.ok(workers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> worker(@PathVariable Long id) {
        log.info("PORT: "+ env.getProperty("local.server.port"));

//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Worker worker = repository.findById(id).get(); 
        return ResponseEntity.ok(worker);
    }
}
