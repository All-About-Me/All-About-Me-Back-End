package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Follower;
import com.revature.models.User;

public interface FollowerRepository extends JpaRepository<Follower, Integer> {

	public List<Follower> findByUser(User user); //returns users being followed by logged in user
	
	public List<Follower> findByFollow(User follows);
	
	public Optional<Follower> findByUserAndFollow(User user, User follow);
}
