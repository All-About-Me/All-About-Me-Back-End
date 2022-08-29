package com.revature.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@DisplayName("JUnit Test for UserService")
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	private User user;

	@BeforeEach
	public void setup() {

		user = User.builder().id(2).firstName("Jasdhir").lastName("Singh").email("test01@gmail.com")
				.password("password01").city("Mumbai").build();
	}

	@Test
	@DisplayName("Save method successfull")
	public void givenUserObject_whenSaveUser_thenReturnUserObject() {

		// stubbing
		given(userRepository.save(user)).willReturn(user);


		User savedUser = userService.save(user);
		Assertions.assertThat(savedUser).isNotNull();

		System.out.println(savedUser);

	}

}