package ws_orders_wimf.dto;

import ws_orders_wimf.entities.Item;

public record ItemRequest(String name, Double price, Integer quantity) {

    public Item toEntity() {
        return Item.builder()
                 .name(this.name())
                .price(this.price())
                .quantity(this.quantity())
                .build();
    }
}
