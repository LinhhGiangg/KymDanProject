package com.kymdan.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "length", columnDefinition = "VARCHAR(50)")
    private String length;

    @Column(name = "width", columnDefinition = "VARCHAR(50)")
    private String width;

    @Column(name = "thick", columnDefinition = "VARCHAR(50)")
    private String thick;

    @Column(name = "price", columnDefinition = "VARCHAR(50)")
    private String price;

    @Column(name = "amount", columnDefinition = "VARCHAR(50)")
    private String amount;

    @Column(name = "discount", columnDefinition = "VARCHAR(50)")
    private String discount;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private ProductType productType;

    @OneToOne
    @JoinColumn(name = "order_detail_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private OrderDetail orderDetail;

    @OneToOne
    @JoinColumn(name = "coupon_detail_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private CouponDetail couponDetail;

    @OneToOne
    @JoinColumn(name = "order_manufacture_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private OrderManufactureDetail orderManufactureDetail;

    @OneToOne
    @JoinColumn(name = "cart_detail_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private CartDetail cartDetail;
}
