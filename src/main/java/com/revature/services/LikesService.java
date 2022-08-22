package com.revature.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.dtos.LikesRequest;
import com.revature.exceptions.LSystemTalkException;
import com.revature.models.Likes;
import com.revature.models.Post;
import com.revature.models.LikeSwitch;
import com.revature.repositories.LikeRepository;
import com.revature.repositories.PostRepository;
import com.revature.repositories.UserRepository;



@Service


public class LikesService {

	LikeRepository likeR;
	PostRepository postR;
	UserRepository userR;
	AuthService authService;

	public void likes(LikesRequest likesRequest) {
	Optional<Post> post = postR.findById(likesRequest.getPostId());
		
		//create new IDCustomer method in authService
	Optional<Likes> questionLikePostWithUser = likeR.likePostWithUser(post, authService.findByCredentials(null, null));
	
	/* if (questionLikePostWithUser.isPresent() &&
             questionLikePostWithUser.get.)
         throw new LSystemTalkException("You have already liked for this post");
     */
     }
    
	}

	

