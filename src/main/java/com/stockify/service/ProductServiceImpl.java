package com.stockify.service;

import com.stockify.model.dto.ProductDTO;
import com.stockify.model.entity.ProductEntity;
import com.stockify.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void createProduct(ProductDTO productDTO) {

        productRepository.save(mapper.convertValue(productDTO, ProductEntity.class));
    }

    @Override
    public Iterable<ProductDTO> getProduct(String name) {

        ArrayList<ProductDTO> productList = new ArrayList<>();

        if (name != null){

            for (ProductEntity entity : productRepository.findAllByNameLike("%" + name + "%")) {
                productList.add(mapper.convertValue(entity,ProductDTO.class));
            }

        }else {

            for (ProductEntity entity : productRepository.findAll()) {
                productList.add(mapper.convertValue(entity, ProductDTO.class));
            }
        }

        return productList;

    }
}
