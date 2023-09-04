package com.abdullahturhan.shopping.shopping.controller;

import com.abdullahturhan.shopping.shopping.dto.ProductDto;
import com.abdullahturhan.shopping.shopping.dto.ProductListResponse;
import com.abdullahturhan.shopping.shopping.dto.UpdateProductRequest;
import com.abdullahturhan.shopping.shopping.dto.UpdateProductResponse;
import com.abdullahturhan.shopping.shopping.enumType.Category;
import com.abdullahturhan.shopping.shopping.service.ProductSearchService;
import com.abdullahturhan.shopping.shopping.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {
    private final ProductService productService;
    private final ProductSearchService productSearchService;

    public ProductController(ProductService productService, ProductSearchService productSearchService) {
        this.productService = productService;
        this.productSearchService = productSearchService;
    }
    @GetMapping(path = "/list")
    public ResponseEntity<List<ProductListResponse>> listAll(
            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(productSearchService.listAll(pageSize,pageNumber));
    }
    @GetMapping(path = "/category/{category}")
    public ResponseEntity<List<ProductListResponse>> listByCategory(@PathVariable Category category,
                                                                    @RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
                                                                    @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize){

        return ResponseEntity.status(HttpStatus.FOUND)
                .body(productSearchService.categorySearch(category,pageNumber,pageSize));
    }

    @PostMapping(path = "")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.createOneProduct(productDto));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<UpdateProductResponse> update(@PathVariable Long id, @RequestBody UpdateProductRequest request){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(productService.updateOneProduct(id,request));
    }
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        productService.deleteOneProduct(id);
    }
}
