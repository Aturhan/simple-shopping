package com.abdullahturhan.shopping.shopping.controller;

import com.abdullahturhan.shopping.shopping.dto.UserDto;
import com.abdullahturhan.shopping.shopping.dto.UserDtoResponse;
import com.abdullahturhan.shopping.shopping.dto.UserUpdateRequest;
import com.abdullahturhan.shopping.shopping.dto.UserUpdateResponse;
import com.abdullahturhan.shopping.shopping.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(path = "")
    public ResponseEntity<List<UserDtoResponse>> listUsers(){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(userService.listUsers());
    }
    @PostMapping(path = "")
    public ResponseEntity<UserDtoResponse> save(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.saveOneUser(userDto));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<UserUpdateResponse> update(@PathVariable Long id, @RequestBody UserUpdateRequest request){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(userService.updateOneUser(id, request));
    }
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteOneUser(id);
    }
}

