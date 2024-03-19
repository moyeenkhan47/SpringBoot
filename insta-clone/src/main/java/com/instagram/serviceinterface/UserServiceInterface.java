package com.instagram.serviceinterface;

import com.instagram.userdto.UserRegistrationDTO;
import com.instagram.userentity.UserRegistration;

public interface UserServiceInterface {
	UserRegistration register(UserRegistrationDTO userRegistrationDTO);

}
