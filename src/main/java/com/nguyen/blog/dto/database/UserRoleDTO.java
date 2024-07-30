package com.nguyen.blog.dto.database;

import com.nguyen.blog.entity.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class UserRoleDTO {
    private int id;
    private String username,password,email,ext;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Role role;

    public UserRoleDTO(int id, String username, String password, String email, String ext, LocalDateTime createdAt, LocalDateTime updatedAt, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.ext = ext;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
