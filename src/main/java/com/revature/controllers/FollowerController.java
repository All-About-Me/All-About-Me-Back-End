package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin(origins = {"http://localhost:4200","http://34.235.88.178:4200"}, allowCredentials = "true")
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
		Optional<Follower> checkFollow = followerService.findByUserAndFollow(currUser, follow);
		if (currUser.getId()!=follow.getId() && checkFollow.isEmpty())
			return followerService.save(follower);
		else
			throw new Exception();
	}
	
	@GetMapping("/following/{id}")
	public List<User> getFollowing(@PathVariable(value="id") Integer id) throws Exception{
		User currUser = userService.findById(id).orElseThrow(()->new Exception());
		return followerService.findByUser(currUser);
	}
	
	@GetMapping("/followers/{id}")
	public List<User> getFollowers(@PathVariable(value="id") Integer id) throws Exception{
		User currUser = userService.findById(id).orElseThrow(()->new Exception());
		return followerService.findByFollow(currUser);
	}
	
	@DeleteMapping("/{id}/{fid}")
	public void removeFollow(@PathVariable(value="id") Integer id, @PathVariable(value="fid") Integer fid) throws Exception {
		User currUser = userService.findById(id).orElseThrow(()->new Exception());
		User follow = userService.findById(fid).orElseThrow(()->new Exception());
		Follower follower = followerService.findByUserAndFollow(currUser, follow).orElseThrow(()->new Exception());
		followerService.delete(follower);
	}
}
