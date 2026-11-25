package com.stockify.controller;

import com.stockify.model.dto.ProductDTO;
import com.stockify.model.entity.ProductEntity;
import com.stockify.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/product")
@Slf4j
public class ProductController {

    private final ProductService service;

    @PostMapping()
    void createProduct(@RequestBody ProductDTO productDTO)
    {
        log.info(productDTO.toString());
        service.createProduct(productDTO);
    }

    @GetMapping()
    Iterable<ProductDTO> getProduct(){

        return service.getProduct();
    }
}
