package com.kymdan.backend.services.product_type;

import com.kymdan.backend.entity.ProductType;
import com.kymdan.backend.model.MessageDTO;
import com.kymdan.backend.model.ProductTypeDTO;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> findAllProductType();

    List<ProductType> filterProductTypeByPrice(long price);

    ProductType findProductTypeByID(Long typeID);

    ProductType findProductTypeByName(String name);

    MessageDTO save(ProductTypeDTO productTypeDTO);

    MessageDTO edit(ProductTypeDTO productTypeDTO);
}
