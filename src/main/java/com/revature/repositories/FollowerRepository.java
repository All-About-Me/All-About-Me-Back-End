package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Follower;
import com.revature.models.User;

public interface FollowerRepository extends JpaRepository<Follower, Integer> {

	//public List<Follower> findAllFollowing(User user); //returns users being followed by logged in user
	
	
}
