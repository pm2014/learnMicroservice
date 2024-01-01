package com.example.paymentservice.controller;

import com.example.paymentservice.entity.Payment;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*curl --location --request POST 'http://localhost:9191/payment' \
        --header 'Content-Type: application/json' \
        --data-raw '{
        "paymentStatus" : "done",
        "trxId" : "123"
        }'*/

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    public void doPayment(@RequestBody Payment pay){
        paymentService.savePayment(pay);
    }
}
