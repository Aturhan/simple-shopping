package com.abdullahturhan.shopping.shopping.service;

import com.abdullahturhan.shopping.shopping.dto.ProductListResponse;
import com.abdullahturhan.shopping.shopping.entity.Product;
import com.abdullahturhan.shopping.shopping.enumType.Category;
import com.abdullahturhan.shopping.shopping.respository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductSearchService {
    private final ProductRepository productRepository;

    public ProductSearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductListResponse> listAll(int pageSize, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Product> products = productRepository.findAll(pageable);
        List<Product> listOfProducts = products.getContent();
        return listOfProducts.stream().map(model-> ProductListResponse.builder()
                .name(model.getName())
                .price(model.getPrice())
                .amount(model.getAmount())
                .category(model.getCategory())
                .build()).collect(Collectors.toList());
    }

    public List<ProductListResponse> categorySearch(Category category, int pageSize, int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Product> products = productRepository.findByCategory(category,pageable);
        List<Product> listOfProducts = products.getContent();
        return listOfProducts.stream().map(model-> ProductListResponse.builder()
                .name(model.getName())
                .price(model.getPrice())
                .amount(model.getAmount())
                .category(model.getCategory())
                .build()).collect(Collectors.toList());

    }

}
