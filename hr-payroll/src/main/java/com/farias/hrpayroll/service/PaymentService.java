package com.farias.hrpayroll.service;

import com.farias.hrpayroll.entities.Payment;
import com.farias.hrpayroll.entities.Worker;
import com.farias.hrpayroll.feignclients.WorkrFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


  @Autowired 
  private WorkrFeignClient workrFeignClient;


  public Payment getPayment(Long workedId, int days) {

    Worker worker = workrFeignClient.worker(workedId).getBody();

    return new Payment(worker.getName(), 200.0, days);
  };    
} 
