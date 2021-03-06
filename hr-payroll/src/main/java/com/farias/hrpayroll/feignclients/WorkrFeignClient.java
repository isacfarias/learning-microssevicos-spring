package com.farias.hrpayroll.feignclients;

import com.farias.hrpayroll.entities.Worker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", path = "/workers" )
public interface WorkrFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Worker> worker(@PathVariable Long id);
    
}
