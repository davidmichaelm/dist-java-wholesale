package edu.wctc.wholesale.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name="wholesale_order")
public class WholesaleOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private int id;

    @JoinColumn(name="customer_id")
    @ManyToOne
    private Customer customer;

    @JoinColumn(name="product_id")
    @ManyToOne
    private Product product;

    @Column(name="purchase_date")
    private LocalDateTime purchaseDate;

    @Column(name="purchase_order_num")
    private String purchaseOrderNumber;

    @Column
    private String terms;

    @Column(name="shipped_date")
    private LocalDateTime shippedDate;
}
