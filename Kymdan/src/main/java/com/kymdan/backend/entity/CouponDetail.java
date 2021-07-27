package com.kymdan.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "coupon_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CouponDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "amount", columnDefinition = "VARCHAR(50)")
    private String amount;

    @Column(name = "price", columnDefinition = "VARCHAR(50)")
    private String price;

    @Column(name = "size", columnDefinition = "VARCHAR(50)")
    private String size;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coupon_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Coupon coupon;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Product product;
}
