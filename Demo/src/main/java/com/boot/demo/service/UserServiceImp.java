package com.boot.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.demo.dto.UserDto;
import com.boot.demo.entity.User;
import com.boot.demo.userRepository.UserRepository;
@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDto saveUser(UserDto userDto) {
		User map = modelMapper.map(userDto, User.class);
		userRepository.save(map);
		
		return modelMapper.map(map, UserDto.class);
	}

	@Override
	public List<UserDto> findAllUser(){
		List<User> users = userRepository.findAll();
		if(users.isEmpty()) {
			return null;
		}
		List<UserDto> userDtos=  users.stream().map(user->modelMapper.map(user, UserDto.class)).
				collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDto findUserById(int id) {
		Optional<User> byId = userRepository.findById(id);
		if(byId.isEmpty()) {
			return null;
		}
		UserDto map = modelMapper.map(byId.get(), UserDto.class);
		return map;
	}

	

}
