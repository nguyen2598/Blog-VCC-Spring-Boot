package com.nguyen.blog.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role_name,description;
    @OneToMany(mappedBy = "role")
    private List<User> users;
}
