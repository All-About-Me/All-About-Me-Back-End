package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Like;
import com.revature.models.Post;
import com.revature.models.User;

public interface LikeRepository extends JpaRepository<Like, Long>{

	Optional<Like> findByPostAndUser(Post post, User user);
	
	Optional<List<Like>> findAllByUser(User user);
	
	Optional<List<Like>> findAllByPost(Post post);

	
}
