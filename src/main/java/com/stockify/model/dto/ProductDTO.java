package com.stockify.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductDTO {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private String imageUrl;

}
