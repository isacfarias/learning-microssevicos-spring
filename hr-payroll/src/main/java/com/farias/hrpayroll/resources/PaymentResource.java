package com.farias.hrpayroll.resources;

import com.farias.hrpayroll.entities.Payment;
import com.farias.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {


    @Autowired
    private PaymentService service;


    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workedId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workedId,  @PathVariable int days) {
        Payment payment = service.getPayment(workedId, days);
        return  ResponseEntity.ok(payment);
    }


    public ResponseEntity<Payment> getPaymentAlternative(Long workedId, int days) {
        Payment payment = new Payment("Bran", 400.0, days);
        return  ResponseEntity.ok(payment);
    }

}
