package com.revature.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.revature.models.Follower;
import com.revature.models.User;



@DataJpaTest
class FollowerRepositorytest {

	@Autowired
	UserRepository userRepo;
	@Autowired
	FollowerRepository followRepo;
	private User user1;
	private User user2;
	private Follower follow1;
	private Follower follow2;
	private Follower follow3;
	@BeforeEach
	public void setup() {
		
		 user1 = User.builder()
				.id(1)
				.firstName("test1")
				.lastName("user1")
				.email("test01@gmail.com")
				.password("password01")
				.build();
		 
		 user2 = User.builder()
					.id(2)
					.firstName("test2")
					.lastName("user2")
					.email("test02@gmail.com")
					.password("password02")
					.build();
	
	}
	
	@Test
	@Order(1)
	void findByUserTest() {
		
		
		 follow1 = Follower.builder()
					.id(1)
					.user(user1)
					.follow (null)
					.build();
		 
		 followRepo.save(follow1);
		 List<Follower> users = followRepo.findByUser(follow1.getUser());
			
					assertThat(users).isNotNull();		 
	}
	
	@Test
	@Order(2)
	void findByFollowTest() {
		
		userRepo.save(user1);
		userRepo.save(user2);
		
		 follow2 = Follower.builder()
					.id(2)
					.user(user1)
					.follow (user2)
					.build();
		 
		 followRepo.save(follow2);
		 List<Follower> follow = followRepo.findByFollow(follow2.getFollow());
			
					assertThat(follow).isNotNull();		 
	}	
	
	@Test
	@Order(3)
	void findByUserAndFollowerest() {
		
		userRepo.save(user1);
		userRepo.save(user2);
		
		 follow3 = Follower.builder()
					.id(3)
					.user(user1)
					.follow (user2)
					.build();
		 
		 followRepo.save(follow3);
		 Optional<Follower> followers = followRepo.findByUserAndFollow(follow3.getUser(),follow3.getFollow());
			
					assertThat(followers).isNotNull();		 
	}	
}
