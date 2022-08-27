package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Likes;
import com.revature.models.Post;
import com.revature.models.User;

public interface LikeRepository extends JpaRepository<Likes, Long>{

//	Likes findByPostAndUser(Post post, User user);


 List<Likes> findByPostAndUser(Post post, User user);

Optional<Likes> findByUserAndPost(User user,Post post);
 
   List<Likes> findAllByPost(Post post);

	
}
