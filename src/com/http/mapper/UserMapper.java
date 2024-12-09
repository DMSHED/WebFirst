package com.http.mapper;

import com.http.dto.UserDto;
import com.http.entity.User;

public class UserMapper implements Mapper<User, UserDto>{

    private static final UserMapper INSTANCE = new UserMapper();

    private UserMapper(){}

    public static UserMapper getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .email(object.getEmail())
                .image(object.getImage())
                .birthday(object.getBirthday())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }
}
