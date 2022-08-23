package com.revature.services;

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
	
//	public List<Follower> findAllFollowing(User user){
//		return followerRepository.findAllFollowing(user);
//	}
	
	public Follower save(Follower follower){
		return followerRepository.save(follower);
	}
	
	public void delete(Follower follower) {
		followerRepository.delete(follower);
	}

}
