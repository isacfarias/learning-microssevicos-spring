package com.farias.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import com.farias.hrpayroll.entities.Payment;
import com.farias.hrpayroll.entities.Worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

  @Value("${hr-worker.host}")
  private String workerUrl;

  @Autowired 
  private RestTemplate rest;


  public Payment getPayment(Long workedId, int days) {
    
    Map<String, String> uriVariebles = new HashMap<>();
    uriVariebles.put("id", workedId.toString());

    Worker worker = rest.getForObject(workerUrl + "/workers/{id}", Worker.class, uriVariebles);
    return new Payment(worker.getNome(), 200.0, days);
  };    
} 
