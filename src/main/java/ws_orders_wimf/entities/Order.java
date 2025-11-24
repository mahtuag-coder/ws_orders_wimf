package ws_orders_wimf.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",  nullable = false, updatable = false)
    private Long orderId;

    @NotBlank
    @Column(name="order_status")
    private String orderStatus = "PENDING";

    @NotBlank
    @Column(name = "cust_name")
    private String customerName;

    @NotBlank
    @Column(name = "cust_phone")
    private String customerPhone;

    @NotBlank
    @Column(name = "del_addr")
    private String deliveryAddress;

    @CreationTimestamp
    @Column(name = "crt_ts")
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "del_ts")
    private LocalDateTime modifiedDate;

    @Column(name = "upd_ts")
    private LocalDateTime deliveryDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();

    public void addItems(List<Item> items) {
        if (this.items == null) this.items = new ArrayList<>();
        for (Item item : items) {
            item.setOrder(this);
            this.items.add(item);
        }
    }

}
