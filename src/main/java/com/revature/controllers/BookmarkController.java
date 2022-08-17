package com.revature.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Bookmark;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {
	public final UserService userService;
	
	public BookmarkController(UserService userService) {
		super();
		this.userService = userService;
	}



	@PostMapping("/add")
	public ResponseEntity<Bookmark> bookmarkPost(@RequestBody User user, @RequestBody Post post){
		Bookmark bookmark= userService.bookmarkPost(user, post);
		return new ResponseEntity<>(bookmark, HttpStatus.CREATED);
	}

	@GetMapping("/getbookmarks")
	public ResponseEntity<List<Bookmark>> retrieveBookmarks(@RequestBody User user){
		List<Bookmark> bookmarks=userService.retrieveBookmarks(user);
		return new ResponseEntity<>(bookmarks, HttpStatus.OK);
	}
	
	@DeleteMapping("/removeBookmark")
	public ResponseEntity<?> removeBookmark(@RequestBody Bookmark bookmark){
		userService.removeBookmark(bookmark);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
