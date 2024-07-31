package com.nguyen.blog.utils;
import com.nguyen.blog.dto.response.UserDTO;
import com.nguyen.blog.entity.User;

public class UserConverter {

    public static UserDTO convertToDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
        // Set các thuộc tính khác từ User sang UserDTO nếu cần thiết
        return userDTO;
    }

    public static User convertToEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        // Bạn có thể cần set role và các thuộc tính khác nếu cần thiết
        return user;
    }
}
