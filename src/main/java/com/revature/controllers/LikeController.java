package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.NotLoggedInException;
import com.revature.models.Like;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.LikeRepository;
import com.revature.repositories.PostRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.LikeService;

@RestController
@RequestMapping("/like")
@CrossOrigin(origins = {"http://localhost:4200","http://34.235.88.178:4200"}, allowCredentials = "true")
public class LikeController {


	private LikeService likeService;
	private LikeRepository likeRepository;
	private UserRepository userRepository;
	private PostRepository postRepository;
	
	public LikeController(LikeService likeService, LikeRepository likeRepository, UserRepository userRepository,
			PostRepository postRepository) {
		super();
		this.likeService = likeService;
		this.likeRepository = likeRepository;
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@PostMapping //create new like 
	public ResponseEntity<?> likeAPost(@RequestBody Like like){
		System.out.println(like);
		likeService.likeAPost(like);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping
	public ResponseEntity<?> unlikeAPost(@RequestBody Like like){
		likeService.removeLike(like);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Like>> retrieveAllLikesForUser(@PathVariable("id")Integer id){
		User currentUser = userRepository.findById(id).orElseThrow(() -> new NotLoggedInException("no user logged in"));
		List<Like> likesForUser = likeRepository.findAllByUser(currentUser).orElseGet(() -> new ArrayList<Like>());
		return new ResponseEntity<>(likesForUser, HttpStatus.OK);	
	}
	
	@GetMapping("/post/{id}")
	public ResponseEntity<List<Like>> retrieveAllLikesForPost(@PathVariable("id")Integer id){
		Post currentPost = postRepository.findById(id).orElseThrow();
		List<Like> likesForPost = likeRepository.findAllByPost(currentPost).orElseGet(() -> new ArrayList<Like>());
		return new ResponseEntity<>(likesForPost, HttpStatus.OK);
	}
		
	
	
	
}
