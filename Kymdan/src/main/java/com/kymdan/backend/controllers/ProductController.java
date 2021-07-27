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

    @GetMapping("/list/{typeID}")
    public ResponseEntity<List<Product>> findProductByType(@PathVariable Long typeID) {
        List<Product> productList = this.productService.findProductByType(typeID);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/list/{typeID}/{price}")
    public ResponseEntity<List<Product>> filterProductByTypeAndPrice(@PathVariable Long typeID,
                                                                     @PathVariable long price) {
        List<Product> productList = this.productService.filterProductByTypeAndPrice(typeID, price);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/view/{productID}")
    public ResponseEntity<Product> findProductByID(@PathVariable Long productID) {
        Product product = this.productService.findProductByID(productID);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/save-cart/{customerID}/{productID}/{productInformation}")
    public ResponseEntity<?> saveCart(@PathVariable Long customerID, @PathVariable Long productID,
                                      @PathVariable String productInformation) {
        return new ResponseEntity<>(this.productService.saveCart(customerID, productID, productInformation),
                HttpStatus.OK);
    }
}
