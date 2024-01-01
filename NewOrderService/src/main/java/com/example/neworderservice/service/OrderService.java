package com.example.neworderservice.service;

import com.example.neworderservice.entity.Order;
import com.example.neworderservice.entity.OrderRequestObject;
import com.example.neworderservice.entity.Payment;
import com.example.neworderservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderService {

    public static Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    OrderRepository orderRepo;

    @Autowired
    @Lazy
    RestTemplate restTemplate;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String PAYMENT_URL;


    public void handleorderPlacement(OrderRequestObject orderRequestObject) {
        log.info("handleorderPlacement:     ");
        saveOrder(orderRequestObject.getOrder());
        Payment paymentObj = orderRequestObject.getPayment();
        paymentObj.setOrderId(orderRequestObject.getOrder().getId().toString());
        paymentObj.setAmount(orderRequestObject.getOrder().getPrice());
        callPaymentAPI(paymentObj);
    }

    private void callPaymentAPI(Payment paymentObj) {
        log.info("callPaymentAPI :   ");
        //restTemplate.postForObject("http://PAYMENT-SERVICE/payment", paymentObj, Payment.class); <- This is for service registry call without cloud config
        restTemplate.postForObject(PAYMENT_URL, paymentObj, Payment.class);
    }

    public void saveOrder(Order order){
        log.info("saveOrder :   ");
        orderRepo.save(order);
    }

    public Order getOrder() {
        log.info("getOrder :   ");
        return orderRepo.getReferenceById(1L);
    }

}
