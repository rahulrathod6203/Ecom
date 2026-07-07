package com.cg.product_service.service;

import com.cg.product_service.dto.ProductRequest;
import com.cg.product_service.dto.ProductResponse;
import com.cg.product_service.mapper.ProductMapper;
import com.cg.product_service.model.Product;
import com.cg.product_service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private final ProductMapper mapper;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {

        Product product = mapper.toEntity(productRequest);
        log.info("Product details, {}",product);
        Product savedProduct = productRepository.save(product);
        return mapper.toResponse(savedProduct);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productRepository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(()-> new RuntimeException("Product not found with ID: "+id));

    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        product.setQuantity(productRequest.quantity());

        Product updatedProduct = productRepository.save(product);
        return mapper.toResponse(updatedProduct);
    }

    @Override
    public String deleteProductById(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
        productRepository.deleteById(id);
        return "Product deleted successfully! with id : "+id;
    }
}
