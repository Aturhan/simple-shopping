package com.abdullahturhan.shopping.shopping.service;

import com.abdullahturhan.shopping.shopping.dto.ProductDto;
import com.abdullahturhan.shopping.shopping.dto.UpdateProductRequest;
import com.abdullahturhan.shopping.shopping.dto.UpdateProductResponse;
import com.abdullahturhan.shopping.shopping.entity.MarketOwner;
import com.abdullahturhan.shopping.shopping.entity.Product;
import com.abdullahturhan.shopping.shopping.respository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final MarketOwnerService marketOwnerService;

    public ProductService(ProductRepository productRepository, MarketOwnerService marketOwnerService) {
        this.productRepository = productRepository;
        this.marketOwnerService = marketOwnerService;
    }

    public Product findOneProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) throw new RuntimeException("Product not found");

        return Product.builder()
                .id(product.get().getId())
                .name(product.get().getName())
                .amount(product.get().getAmount())
                .category(product.get().getCategory())
                .price(product.get().getPrice())
                .build();
    }

    @Transactional
    public ProductDto createOneProduct(ProductDto productDto){
        Optional<MarketOwner> owner = marketOwnerService.findOne(productDto.getOwnerId());
        if(owner.isEmpty()){
            throw new RuntimeException("Owner not found");
        }
        final Product product = Product.builder()
                .name(productDto.getName())
                .amount(productDto.getAmount())
                .category(productDto.getCategory())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .marketOwner(owner.get())
                .build();
        final Product savedProduct = productRepository.save(product);
        return ProductDto.builder()
                .name(savedProduct.getName())
                .amount(savedProduct.getAmount())
                .category(savedProduct.getCategory())
                .price(savedProduct.getPrice())
                .ownerId(savedProduct.getMarketOwner().getId())
                .build();

    }
    @Transactional
    public UpdateProductResponse updateOneProduct(Long id, UpdateProductRequest request){
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new RuntimeException("Product not found");
        }
        final Product product = Product.builder()
                .price(productOptional.get().getPrice())
                .amount(productOptional.get().getAmount())
                .build();
        final Product updatedProduct = productRepository.save(product);
        return UpdateProductResponse.builder()
                .name(updatedProduct.getName())
                .amount(updatedProduct.getAmount())
                .price(updatedProduct.getPrice())
                .category(updatedProduct.getCategory())
                .build();
    }
    @Transactional
    public void updateAmount(Long id,Integer amount){
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(model ->{
            model.setAmount(amount);
            productRepository.save(model);
        });





    }

    @Transactional
    public void deleteOneProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        optionalProduct.ifPresent(productRepository::delete);
    }


}

