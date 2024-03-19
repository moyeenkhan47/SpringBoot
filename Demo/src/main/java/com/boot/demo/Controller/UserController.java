package com.boot.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.demo.dto.UserDto;
import com.boot.demo.entity.User;
import com.boot.demo.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/save")
	public UserDto saveUser(@RequestBody UserDto userDto){
		return userService.saveUser(userDto);
	}
		@GetMapping("/get")
		public List<UserDto> getUser() {
			return userService.findAllUser();
		
	
	}
		@GetMapping("/get{Id}")
		public UserDto findUserById(@PathVariable int id) {
			return userService.findUserById(id);
		}
	

}
