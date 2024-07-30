package com.nguyen.blog.service;

import com.nguyen.blog.dto.request.UserCreationRequest;
import com.nguyen.blog.dto.request.UserUpdateRequest;
import com.nguyen.blog.entity.Category;
import com.nguyen.blog.entity.Role;
import com.nguyen.blog.entity.User;
import com.nguyen.blog.repository.RoleRepository;
import com.nguyen.blog.repository.UserRepository;
import com.nguyen.blog.utils.ApiResponseUtil;
import com.nguyen.blog.utils.CustomPageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        if(userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("User existed");
        }
        user.setUsername(request.getUsername());

        user.setEmail(request.getEmail());
        user.setExt(request.getExt());
        user.setPassword(request.getPassword());
//        user.setRole_id(request.getRole_id());
        // Lấy Role từ roleRepository và gán cho user
        Role role = roleRepository.findById(request.getRole_id()+"")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(role);
        return userRepository.save(user);
    }
    public ResponseEntity<Object> getUsers(int page, int limit,String key, String status) {
        Pageable pageable = PageRequest.of(page-1, limit);
        Page<User> users ;
        System.out.println("page"+page+"limit"+limit+"key"+key+"status"+status);
        if(key!=null && !key.isEmpty() && status!=null && !status.isEmpty()){
            System.out.println(userRepository.findByUsernameAndStatus(key,status,pageable));
            users=userRepository.findByUsernameAndStatus(key,status,pageable);
        }
        else if (key != null && !key.isEmpty()) {
            System.out.println(userRepository.findByUsername(key, pageable));
            users = userRepository.findByUsername(key, pageable);
        } else if (status != null && !status.isEmpty()) {
            System.out.println(userRepository.findByStatus(status, pageable));
            users = userRepository.findByStatus(status, pageable);
        }
        else {
            users = userRepository.findAll(pageable);
        }
        CustomPageData<User> data=new CustomPageData<>(users.getTotalElements(),users.getContent());

//        = userRepository.findAll(pageable);
//        return userRepository.findAll();
        return ApiResponseUtil.ok(data);

    }
    public User getUser(String id) {
     return userRepository.findById(id)
             .orElseThrow(
                     () -> new RuntimeException("User not found")// day la lambda
             );
    }
    public User updateUser(String userId,UserUpdateRequest request) {
        User user = getUser(userId);
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
