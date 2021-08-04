package com.kymdan.backend.services.product_type;

import com.kymdan.backend.entity.ProductType;
import com.kymdan.backend.model.MessageDTO;
import com.kymdan.backend.model.ProductTypeDTO;
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

        if (price == 7) {
            result = productTypeList;
        } else {
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
        }

        return result;
    }

    @Override
    public ProductType findProductTypeByID(Long typeID) {
        return this.productTypeRepository.findById(typeID).orElse(null);
    }

    @Override
    public ProductType findProductTypeByName(String name) {
        return this.productTypeRepository.findByTypeName(name);
    }

    @Override
    public MessageDTO save(ProductTypeDTO productTypeDTO) {
        ProductType productType = new ProductType();
        productType.setTypeName(productTypeDTO.getTypeName());
        productType.setDescription(productTypeDTO.getDescription());
        productType.setImage1(productTypeDTO.getImage());
        productType.setImage2("https://www.kymdan.com/attachment.do?file=attachment/6542/nem_kymdan_deluxe_02.jpg");
        productType.setImage3("https://www.kymdan.com/attachment.do?file=attachment/6140/nem%20kymdan%20deluxe.jpg");
        productType.setPrice(productTypeDTO.getPrice());
        this.productTypeRepository.save(productType);

        return new MessageDTO("Thêm thành công !");
    }

    @Override
    public MessageDTO edit(ProductTypeDTO productTypeDTO) {
        ProductType productType = this.productTypeRepository.findByTypeName(productTypeDTO.getTypeName());
        productType.setDescription(productTypeDTO.getDescription());
        productType.setImage1(productTypeDTO.getImage());
        productType.setPrice(productTypeDTO.getPrice());
        this.productTypeRepository.save(productType);

        return new MessageDTO("Sửa thành công !");
    }

    @Override
    public MessageDTO delete(String name) {
        ProductType productType = this.productTypeRepository.findByTypeName(name);
        if (productType.getProductList().size() == 0) {
            this.productTypeRepository.delete(productType);
            return new MessageDTO("Xóa thành công !");
        } else {
            return new MessageDTO("Loại này có sản phẩm đang trưng bày nên không thể xóa !");
        }
    }
}
