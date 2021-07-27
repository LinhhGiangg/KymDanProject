package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "coupon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "create_date", columnDefinition = "DATE")
    private LocalDate createDate;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "order_manufacture_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private OrderManufacture orderManufacture;

    @OneToMany(mappedBy = "coupon", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<CouponDetail>  couponDetailList;
}
