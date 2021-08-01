package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "full_name", columnDefinition = "VARCHAR(50)")
    private String fullName;

    @Column(name = "gender", columnDefinition = "VARCHAR(50)")
    private String gender;

    @Column(name = "birthday", columnDefinition = "DATE")
    private LocalDate birthday;

    @Column(name = "address", columnDefinition = "VARCHAR(50)")
    private String address;

    @Column(name = "phone", columnDefinition = "VARCHAR(50)")
    private String phone;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;

    // relationship

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private AppAccount appAccount;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<OrderProduct> orderList;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Promotion> promotionList;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Coupon> couponList;
}
