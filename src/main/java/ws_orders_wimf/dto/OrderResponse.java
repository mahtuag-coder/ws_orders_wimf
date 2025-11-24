package ws_orders_wimf.dto;

import ws_orders_wimf.entities.Order;

import java.util.List;

public record OrderResponse(Long orderId, String orderStatus, String customerName,
                            String customerPhone, String deliveryAddress, List<ItemResponse> items) {

    public static OrderResponse fromEntity(Order order) {
        List<ItemResponse> items = order.getItems().stream()
                .map(ItemResponse::fromEntity)
                .toList();

        return new OrderResponse(order.getOrderId(),
                order.getOrderStatus(),
                order.getCustomerName(),
                order.getCustomerPhone(),
                order.getDeliveryAddress(),
                items);
    }
}
