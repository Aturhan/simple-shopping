package com.abdullahturhan.shopping.shopping.service;

import com.abdullahturhan.shopping.shopping.dto.UserDto;
import com.abdullahturhan.shopping.shopping.dto.UserDtoResponse;
import com.abdullahturhan.shopping.shopping.dto.UserUpdateRequest;
import com.abdullahturhan.shopping.shopping.dto.UserUpdateResponse;
import com.abdullahturhan.shopping.shopping.entity.User;
import com.abdullahturhan.shopping.shopping.respository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
   // private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;
    }

    public List<UserDtoResponse> listUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(model ->
                UserDtoResponse.builder()
                        .id(model.getId())
                        .fullName(model.getFullName())
                        .email(model.getEmail())
                        .build()).collect(Collectors.toList());
    }

    public User findOneUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw  new RuntimeException("User not found");
        }
        return User.builder()
                .id(user.get().getId())
                .fullName(user.get().getFullName())
                .email(user.get().getEmail())
                .address(user.get().getAddress())
                .build();



    }

    @Transactional
    public UserDtoResponse saveOneUser(UserDto userDto){
        final  User user = User.builder()
                .fullName(userDto.getFullName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .address(userDto.getAddress())
                .build();
        final User savedUser = userRepository.save(user);
        return UserDtoResponse.builder()
                .id(savedUser.getId())
                .fullName(savedUser.getFullName())
                .email(savedUser.getEmail())
                .build();

    }

    @Transactional
    public UserUpdateResponse updateOneUser(Long id, UserUpdateRequest request){
        Optional<User> userOptional = userRepository.findById(id);
        userOptional.ifPresent(userFromDb->{
            userFromDb.setFullName(request.getFullName());
            userFromDb.setAddress(request.getAddress());
            userFromDb.setEmail(request.getEmail());
            userRepository.save(userFromDb);
        });

        Optional<User> updatedUser = userRepository.findById(id);
        return UserUpdateResponse.builder()
                .fullName(updatedUser.get().getFullName())
                .address(updatedUser.get().getAddress())
                .email(updatedUser.get().getEmail())
                .build();
    }
    @Transactional
    public void deleteOneUser(Long id){
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }
}
