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
        List<Product> allProduct = this.productRepository.findAll();
        List<Product> productList = new ArrayList<>();

        for (Product product : allProduct) {
            if (product.getProductType().getId().equals(typeID)) {
                productList.add(product);
            }
        }

        return productList;
    }

    @Override
    public List<Product> filterProductByTypeAndPrice(Long typeID, long price) {
        List<Product> result = new ArrayList<>();
        List<Product> productList = findProductByType(typeID);

        for (Product product : productList) {
            if (price == 6) {
                if (Long.parseLong(product.getPrice()) >= (50000000)) {
                    result.add(product);
                }
                continue;
            }

            if (((price - 1) * 10000000) <= Long.parseLong(product.getPrice())
                    && Long.parseLong(product.getPrice()) <= (price * 10000000)) {
                result.add(product);
            }
        }

        return result;
    }
}
