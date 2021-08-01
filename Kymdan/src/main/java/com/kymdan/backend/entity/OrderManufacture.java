package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "order_manufacture")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderManufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "order_date", columnDefinition = "DATE")
    private LocalDate orderDate;

    // relationship

    @OneToOne
    @JoinColumn(name = "coupon_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Coupon coupon;

    @OneToMany(mappedBy = "orderManufacture", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<OrderManufactureDetail> orderManufactureDetailList;
}
