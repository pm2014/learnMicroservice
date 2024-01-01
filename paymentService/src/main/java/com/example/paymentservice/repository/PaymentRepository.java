package com.example.paymentservice.repository;

import com.example.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/*
http://localhost:9191/h2-console/
*/
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
