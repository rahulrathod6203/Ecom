package com.cg.product_service.service;

import com.cg.product_service.dto.ProductRequest;
import com.cg.product_service.dto.ProductResponse;
import com.cg.product_service.model.Product;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    ProductResponse updateProduct(Long id, ProductRequest productRequest);

    String deleteProductById(Long id);
}
