package com.http.mapper;

import com.http.dto.CreateUserDto;
import com.http.entity.Gender;
import com.http.entity.Role;
import com.http.entity.User;
import com.http.util.LocalDateFormatter;

import java.time.LocalDate;

public class CreateUserMapper implements Mapper<CreateUserDto, User>  {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    private static final String IMAGE_FOLDER = "users/";

    private CreateUserMapper(){}

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .image(IMAGE_FOLDER + object.getImage().getSubmittedFileName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .role(Role.valueOf(object.getRole()))
                .gender(Gender.valueOf(object.getGender()))
                .build();
    }

    public static CreateUserMapper getInstance(){
        return INSTANCE;
    }
}
