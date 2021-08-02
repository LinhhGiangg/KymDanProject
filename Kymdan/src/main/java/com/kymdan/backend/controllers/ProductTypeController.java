package com.kymdan.backend.controllers;

import com.kymdan.backend.entity.ProductType;
import com.kymdan.backend.model.MessageDTO;
import com.kymdan.backend.model.ProductTypeDTO;
import com.kymdan.backend.services.product_type.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productType")
@CrossOrigin
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductType>> findAllProductType() {
        List<ProductType> productTypeList = this.productTypeService.findAllProductType();
        return new ResponseEntity<>(productTypeList, HttpStatus.OK);
    }

    @GetMapping("/list/{price}")
    public ResponseEntity<List<ProductType>> filterProductTypeByPrice(@PathVariable Long price) {
        List<ProductType> productTypeList = this.productTypeService.filterProductTypeByPrice(price);
        return new ResponseEntity<>(productTypeList, HttpStatus.OK);
    }

    @GetMapping("/find/{typeID}")
    public ResponseEntity<ProductType> findProductTypeByID(@PathVariable Long typeID) {
        ProductType productType = this.productTypeService.findProductTypeByID(typeID);
        return new ResponseEntity<>(productType, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addNewProductType(@RequestBody ProductTypeDTO productTypeDTO) {
        if (productTypeService.findProductTypeByName(productTypeDTO.getTypeName()) != null) {
            return ResponseEntity.ok(new MessageDTO("Loại sản phẩm này đã có !"));
        } else {
            return ResponseEntity.ok(productTypeService.save(productTypeDTO));
        }
    }
}
