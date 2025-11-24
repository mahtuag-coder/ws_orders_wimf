package ws_orders_wimf.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ws_orders_wimf.dto.OrderResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventsPublisherService {
    private static final String ORDER_CREATED_TOPIC = "wsmy-order-created";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishOrderCreatedEvent(OrderResponse orderResponse) {
        kafkaTemplate.send(ORDER_CREATED_TOPIC, orderResponse);
        log.info("Order created event sent for Order ID: {}", orderResponse.orderId());
    }
}
