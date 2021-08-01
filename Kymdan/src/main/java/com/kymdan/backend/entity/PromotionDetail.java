package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "promotion_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "discount", columnDefinition = "VARCHAR(50)")
    private String discount;

    // relationship

    @OneToOne(mappedBy = "promotionDetail", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private ProductType productType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "promotion_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Promotion promotion;
}
