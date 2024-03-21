package com.instagram.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.userdto.UserRegistrationDTO;
import com.instagram.userentity.UserRegistration;
import com.instagram.usermapper.UserMapper;
import com.instagram.userservices.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class Controller {
	
	private final UserService userService;
	
    private final ModelMapper mapper;

	public ResponseEntity<?> userRegister(@RequestBody UserRegistrationDTO userRegistrationDTO) {
		UserRegistration userRegistration = userService.register(userRegistrationDTO);
		if (userRegistration == null) {
			return ResponseEntity.badRequest().body(userRegistration);
		}
		UserRegistrationDTO response = mapper.map(userRegistration ,UserRegistrationDTO.class );
		return ResponseEntity.ok(response);
	}

}
