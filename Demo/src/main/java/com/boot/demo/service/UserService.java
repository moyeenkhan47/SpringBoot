package com.boot.demo.service;

import java.util.List;

import com.boot.demo.dto.UserDto;

public interface UserService {
	public UserDto saveUser(UserDto userDto);
public List<UserDto> findAllUser();
public UserDto findUserById(int id);

	
}
