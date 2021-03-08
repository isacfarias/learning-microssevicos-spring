package com.farias.hrpayroll.service;

import com.farias.hrpayroll.entities.Payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workedId, int days) {

        return new Payment("Bob", 200.0, days);

      };
    
} 
