package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@DisplayName("JUnit Test for AuthService")
@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

	@Mock
	private UserRepository userRepository;
	@Mock
	private UserService userService;

	@InjectMocks
	private AuthService authService;
	
	private User user;
	private Optional<User> opuser;
	private List<User> lUser;
	
	@BeforeEach
	public void setup() {
		user = User.builder().id(2).firstName("Jasdhir").lastName("Singh").email("test01@gmail.com")
				.password("password01").city("Mumbai").build();
		opuser = Optional.of(user);
		lUser = new ArrayList<User>();
		lUser.add(user);
	}
	
	@Test
	@DisplayName("findByCredentials method successful")
	public void givenCredentials_whenFindByCredentials_thenReturnUserOptional() {

		//stubbing
		given(userService.findByCredentials(user.getEmail(),user.getPassword())).willReturn(opuser);
			
		Optional<User> findUser = authService.findByCredentials(user.getEmail(),user.getPassword());
		Assertions.assertThat(findUser).isEqualTo(opuser);
	}
	
	@Test
	@DisplayName("Register method successful")
	public void givenUser_whenRegister_thenReturnUserObject() {
		
		//stubbing
		given(userService.save(user)).willReturn(user);
		
		User registeredUser = authService.register(user);
		Assertions.assertThat(registeredUser).isEqualTo(user);
	}
	
	@Test
	@DisplayName("findAll method successful")
	public void whenFindAll_thenReturnAllUsersList() {
		given(userService.findAllUsers()).willReturn(lUser);
		
		List<User> userList = authService.findAll();
		Assertions.assertThat(userList).isEqualTo(lUser);
	}
	
	@Test
	@DisplayName("FindUserById method successful")
	public void givenId_whenFindUserById_thenReturnUserOptional() {
		given(userService.findById(user.getId())).willReturn(opuser);
		
		Optional<User> findUser = authService.findUserById(user.getId());
		Assertions.assertThat(findUser).isEqualTo(opuser);
	}

}
