package com.kymdan.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "app_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "username", columnDefinition = "VARCHAR(50)")
    private String username;

    @Column(name = "password", columnDefinition = "VARCHAR(250)")
    private String password;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "app_role_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private AppRole appRole;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "shipper_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Shipper shipper;

    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Cart cart;
}
