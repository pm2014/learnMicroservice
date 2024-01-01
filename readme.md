Eureka Service registry : 
http://localhost:8761/

Zipkin Observability : 
http://localhost:9411/zipkin

To access H2 console : 
order service : http://localhost:9192/h2-console/ , db : dbc:h2:mem:mydb 
payment service : http://localhost:9192/h2-console/ , db :  jdbc:h2:mem:paymentdb

cURL : 
order service :
ApiGateway :
curl --location --request POST 'http://localhost:8989/order' \
--header 'Content-Type: application/json' \
--data-raw '{
    "order" : {"name" : "pragya",
    "qty" : 123,
    "price" : 345
    },
    "payment" : {
        
    }
}'

curl --location --request POST 'http://localhost:9192/order' \
--header 'Content-Type: application/json' \
--data-raw '{
    "order" : {"name" : "pragya",
    "qty" : 123,
    "price" : 345
    },
    "payment" : {
        
    }
}'

cURL : 
payment service :
ApiGateway :
curl --location --request POST 'http://localhost:8989/payment' \
--header 'Content-Type: application/json' \
--data-raw '{
    "paymentStatus" : "auto",
    "trxId" : "123"
}'

curl --location --request POST 'http://localhost:9193/payment' \
--header 'Content-Type: application/json' \
--data-raw '{
    "paymentStatus" : "auto",
    "trxId" : "123"
}'
