package com.abdullahturhan.shopping.shopping.controller;

import com.abdullahturhan.shopping.shopping.dto.MarketOwnerDto;
import com.abdullahturhan.shopping.shopping.dto.MarketOwnerDtoResponse;
import com.abdullahturhan.shopping.shopping.dto.MarketOwnerUpdateRequest;
import com.abdullahturhan.shopping.shopping.service.MarketOwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/owner")
public class MarketOwnerController {
    private final MarketOwnerService marketOwnerService;

    public MarketOwnerController(MarketOwnerService marketOwnerService) {
        this.marketOwnerService = marketOwnerService;
    }
    @GetMapping(path = "")
    public ResponseEntity<List<MarketOwnerDtoResponse>> listAll(){
        return  ResponseEntity.status(HttpStatus.FOUND)
                .body(marketOwnerService.listAll());
    }
    @PostMapping(path = "")
    public ResponseEntity<MarketOwnerDtoResponse> createOneOwner(@RequestBody MarketOwnerDto marketOwnerDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(marketOwnerService.createOneOwner(marketOwnerDto));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<MarketOwnerDtoResponse> updateOneOwner(Long id , @RequestBody MarketOwnerUpdateRequest request){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(marketOwnerService.updateOwnerById(id,request));
    }
    @DeleteMapping(path = "/{id}")
    public void deleteOneOwner(Long id){
        marketOwnerService.deleteById(id);
    }

}
