package com.kymdan.backend.controllers;

import com.kymdan.backend.entity.Product;
import com.kymdan.backend.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/view/{typeID}")
    public ResponseEntity<List<Product>> findProductByType(@PathVariable Long typeID) {
        List<Product> productList = this.productService.findProductByType(typeID);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
