package com.nguyen.blog.controller;


import com.nguyen.blog.dto.request.UserCreationRequest;
import com.nguyen.blog.dto.request.UserUpdateRequest;
import com.nguyen.blog.entity.User;
import com.nguyen.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    User createUser(@RequestBody UserCreationRequest request) {
       return userService.createUser(request);
        
    }

    @GetMapping("")
    ResponseEntity<Object> getUsers(@RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "10") int limit,
                                    @RequestParam(required = false) String key,
                                    @RequestParam(required = false) String status
    ) {

        // Xử lý giá trị mặc định nếu cần thiết
//        key = (key == null||key.isEmpty()) ? "" : key;
//        status = (status == null||status.isEmpty()) ? "" : status;
//        System.out.println("key"+key+"key"+status+"key");

        // Gọi phương thức của userService với các tham số đã xử lý
        return userService.getUsers(page, limit, key, status);
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable("userId") String userId,@RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId,request);
    }

    @DeleteMapping ("/{userId}")
    void updateUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
