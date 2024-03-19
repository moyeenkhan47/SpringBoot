package com.instagram.usermapper;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.instagram.userdto.UserRegistrationDTO;
import com.instagram.userentity.UserRegistration;

@Component
public class UserMapper {
	@Autowired
	private ModelMapper modelMapper;

	public UserRegistrationDTO entityToDto(UserRegistration userRegistration) {
		if (Objects.isNull(userRegistration)) {
			return null;
		}

		return modelMapper.map(userRegistration, UserRegistrationDTO.class);

	}

	public UserRegistration DtoToEntity(UserRegistrationDTO userRegistrationDTO) {
		if (Objects.isNull(userRegistrationDTO)) {
			return null;
		}
		return modelMapper.map(userRegistrationDTO, UserRegistration.class);
	}
}
