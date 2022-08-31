package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.Bookmark;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.BookmarkRepository;
@DisplayName("JUnit Test for BookmarkService")
@ExtendWith(MockitoExtension.class)
class BookmarkServiceTest {

	@Mock
	BookmarkRepository bookmarkRepository;
	@InjectMocks
	BookmarkService bookmarkService;
	
	private User user;
	private Bookmark bookmark;
	private Post post;

	@BeforeEach
	public void setup() {
		user = User.builder().id(2).firstName("Jasdhir").lastName("Singh").email("test01@gmail.com")
				.password("password01").city("Mumbai").build();
		post = Post.builder().id(4).text("This is a post").imageUrl("")
				.author(user).build();
		bookmark = Bookmark.builder().id(1).post(post).user(user).build();
	}

}
