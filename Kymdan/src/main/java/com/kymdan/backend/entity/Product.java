package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    @Column(name = "name", columnDefinition = "VARCHAR(250)")
    private String name;

    @Column(name = "length", columnDefinition = "VARCHAR(250)")
    private String length;

    @Column(name = "width", columnDefinition = "VARCHAR(250)")
    private String width;

    @Column(name = "height", columnDefinition = "VARCHAR(250)")
    private String height;

    @Column(name = "price", columnDefinition = "VARCHAR(250)")
    private String price;

    @Column(name = "title", columnDefinition = "VARCHAR(250)")
    private String title;

    @Column(name = "description", columnDefinition = "VARCHAR(250)")
    private String description;

    @Column(name = "amount", columnDefinition = "VARCHAR(250)")
    private String amount;

    @Column(name = "url", columnDefinition = "VARCHAR(250)")
    private String url;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private ProductType productType;

    @OneToOne
    @JoinColumn(name = "order_detail_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private OrderDetail orderDetail;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private CouponDetail couponDetail;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private OrderManufactureDetail orderManufactureDetail;

    @OneToOne
    @JoinColumn(name = "cart_detail_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private CartDetail cartDetail;
}
