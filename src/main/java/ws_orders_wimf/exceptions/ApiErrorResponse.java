package ws_orders_wimf.exceptions;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ApiErrorResponse(LocalDateTime timestamp, String message) {
}
