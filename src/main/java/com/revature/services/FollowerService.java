package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Follower;
import com.revature.models.User;
import com.revature.repositories.FollowerRepository;

@Service
public class FollowerService {
	private final FollowerRepository followerRepository;

	public FollowerService(FollowerRepository followerRepository) {
		super();
		this.followerRepository = followerRepository;
	}
	
	public List<User> findByUser(User user){
		List<Follower> followList =  followerRepository.findByUser(user);
		List<User> followUsers = new ArrayList<User>();
		for (Follower f:followList) {
			followUsers.add(f.getFollow());
		}
		return followUsers;
	}
	
	public Follower save(Follower follower){
		return followerRepository.save(follower);
	}
	
	public void delete(Follower follower) {
		followerRepository.delete(follower);
	}
	
	public Optional<Follower> findByUserAndFollow(User user, User follow){
		return followerRepository.findByUserAndFollow(user, follow);
	}
}
