package com.revature.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.revature.models.User;

@DataJpaTest   //used to test persistentce layer 
class UserRepositoryTest {
	
	@Autowired
	UserRepository userReposiory;
	
	//JUnit test for save User operation
	@DisplayName("User save successfull")
	@Test
	void givenUserObj_whenSave_thenReturnSavedUser() {
		
		//given -precondition or setup
		User user = User.builder()
				.id(2)
				.firstName("Jasdhir")
				.lastName("Singh")
				.city("Mumbai")
				.build();
		//when -action or the behaviour that we are going to test
		User savedUser = userReposiory.save(user);
		
		//then - verify the object
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getFirstName()).isEqualTo("Jasdhir");
				
	}
	
	
	//JUnit test for get all User operation
	@Test
	void givenUserList_whenFindAll_thenEmployeeList() {
		//given - precondition or setup
		User user1 = User.builder()
				.id(1)
				.firstName("Jasdhir")
				.lastName("Singh")
				.city("Mumbai")
				.build();
		
		User user2 = User.builder()
				.id(2)
				.firstName("Austin")
				.lastName("Hamilton")
				.city("Mumbai")
				.build();
		
		userReposiory.save(user1);
		userReposiory.save(user2);
		
		
		//when -action or the behaviour that we are going to test
		List<User> userList = userReposiory.findAll();
		
		//then - verify the object
		assertThat(userList).isNotNull();
		assertThat((userList).size()).isEqualTo(2);
				
		}

}
