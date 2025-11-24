package ws_orders_wimf.dto;

import ws_orders_wimf.entities.Item;

public record ItemResponse(Long itemId, String name, Double price, Integer quantity) {
    public static ItemResponse fromEntity(Item item) {
        return new ItemResponse(item.getItemId(), item.getName(), item.getPrice(), item.getQuantity());
    }
}
