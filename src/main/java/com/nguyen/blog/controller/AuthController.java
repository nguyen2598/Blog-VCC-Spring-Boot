package com.nguyen.blog.controller;

import com.nguyen.blog.dto.request.CategoryCreationRequest;
import com.nguyen.blog.dto.request.UserCreationRequest;
import com.nguyen.blog.entity.Category;
import com.nguyen.blog.entity.User;
import com.nguyen.blog.service.AuthService;
import com.nguyen.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    User login(@RequestBody UserCreationRequest request) {
       return authService.login(request);
    }

    @PostMapping("/register")
    User register(@RequestBody UserCreationRequest request) {
        return authService.register(request);
    }
}
