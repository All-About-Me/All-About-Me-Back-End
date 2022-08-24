package com.revature.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Likes;
import com.revature.models.Post;
import com.revature.models.User;

public interface LikeRepository extends JpaRepository<Likes, Long>{

Optional<Likes> findByPostAndUser(Post post, User user);
	
}
