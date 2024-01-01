package com.example.paymentservice.service;

import com.example.paymentservice.entity.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {
    public static Logger log = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentRepository paymentRepository;

    public void savePayment(Payment payment){
        log.info("savePayment:   ");
        payment.setTrxId(UUID.randomUUID().toString());
        log.info("payment Object:   " + payment.toString());
        paymentRepository.save(payment);
    }
}
