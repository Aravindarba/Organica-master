package com.organica.controllers;


import com.organica.payload.PaymentDetails;
import com.organica.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private  PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

//    @Autowired
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    @GetMapping("/{amount}")
    public ResponseEntity<PaymentDetails> CreatePayment(@PathVariable Double amount){
        PaymentDetails paymentDetails = this.paymentService.CreateOrder(amount);
        return new ResponseEntity<>(paymentDetails, HttpStatusCode.valueOf(200));
    }

}
