package com.boot.demo.mapper;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.demo.dto.UserDto;
import com.boot.demo.entity.User;
@Component
public class UserMapper {
	@Autowired
	ModelMapper modelMapper;
	public UserDto EntityToDto(User user) {
		if(Objects.isNull(user)) {
			return null;	
		}
		return modelMapper.map(user, UserDto.class);
		
	}
	public User DtoToEntity(UserDto userDto) {
		if(Objects.isNull(userDto)) {
			return null;	
		}
		return modelMapper.map(userDto, User.class);
		
	}
	

}
