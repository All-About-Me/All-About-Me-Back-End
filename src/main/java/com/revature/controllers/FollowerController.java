package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Follower;
import com.revature.models.User;
import com.revature.services.FollowerService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/follower")
@CrossOrigin(origins = {"http://localhost:4200","http://aamfront-enddeploy.s3-website-us-east-1.amazonaws.com/"}, allowCredentials = "true")
public class FollowerController {

	private final FollowerService followerService;
	private final UserService userService;

	public FollowerController(FollowerService followerService, UserService userService) {
		super();
		this.followerService = followerService;
		this.userService = userService;
	}
	
	@PostMapping("/{id}/add")
	public Follower addFollower(@PathVariable(value="id") Integer id, @RequestBody User follow) throws Exception {
		User currUser = userService.findById(id).orElseThrow(()->new Exception());
		Follower follower = new Follower(currUser, follow);
		return followerService.save(follower);
	}
}
