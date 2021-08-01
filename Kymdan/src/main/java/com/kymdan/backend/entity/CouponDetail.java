package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coupon_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Coupon coupon;

    @OneToOne(mappedBy = "couponDetail", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private Product product;
}
