package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "manufacture")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(name = "address", columnDefinition = "VARCHAR(50)")
    private String address;

    @Column(name = "mail", columnDefinition = "VARCHAR(50)")
    private String mail;

    @Column(name = "phone", columnDefinition = "VARCHAR(50)")
    private String phone;

    // relationship

    @OneToMany(mappedBy = "manufacture", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ProductType> productTypeList;
}
