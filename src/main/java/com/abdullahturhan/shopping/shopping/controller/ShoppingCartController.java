package com.abdullahturhan.shopping.shopping.controller;

import com.abdullahturhan.shopping.shopping.dto.ShoppingCartDto;
import com.abdullahturhan.shopping.shopping.dto.ShoppingCartResponse;
import com.abdullahturhan.shopping.shopping.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }
    @PostMapping(path = "")
    public ResponseEntity<ShoppingCartResponse> saveShopping(@RequestBody ShoppingCartDto shoppingCartDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(shoppingCartService.createShoppingCart(shoppingCartDto));
    }


}