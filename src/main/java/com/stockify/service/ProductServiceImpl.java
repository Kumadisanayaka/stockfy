package com.stockify.service;

import com.stockify.model.dto.ProductDTO;
import com.stockify.model.entity.ProductEntity;
import com.stockify.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public void createProduct(ProductDTO productDTO) {

        ProductEntity entity = new ProductEntity();
        entity.setName(productDTO.getName());
        entity.setPrice(productDTO.getPrice());
        entity.setDescription(productDTO.getDescription());
        entity.setImageUrl(productDTO.getImageUrl());

        productRepository.save(entity);
    }

    @Override
    public Iterable<ProductEntity> getProduct() {

        return productRepository.findAll();
    }
}
