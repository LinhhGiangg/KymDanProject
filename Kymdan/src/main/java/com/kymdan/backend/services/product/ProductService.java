package com.kymdan.backend.services.product;

import com.kymdan.backend.entity.Product;
import com.kymdan.backend.model.MessageDTO;

import java.util.List;

public interface ProductService {
    List<Product> findProductByType(Long typeID);

    List<Product> filterProductByTypeAndPrice(Long typeID, long price);

    Product findProductByID(Long id);

    MessageDTO saveCart(Long customerID, Long productID, String productInformation);
}
