package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<OrderDetail> orderDetailList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<OrderManufactureDetail> orderManufactureDetailList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<CouponDetail> couponDetailList;
}
