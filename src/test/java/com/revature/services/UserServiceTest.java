package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.models.User;
import com.revature.repositories.BookmarkRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.UserService;


@DisplayName("Test UserService")
@SpringBootTest
class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Test
	@DisplayName("Integration Test Bed for UserService successfully")
	void test() {
		assertTrue(true);
	}

	
	@Test
	@DisplayName("Save user successfully")
	void saveUserTest() {
		
		User aUser = new User();
		//aUser.setId(2);
		aUser.setEmail("testuser@gmail.com");
		aUser.setFirstName("Austin");
		aUser.setLastName("Hamilton");
		aUser.setPassword("password");

		// Test adding the user
		User newUser = userService.save(aUser);

		// Verify the addition
		assertNotNull(newUser.getEmail());
		assertEquals("Austin", newUser.getFirstName());

	}
	

}