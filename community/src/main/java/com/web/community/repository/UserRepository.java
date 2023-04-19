package com.web.community.repository;

import com.web.community.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { // JpaRepository<Value type, Key type>
    User findByEmail(String email);
}
