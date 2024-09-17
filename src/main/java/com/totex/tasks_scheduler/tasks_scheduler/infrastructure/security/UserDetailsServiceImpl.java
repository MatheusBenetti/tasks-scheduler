package com.totex.tasks_scheduler.tasks_scheduler.infrastructure.security;

import com.totex.tasks_scheduler.tasks_scheduler.business.dto.UserDto;
import com.totex.tasks_scheduler.tasks_scheduler.infrastructure.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UserClient userClient;

    public UserDetails loadUserByUsernameAndToken(String email, String token) {
        UserDto userDto = userClient.getUserByEmail(email, token);
        return User
                .withUsername(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}