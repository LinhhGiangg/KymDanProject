package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "product_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "type_name", columnDefinition = "VARCHAR(50)")
    private String typeName;

    @Column(name = "description", columnDefinition = "VARCHAR(250)")
    private String description;

    @Column(name = "image1", columnDefinition = "VARCHAR(250)")
    private String image1;

    @Column(name = "image2", columnDefinition = "VARCHAR(250)")
    private String image2;

    @Column(name = "image3", columnDefinition = "VARCHAR(250)")
    private String image3;

    @Column(name = "price", columnDefinition = "VARCHAR(50)")
    private String price;

    // relationship

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Product> productList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacture_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private Manufacture manufacture;

    @OneToOne
    @JoinColumn(name = "promotion_detail_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private PromotionDetail promotionDetail;
}
