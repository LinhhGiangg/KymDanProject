package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "cart_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "amount", columnDefinition = "VARCHAR(50)")
    private String amount;

    @Column(name = "real_price", columnDefinition = "VARCHAR(50)")
    private String realPrice;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Cart cart;

    @OneToOne(mappedBy = "cartDetail", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private Product product;
}
