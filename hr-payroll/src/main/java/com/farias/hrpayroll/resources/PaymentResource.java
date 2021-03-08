package com.farias.hrpayroll.resources;

import com.farias.hrpayroll.entities.Payment;
import com.farias.hrpayroll.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {



    @Autowired
    private PaymentService service;


    @GetMapping("/{workedId}/days/{days}")
    public ResponseEntity<Payment> getMethodName(@PathVariable Long workedId,  @PathVariable int days) {
        Payment payment = service.getPayment(workedId, days);
        return  ResponseEntity.ok(payment);
    }
}
