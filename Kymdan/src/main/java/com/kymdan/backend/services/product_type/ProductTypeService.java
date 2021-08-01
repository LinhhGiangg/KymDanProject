package com.kymdan.backend.services.product_type;

import com.kymdan.backend.entity.ProductType;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> findAllProductType();

    List<ProductType> filterProductTypeByPrice(long price);

    ProductType findProductTypeByID(Long typeID);
}
