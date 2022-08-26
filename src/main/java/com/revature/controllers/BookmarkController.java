package com.revature.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Bookmark;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.BookmarkService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/bookmarks")
@CrossOrigin(origins = {"http://localhost:4200","http://34.235.88.178:3600"}, allowCredentials = "true")
public class BookmarkController {
	public final UserService userService;
	public final BookmarkService bookmarkService;
	
	public BookmarkController(UserService userService, BookmarkService bookmarkService) {
		super();
		this.userService = userService;
		this.bookmarkService = bookmarkService;
	}



	@PostMapping
	public ResponseEntity<Bookmark> bookmarkPost(@RequestBody Bookmark bodyBookmark){
		Bookmark bookmark= bookmarkService.bookmarkPost(bodyBookmark);
		return new ResponseEntity<>(bookmark, HttpStatus.CREATED);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Bookmark>> retrieveBookmarks(@PathVariable Integer id){
		User user = userService.findById(id).orElseThrow();
		List<Bookmark> bookmarks= bookmarkService.retrieveBookmarks(user);
		return ResponseEntity.ok().body(bookmarks);
	}
	
	@DeleteMapping
	public ResponseEntity<?> removeBookmark(@RequestBody Bookmark bookmark){
		bookmarkService.removeBookmark(bookmark);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}