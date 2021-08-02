package com.kymdan.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductTypeDTO {
    private String typeName;
    private String description;
    private String image;
    private String price;
}
