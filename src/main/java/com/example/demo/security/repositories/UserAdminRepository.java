package com.example.demo.security.repositories;

import com.example.demo.security.domains.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
    UserAdmin findByUserName(String username);
}
