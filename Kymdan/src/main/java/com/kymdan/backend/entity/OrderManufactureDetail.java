package com.kymdan.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "order_manufacture_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderManufactureDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "amount", columnDefinition = "VARCHAR(250)")
    private String amount;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_manufacture_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private OrderManufacture orderManufacture;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Product product;
}
