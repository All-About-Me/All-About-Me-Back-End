package com.revature.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Bookmark;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/bookmarks")
@CrossOrigin(origins = {"http://localhost:4200","http://aamfront-enddeploy.s3-website-us-east-1.amazonaws.com"}, allowCredentials = "true")
public class BookmarkController {
	public final UserService userService;
	
	public BookmarkController(UserService userService) {
		super();
		this.userService = userService;
	}



	@PostMapping
	public ResponseEntity<Bookmark> bookmarkPost(@RequestBody Bookmark bodyBookmark){
		Bookmark bookmark= userService.bookmarkPost(bodyBookmark);
		return new ResponseEntity<>(bookmark, HttpStatus.CREATED);
		
	}

	@PutMapping
	public ResponseEntity<List<Bookmark>> retrieveBookmarks(@RequestBody User user){
		List<Bookmark> bookmarks=userService.retrieveBookmarks(user);
		return ResponseEntity.ok().body(bookmarks);
	}
	
	@DeleteMapping
	public ResponseEntity<?> removeBookmark(@RequestBody Bookmark bookmark){
		userService.removeBookmark(bookmark);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}