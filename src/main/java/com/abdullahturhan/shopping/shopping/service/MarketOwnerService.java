package com.abdullahturhan.shopping.shopping.service;

import com.abdullahturhan.shopping.shopping.dto.MarketOwnerDto;
import com.abdullahturhan.shopping.shopping.dto.MarketOwnerDtoResponse;
import com.abdullahturhan.shopping.shopping.dto.MarketOwnerUpdateRequest;
import com.abdullahturhan.shopping.shopping.entity.MarketOwner;
import com.abdullahturhan.shopping.shopping.respository.MarketOwnerRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarketOwnerService {
    private final MarketOwnerRepository marketOwnerRepository;


    public MarketOwnerService(MarketOwnerRepository marketOwnerRepository) {
        this.marketOwnerRepository = marketOwnerRepository;

    }

    public List<MarketOwnerDtoResponse> listAll(){
        List<MarketOwner> owners = marketOwnerRepository.findAll();
        return owners.stream().map(model -> MarketOwnerDtoResponse.builder()
                .marketName(model.getMarketName())
                .email(model.getEmail())
                .fullName(model.getFullName()).build()).collect(Collectors.toList());
    }

    public Optional<MarketOwner> findOne(Long id){
        return marketOwnerRepository.findById(id);
    }

    @Transactional
    public MarketOwnerDtoResponse createOneOwner(MarketOwnerDto marketOwnerDto){
        final MarketOwner owner = MarketOwner.builder()
                .fullName(marketOwnerDto.getFullName())
                .marketName(marketOwnerDto.getMarketName())
                .address(marketOwnerDto.getAddress())
                .email(marketOwnerDto.getEmail())
                .password(marketOwnerDto.getPassword())
                .build();
        final MarketOwner savedOwner = marketOwnerRepository.save(owner);
        return MarketOwnerDtoResponse.builder()
                .fullName(savedOwner.getFullName())
                .email(savedOwner.getEmail())
                .marketName(savedOwner.getMarketName())
                .build();
    }
    @Transactional
    public MarketOwnerDtoResponse updateOwnerById(Long id, MarketOwnerUpdateRequest request){
        Optional<MarketOwner> optionalOwner = marketOwnerRepository.findById(id);
        optionalOwner.ifPresent(model-> {
            model.setFullName(request.getFullName());
            model.setMarketName(request.getMarketName());
            model.setEmail(request.getEmail());
            model.setAddress(request.getAddress());
            marketOwnerRepository.save(model);
        });
        Optional<MarketOwner> owner = marketOwnerRepository.findById(id);
        return MarketOwnerDtoResponse.builder()
                .fullName(owner.get().getFullName())
                .marketName(owner.get().getMarketName())
                .email(owner.get().getEmail())
                .build();
    }
    @Transactional
    public void deleteById(Long id){
        Optional<MarketOwner> owner = marketOwnerRepository.findById(id);
        owner.ifPresent(marketOwnerRepository::delete);
    }



}

