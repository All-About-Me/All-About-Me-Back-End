package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.models.User;
import com.revature.repositories.BookmarkRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.UserService;

class UserServiceTest {
	
	@Test
	void test() {
		assertTrue(true);

	}

	@Test
	void saveUserTest() {
		UserRepository userRepository = null;
		BookmarkRepository bookmarkRepository = null;


		User aUser = new User();
		UserService userService = new UserService(userRepository, bookmarkRepository);
		aUser.setId(100);
		aUser.setFirstName("Austin");
		aUser.setLastName("Hamilton");

		// Test adding the user
		//User newUser = userService.save(aUser);

		// Verify the addition
		//Assertions.assertNotNull(newUser);
		//Assertions.assertEquals("Austin", newUser.getFirstName());

	}

}
