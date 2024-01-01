package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*curl --location --request POST 'http://localhost:8989/order' \
        --header 'Content-Type: application/json' \
        --data-raw '{
        "order" : {"name" : "pragya",
        "qty" : 100,
        "price" : 101
        },
        "payment" : {

        }
        }'*/

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}
