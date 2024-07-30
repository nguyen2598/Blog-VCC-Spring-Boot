package com.nguyen.blog.service;

import com.nguyen.blog.dto.request.UserCreationRequest;
import com.nguyen.blog.entity.User;
import com.nguyen.blog.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    AuthRepository authRepository;

    public User login(UserCreationRequest request) {
        User user = new User();

        return authRepository.save(user);

    }
    public User register(UserCreationRequest request) {
        User user = new User();


        return authRepository.save(user);
    }
}
