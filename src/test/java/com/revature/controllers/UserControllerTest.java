package com.revature.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpSession;

import com.revature.models.User;
import com.revature.services.UserService;

class UserControllerTest {
	
	

	@Test
	void shouldSave() {
		User user = Mockito.mock(User.class);
		
		MockHttpSession mockHttpSession = new MockHttpSession();
		//mockHttpSession = new MockHttpSession(webApplicationContext.getServletContext());

	    mockHttpSession.setAttribute("user", user);
		
		
		UserService userService = Mockito.mock(UserService.class);
		
		when(userService.save(user)).thenReturn(user);
		
		UserController userController = new UserController(userService);
		//assertEqual("mat@gmail.com",userController.updateProfile(user, mockHttpSession));
	}

}