package com.nguyen.blog.repository;

import com.nguyen.blog.dto.response.UserDTO;
import com.nguyen.blog.entity.Role;
import com.nguyen.blog.entity.User;
import com.nguyen.blog.utils.UserConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nguyen.blog.dto.response.RoleDTO;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    boolean existsByUsername(String username);
    @Query("SELECT u FROM User u " +
            "INNER JOIN Role r " +
            "ON u.role.id = r.id " +
            "WHERE " +
            "(LOWER(u.username) LIKE LOWER(CONCAT('%', :key, '%')) OR (:key ='') OR (:key IS NULL)) " +
            "AND ((u.destroyTime IS NULL AND :status = 'enable') OR (u.destroyTime IS NOT NULL AND :status = 'disable') OR :status = 'all' OR :status = '' OR :status IS NULL) ")
        //    @Query("SELECT u FROM User u WHERE " +
//            "(LOWER(u.username) LIKE LOWER(CONCAT('%', :key, '%')) OR :key IS NULL) AND (:status='enable' AND u.destroyTime IS NULL) "
//            "AND ((:status = 'enable' AND u.destroyTime IS NULL) " +
//            "OR (:status = 'disable' AND u.destroyTime IS NOT NULL) " +
//            "OR (:status IS NULL OR :status = 'all'))"
    Page<User> findByUsernameAndStatus(@Param("key") String key, @Param("status") String status, Pageable pageable);
//    Page<User> findByUsernameAndStatus(String name, String status, Pageable dpageable);

    @Query("SELECT u FROM User u " +
            "INNER JOIN Role r " +
            "ON u.role.id = r.id " +
            "WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :key, '%'))" )
    Page<User> findByUsername(@Param("key") String key, Pageable dpageable);

    @Query("SELECT u FROM User u " +
            "INNER JOIN Role r " +
            "ON u.role.id = r.id " +
            "WHERE " +
            "(" +
                "(u.destroyTime IS NULL AND :status = 'enable') " +
                "OR " +
                "(u.destroyTime IS NOT NULL AND :status = 'disable') " +
                "OR " +
                ":status = 'all' " +
                "OR " +
                ":status = '' " +
                "OR " +
                ":status IS NULL" +
            ")"
    )
    Page<User> findByStatus(String status, Pageable dpageable);

    @Query("SELECT u FROM User u " +
            "INNER JOIN Role r " +
            "ON u.role.id = r.id "
    )
    Page<User> findAllUsers(Pageable dpageable);

    default Page<UserDTO> convertToUserDTOPage(Page<User> usersPage, Pageable pageable) {
        List<UserDTO> userDTOs = usersPage.stream()
                .map(UserConverter::convertToDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(userDTOs, pageable, usersPage.getTotalElements());
    }

}
