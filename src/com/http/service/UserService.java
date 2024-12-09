package com.http.service;

import com.http.dao.UserDao;
import com.http.dto.CreateUserDto;
import com.http.dto.UserDto;
import com.http.entity.User;
import com.http.exception.ValidationException;
import com.http.mapper.CreateUserMapper;
import com.http.mapper.UserMapper;
import com.http.validator.CreateUserValidator;
import com.http.validator.ValidationResult;

import java.io.IOException;
import java.util.Optional;

public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final ImageService imageService = ImageService.getINSTANCE();
   private final UserMapper userMapper = UserMapper.getINSTANCE();
    private UserService(){}

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email,password)
                .map(userMapper::mapFrom);
    }

    public Integer create(CreateUserDto userDto) {
//        1. validation
        ValidationResult validResult = createUserValidator.isValid(userDto);
        if (!validResult.isValid()) {
            throw new ValidationException(validResult.getErrors());
        }
//        2. map
        User userEntity = createUserMapper.mapFrom(userDto);

        try {
            imageService.upload(userEntity.getImage(), userDto.getImage().getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        3. userDao.save
        userDao.save(userEntity);
//        return id
        return userEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
