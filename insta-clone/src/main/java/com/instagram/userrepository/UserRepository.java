package com.instagram.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.instagram.userentity.UserRegistration;

@Service
public interface UserRepository extends JpaRepository<UserRegistration, Long> {
	boolean existsByUserNameOrEmail(String userName ,String email);

}
