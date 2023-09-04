package com.abdullahturhan.shopping.shopping.service;

import com.abdullahturhan.shopping.shopping.dto.ShoppingCartDto;
import com.abdullahturhan.shopping.shopping.dto.ShoppingCartResponse;
import com.abdullahturhan.shopping.shopping.entity.Product;
import com.abdullahturhan.shopping.shopping.entity.ShoppingCart;
import com.abdullahturhan.shopping.shopping.entity.User;
import com.abdullahturhan.shopping.shopping.respository.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserService userService;
    private final ProductService productService;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, UserService userService, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userService = userService;
        this.productService = productService;
    }
    @Transactional
    public ShoppingCartResponse createShoppingCart(ShoppingCartDto shoppingCartDto){
        User user =  userService.findOneUser(shoppingCartDto.getUserId());
        Product product = productService.findOneProduct(shoppingCartDto.getProductId());

        if (product ==  null || user == null){
            throw new RuntimeException("user or product not found");
        }

        final Integer totalAmount = shoppingCartDto.getAmountItem();
        final Integer amountProduct = product.getAmount();
        if(totalAmount > amountProduct){
            throw  new RuntimeException("Not enough amount of product in stock");
        }
        final Integer newAmount = amountProduct - totalAmount;
        productService.updateAmount(product.getId(), newAmount);
        final Double totalPrice = product.getPrice() * totalAmount;

        ShoppingCart shoppingCart = ShoppingCart.builder()
                .amountItem(totalAmount)
                .user(user)
                .totalPrice(totalPrice)
                .productName(product.getName())
                .productDescription(product.getDescription())
                .build();

        final ShoppingCart cart = shoppingCartRepository.save(shoppingCart);

        return ShoppingCartResponse.builder()
                .id(shoppingCart.getId())
                .price(product.getPrice())
                .totalPrice(shoppingCart.getTotalPrice())
                .amountItem(shoppingCart.getAmountItem())
                .category(product.getCategory())
                .productId(product.getId())
                .productName(product.getName())
                .userAddress(shoppingCart.getUser().getAddress())
                .userEmail(shoppingCart.getUser().getEmail())
                .userFullName(shoppingCart.getUser().getFullName())
                .build();

    }
}