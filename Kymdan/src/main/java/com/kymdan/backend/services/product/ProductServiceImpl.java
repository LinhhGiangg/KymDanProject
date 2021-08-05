package com.kymdan.backend.services.product;

import com.kymdan.backend.entity.Product;
import com.kymdan.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findProductByType(Long typeID) {
        List<Product> result = new ArrayList<>();
        List<Product> allProduct = this.productRepository.findAll();

        for (Product product : allProduct) {
            if (product.getProductType().getId().equals(typeID)) {
                result.add(product);
            }
        }

        return result;
    }
}
