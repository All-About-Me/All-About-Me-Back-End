package com.revature.services;




import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.revature.models.Follower;
import com.revature.models.User;
import com.revature.repositories.FollowerRepository;
import com.revature.repositories.UserRepository;


@ExtendWith(MockitoExtension.class)
public class FollowerServiceTest {
	@Mock
	private FollowerRepository followRepo;
	@Mock
	private UserRepository userRepo;
	@InjectMocks
	private FollowerService followSer;

	private User user1;
	private User user2;
	private Follower follow;
	
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
	@DisplayName("Save function test")
	public void saveFollowerTest() {
	 Follower follow1 =new Follower();
	 follow1.setId(1);
	 follow1.setUser(user1);
	 follow1.setFollow(user2);
	 
	 when(followRepo.save(follow1)).thenReturn(follow1);
	 
	 Follower savefollow = followRepo.save(follow1);
	 assertThat(savefollow).isNotNull();
	}
	
	@Test
	@DisplayName("findByUser function test")
	public void  findByUserTest() {
		List<Follower> followList=new ArrayList<Follower>();
		Follower follow1 =new Follower();
		 follow1.setId(1);
	     follow1.setUser(user1);
		 follow1.setFollow(user2);
	 
		 followList.add(follow1);
		 when(followRepo.findByUser(user1)).thenReturn(followList);
		 //test
		 List<User> userlist= followSer.findByUser(user1);
		 assertEquals(1,userlist.size());
	}
	@Test
	@DisplayName("findByFollow function test")
	public void  findByFollowTest() {
		List<Follower> followList=new ArrayList<Follower>();
		Follower follow1 =new Follower();
		 follow1.setId(1);
		 follow1.setUser(user1);
		 follow1.setFollow(user2);
		 
		 followList.add(follow1);
		 when(followRepo.findByFollow(user2)).thenReturn(followList);
		 //test
		 List<User> userlist= followSer.findByFollow(user2);
		 assertEquals(1,userlist.size());
	}
	@Test
	@DisplayName("delete function test")
	public void deleteTest() {
		Follower follow1 =new Follower();
		 follow1.setId(1);
		 follow1.setUser(user1);
		 follow1.setFollow(user2);
		 
		 doNothing().when(followRepo).delete(follow1);
		 followSer.delete(follow1);
		verify(followRepo,times(1)).delete(follow1);
	}
	
}
