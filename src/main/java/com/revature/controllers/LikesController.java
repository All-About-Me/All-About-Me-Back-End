package com.revature.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Likes;
import com.revature.models.Post;
import com.revature.services.LikesService;
import com.revature.services.PostService;

@RestController
@RequestMapping("/liked")
@CrossOrigin(origins = {"http://localhost:4200","http://34.235.88.178:4200"}, allowCredentials = "true")
public class LikesController {


	private LikesService likesService;
	private PostService postService;
	
	
	
	public LikesController(LikesService likesService,PostService postService) {
		super();
		this.likesService =likesService;
		this.postService =postService;
	}



	@PostMapping //create new like 
	public ResponseEntity<Likes>addLikes(@RequestBody Likes likes){
		Likes like =likesService.addLikes(likes);
		return new ResponseEntity<>(like,HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public ResponseEntity<?> removeLikes(@RequestBody Likes likes){
		likesService.removeLikes(likes);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}") //read the amount of likes
	public ResponseEntity <List<Likes>> shareAllLikes(@PathVariable Integer id) {
		Post post = postService.findById(id).orElseThrow();
		List<Likes> likes=likesService.shareAllLikes(post);
		return  ResponseEntity.ok().body(likes);
	}
}
