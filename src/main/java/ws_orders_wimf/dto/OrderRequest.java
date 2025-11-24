package ws_orders_wimf.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import ws_orders_wimf.entities.Item;
import ws_orders_wimf.entities.Order;

import java.util.List;

public record OrderRequest(
        String orderStatus,
        @NotBlank String customerName,
        @NotBlank String customerPhone,
        @NotBlank String deliveryAddress,
        @NotEmpty List<ItemRequest> itemRequests) {

    public Order toEntity() {
        Order order = Order.builder()
                .orderStatus("CREATED")
                .customerPhone(this.customerPhone())
                .customerName(this.customerName())
                .deliveryAddress(this.deliveryAddress())
                .build();

        List<Item> items = this.itemRequests().stream()
                .map(ItemRequest::toEntity).toList();

        order.addItems(items);

        return order;
    }
}
