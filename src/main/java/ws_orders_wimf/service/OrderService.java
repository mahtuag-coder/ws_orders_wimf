package ws_orders_wimf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ws_orders_wimf.dto.OrderRequest;
import ws_orders_wimf.dto.OrderResponse;
import ws_orders_wimf.entities.Order;
import ws_orders_wimf.exceptions.OrderException;
import ws_orders_wimf.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderException("Order with id " + id + " not found"));

        return OrderResponse.fromEntity(order);
    }

    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order savedOrder = orderRepository.save(orderRequest.toEntity());
        return OrderResponse.fromEntity(savedOrder);
    }
}
