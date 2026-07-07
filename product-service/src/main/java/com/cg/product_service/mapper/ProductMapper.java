package com.cg.product_service.mapper;


import com.cg.product_service.dto.ProductRequest;
import com.cg.product_service.dto.ProductResponse;
import com.cg.product_service.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request){

        return Product.builder()
                .name(request.name())
                .price(request.price())
                .quantity(request.quantity())
                .build();
    }

    public ProductResponse toResponse(Product product){

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }
}
