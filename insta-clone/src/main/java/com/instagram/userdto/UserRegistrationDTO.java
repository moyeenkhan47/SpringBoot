package com.instagram.userdto;

import org.springframework.beans.BeanUtils;

import com.instagram.userentity.UserRegistration;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRegistrationDTO {
	
	private long id;
	private String userName;
	private String email;
	private long phoneno;
	private int age;
	private String gender;
	private String city;
	
	/*
	 * public UserRegistrationDTO(UserRegistration userRegistration) {
	 * BeanUtils.copyProperties(userRegistration,this); }
	 */

	
	

}
