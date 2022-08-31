package com.revature.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	@DisplayName("Save method successfull")
	public void givenUserObject_whenSaveUser_thenReturnUserObject() {

		// stubbing
		given(userRepository.save(user)).willReturn(user);


		User savedUser = userService.save(user);
		Assertions.assertThat(savedUser).isNotNull();

		System.out.println(savedUser);

	}
	
	@Test
	@DisplayName("findById method successful")
	public void givenId_whenFindById_thenReturnUserOptional() {
		
		//stubbing
		given(userService.findById(user.getId())).willReturn(opuser);
		
		Optional<User> findUser = userService.findById(user.getId());
		Assertions.assertThat(findUser).isEqualTo(opuser);
	}
	
	@Test
	@DisplayName("findByCredentials method successful")
	public void givenCredentials_whenFindByCredentials_thenReturnUserOptional() {
		
		//stubbing
		given(userService.findByCredentials(user.getEmail(), user.getPassword())).willReturn(opuser);
		
		Optional<User> findUser = userService.findByCredentials(user.getEmail(), user.getPassword());
		Assertions.assertThat(findUser).isEqualTo(opuser);
	}
	
	@Test
	@DisplayName("findAllUsers method successful")
	public void whenFindAllUsers_thenReturnUserList() {
		
		//stubbing
		given(userService.findAllUsers()).willReturn(lUser);
		
		List<User> listUser = userService.findAllUsers();
		Assertions.assertThat(listUser).isEqualTo(lUser);
		System.out.println(listUser);
	}

}