package com.revature.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import com.revature.models.Post;
import com.revature.repositories.PostRepository;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

//		@Mock
//		private PostRepository postRepo;
//		
//		@InjectMocks
//		private PostService postService;
//		@InjectMocks
//		private FollowerService followerService;
//		
//		
//		@Test
//		@DisplayName("Get all post")
//		public void getAllPostTest() {
//		List<Post> allPosts = new ArrayList<Post>();
//		List<Post> comments = new ArrayList<Post>();
//			Post posts = new Post();
//			posts.setId(23);
//			posts.setText("dingleBerry");
//			posts.setImageUrl("https://trello-backgrounds.s3.amazonaws.com/60d388…09cf4ffd223463c64f2a9996/Desktop-Background-4.jpg");
//			//posts.setDate(2022-07-24);
//			allPosts.add(posts);
//		when(postRepo.findAll()).thenReturn(allPosts);
//			List<Post> returnedPosts= postService.getAll();
//			assertEquals(1, returnedPosts.size());
//			assertEquals(true, returnedPosts.isEmpty());
//		}
		
}
