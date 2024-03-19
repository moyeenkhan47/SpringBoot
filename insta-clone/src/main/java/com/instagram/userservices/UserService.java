package com.instagram.userservices;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.instagram.serviceinterface.UserServiceInterface;
import com.instagram.userdto.UserRegistrationDTO;
import com.instagram.userentity.UserRegistration;
import com.instagram.usermapper.UserMapper;
import com.instagram.userrepository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService  implements UserServiceInterface{
	
	private final UserRepository userRepository;

	private final ModelMapper mapper;
	

	@Override
	public UserRegistration register(UserRegistrationDTO userRegistrationDTO) {
		// TODO Auto-generated method stub
		boolean existEmailOrUserName=userRepository.existsByUserNameOrEmail(userRegistrationDTO.getUserName(),
				userRegistrationDTO.getEmail());
		if (existEmailOrUserName==false) {
			UserRegistration userRegistration=mapper.map(userRegistrationDTO, UserRegistration.class);
			return userRepository.save(userRegistration);
		}
		return null;
	}

}
