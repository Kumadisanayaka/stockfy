package com.stockify.service;

import com.stockify.model.dto.ProductDTO;
import com.stockify.model.entity.ProductEntity;

public interface ProductService {

    void createProduct(ProductDTO productDTO);

    Iterable<ProductDTO> getProduct(String name);
}
