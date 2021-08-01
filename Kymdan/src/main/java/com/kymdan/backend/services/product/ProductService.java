package com.kymdan.backend.services.product;

import com.kymdan.backend.entity.Product;
import com.kymdan.backend.model.MessageDTO;

import java.util.List;

public interface ProductService {
    List<Product> findProductByType(Long typeID);

    MessageDTO saveCart(String userName, Long productID, String productInformation);
}
