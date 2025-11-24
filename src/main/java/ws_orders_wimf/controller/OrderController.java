package ws_orders_wimf.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws_orders_wimf.dto.OrderRequest;
import ws_orders_wimf.dto.OrderResponse;
import ws_orders_wimf.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        OrderResponse order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody @Valid  OrderRequest orderRequest) {
        OrderResponse order = orderService.createOrder(orderRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(order);
    }
}
