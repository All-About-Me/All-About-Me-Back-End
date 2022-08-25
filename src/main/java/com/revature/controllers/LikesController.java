package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.LikesRequest;
import com.revature.services.LikesService;

@RestController
@RequestMapping("/liked")
@CrossOrigin(origins = {"http://localhost:4200","http://aamfront-enddeploy.s3-website-us-east-1.amazonaws.com"}, allowCredentials = "true")
public class LikesController {


	private LikesService likesService;
	
//	@PostMapping //create new like 
//	public ResponseEntity<Void>likes(@RequestBody LikesRequest likesRequest){
//		likesService.likes(likesRequest);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
}
