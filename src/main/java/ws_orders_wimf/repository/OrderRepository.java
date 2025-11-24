package ws_orders_wimf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws_orders_wimf.dto.OrderResponse;
import ws_orders_wimf.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    OrderResponse getOrderByOrderId(Long orderId);
}
