package com.stockify.controller;

import com.stockify.model.dto.ProductDTO;
import com.stockify.model.entity.ProductEntity;
import com.stockify.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/product/create")
    public void createProduct(@RequestBody ProductDTO productDTO){
        service.createProduct(productDTO);
    }
    @GetMapping("/product/all")
    public Iterable<ProductEntity> getProduct(){

        return service.getProduct();
    }
}
