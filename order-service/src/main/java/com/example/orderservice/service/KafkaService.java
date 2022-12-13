package com.example.orderservice.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class KafkaService {

    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    private final ObjectMapper objectMapper;

    public KafkaService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(groupId = "spring-orders-consumer", topics = {"inventory.inventory.orders"})
    public void listen(ConsumerRecord<String, String> record) throws JsonProcessingException {
        logger.info(record.key());
        logger.info(record.value());
        logger.info(record.topic());
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.topic());
        JsonNode root = objectMapper.readTree(record.value());
        JsonNode payload = root.get("payload");
        JsonNode payloadAfter = payload.get("after");
        logger.info(root.toString());
        logger.info(payload.toString());
        OrderPayload order = objectMapper.treeToValue(payloadAfter, OrderPayload.class);
        logger.info(order.toString());
        //ResponsePojo response = objectMapper.readValue(record.value(), ResponsePojo.class);
    }
}

@Data
class OrderPayload {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("order_date")
    private LocalDate orderDate;
    @JsonProperty("purchaser")
    private Integer purchaser;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("product_id")
    private Integer productId;
}

//Simple POJO representing the Debezium returned object from reading pgsql WAL
//With default Kafka Connect settings payload includes a lot of unnecessary info
//Really only care about the 'after' object inside the 'payload' object
@Data
class ResponsePojo {
    @JsonProperty
    JsonNode schema;
    @JsonProperty
    JsonNode payload;
}
