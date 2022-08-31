package com.revature.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.revature.models.User;

@DataJpaTest   //used to test persistentce layer 
class UserRepositoryTest {
	
//	@Autowired
//	UserRepository userReposiory;
//	
//	private User user;
//	
//	@BeforeEach
//	public void setup() {
//		
//		 user = User.builder()
//				.id(2)
//				.firstName("Jasdhir")
//				.lastName("Singh")
//				.email("test01@gmail.com")
//				.password("password01")
//				.city("Mumbai")
//				.build();
//	
//	}
//	
//	//JUnit test for save User operation
//	@DisplayName("User save successfull")
//	@Test
//	public void givenUserObj_whenSave_thenReturnSavedUser() {
//		
////		//given -precondition or setup
////		User user = User.builder()
////				.id(2)
////				.firstName("Jasdhir")
////				.lastName("Singh")
////				.city("Mumbai")
////				.build();
//		//when -action or the behaviour that we are going to test
//		User savedUser = userReposiory.save(user);
//		
//		//then - verify the object
//		assertThat(savedUser).isNotNull();
//		assertThat(savedUser.getFirstName()).isEqualTo("Jasdhir");
//				
//	}
//	
//	
//	//JUnit test for get all User operation
//	@DisplayName("Find all User successfull")
//	@Test
//	void givenUserList_whenFindAll_thenUserList() {
//		//given - precondition or setup
////		User user1 = User.builder()
////				.id(1)
////				.firstName("Jasdhir")
////				.lastName("Singh")
////				.city("Mumbai")
////				.build();
//		
//		User user2 = User.builder()
//				.id(2)
//				.firstName("Austin")
//				.lastName("Hamilton")
//				.city("Mumbai")
//				.build();
//		
//		userReposiory.save(user);
//		userReposiory.save(user2);
//		
//		
//		//when -action or the behaviour that we are going to test
//		List<User> userList = userReposiory.findAll();
//		
//		//then - verify the object
//		assertThat(userList).isNotNull();
//		assertThat((userList).size()).isEqualTo(2);
//				
//		}
//	
//	
//	
//	//JUnit test for get User by email and password
//	@DisplayName("Get User by Email and Password successfull")
//	@Test
//	void givenEmailAndPassword_whenFindByEmailAndPassword_thenUser()
//	{
//		//given - precondition or setup
////		User user = User.builder()
////				.id(2)
////				.firstName("Jasdhir")
////				.lastName("Singh")
////				.email("test01@gmail.com")
////				.password("password01")
////				.city("Mumbai")
////				.build();
//		
//		userReposiory.save(user);
//		
//		//when -action or the behaviour that we are going to test
//		Optional<User> userDB = userReposiory.findByEmailAndPassword(user.getEmail(),user.getPassword());
//		
//		//then - verify the object
//		assertThat(userDB).isNotNull();
//		}
//	
//	
//	
//	//JUnit test for update User Operation
//	@DisplayName("Update Password successfull")
//	@Test
//	void givenUserObject_whenUpdateUser_thenReturnUpdatedUser()
//	{
//		//given - precondition or setup
////				User user = User.builder()
////						.id(2)
////						.firstName("Jasdhir")
////						.lastName("Singh")
////						.email("test01@gmail.com")
////						.password("password01")
////						.city("Mumbai")
////						.build();
//				
//				userReposiory.save(user);
//		
//		//when -action or the behaviour that we are going to test
//		User savedUser = userReposiory.findById(user.getId()).get();
//		savedUser.setPassword("pass");
//		User updatedUser = userReposiory.save(savedUser);
//		
//		//then - verify the object
//		assertThat(updatedUser.getPassword()).isEqualTo("pass");
				
//	}
	

	
}
