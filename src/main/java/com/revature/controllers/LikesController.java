package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Likes;
import com.revature.models.Post;
import com.revature.services.LikesService;

@RestController
@RequestMapping("/liked")
@CrossOrigin(origins = {"http://localhost:4200","http://34.235.88.178:3600"}, allowCredentials = "true")
public class LikesController {


	private LikesService likesService;
	
	
	
	public LikesController(LikesService likesService) {
		super();
		this.likesService =likesService;
	}



	@PostMapping //create new like 
	public ResponseEntity<Likes>addLikes(@RequestBody Likes likes){
		likesService.addLikes(likes);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public ResponseEntity<?> removeLikes(@RequestBody Likes likes){
		likesService.removeLikes(likes);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping //read the amount of likes
	public ResponseEntity <Likes> shareAllLikes(@RequestBody Post post) {
		likesService.shareAllLikes(post);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
