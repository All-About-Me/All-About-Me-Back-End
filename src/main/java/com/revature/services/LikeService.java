package com.revature.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.models.Like;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.LikeRepository;
import com.revature.repositories.PostRepository;
import com.revature.repositories.UserRepository;



@Service
public class LikeService {

	LikeRepository likeR;
	PostRepository postR;
	UserRepository userR;
	AuthService authService;
	
	

	public LikeService(LikeRepository likeR, PostRepository postR, UserRepository userR, AuthService authService) {
		super();
		this.likeR = likeR;
		this.postR = postR;
		this.userR = userR;
		this.authService = authService;
	}

	public Like likeAPost(Like like) {
	Post post = postR.findById(like.getPost().getId()).orElseThrow();
	User user = userR.findById(like.getUser().getId()).orElseThrow();
	return likeR.save(new Like(post, user));
	
     }
	
	public void removeLike(Like like) {
		Like likeToDelete = likeR.findByPostAndUser(like.getPost(), like.getUser()).orElseThrow();
		likeR.delete(likeToDelete);
	}
    
	}

	

