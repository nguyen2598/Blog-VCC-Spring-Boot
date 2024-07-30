package com.nguyen.blog.repository;

import com.nguyen.blog.entity.Role;
import com.nguyen.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
//    <T> ScopedValue<T> findById(String number);
}
