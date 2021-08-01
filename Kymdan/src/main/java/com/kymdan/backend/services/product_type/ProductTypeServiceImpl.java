package com.kymdan.backend.services.product_type;

import com.kymdan.backend.entity.ProductType;
import com.kymdan.backend.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> findAllProductType() {
        return this.productTypeRepository.findAll();
    }

    @Override
    public List<ProductType> filterProductTypeByPrice(long price) {
        List<ProductType> result = new ArrayList<>();
        List<ProductType> productTypeList = this.productTypeRepository.findAll();

        for (ProductType productType : productTypeList) {
            if (price == 6) {
                if (Long.parseLong(productType.getPrice()) >= (50000000)) {
                    result.add(productType);
                }
                continue;
            }

            if (((price - 1) * 10000000) <= Long.parseLong(productType.getPrice())
                    && Long.parseLong(productType.getPrice()) <= (price * 10000000)) {
                result.add(productType);
            }
        }

        return result;
    }

    @Override
    public ProductType findProductTypeByID(Long typeID) {
        return this.productTypeRepository.findById(typeID).orElse(null);
    }
}
