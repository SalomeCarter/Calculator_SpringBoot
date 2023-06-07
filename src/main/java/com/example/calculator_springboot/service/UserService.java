package com.example.calculator_springboot.service;

import com.example.calculator_springboot.dto.LoginUserDto;
import com.example.calculator_springboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final List<User> userList = new ArrayList<>();

    public void save(User user) {
        userList.add(user);
    }

    public Optional<User> findByUsername(LoginUserDto loginUserDto) {
        for (User user : userList) {
            if (user.getUsername().equals(loginUserDto.getUsername())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
