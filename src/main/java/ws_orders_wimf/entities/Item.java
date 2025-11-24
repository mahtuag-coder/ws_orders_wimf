package ws_orders_wimf.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false, updatable = false)
    private Long itemId;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    @Min(1)
    @NotNull
    @PositiveOrZero
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @CreationTimestamp
    @Column(name = "crt_ts")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "upd_ts")
    private LocalDateTime updatedAt;
}
