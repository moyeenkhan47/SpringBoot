package com.boot.demo.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
