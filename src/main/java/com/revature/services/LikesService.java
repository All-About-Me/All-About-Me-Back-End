package com.revature.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.dtos.LikesRequest;
import com.revature.exceptions.LSystemTalkException;
import com.revature.exceptions.NoPostException;
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
	Post post = postR.findById(likesRequest.getPostId())
		.orElseThrow(() -> new NoPostException("401: \n NO POST WITH ID: " + likesRequest.getPostId()));
	
//create new IDCustomer method in authService
	Optional<Likes> likeByPostAndUser = likeR.findByPostAndUser(post, null);
	
	 if (likeByPostAndUser.isPresent() &&
             likeByPostAndUser.get().getLikeSwitch()
             .equals(likesRequest.getLS())) {
		 
         throw new LSystemTalkException("You have already liked for this post");
		}
	 
	/* if(LikesOn.equals(likesRequest.getLS())){
		 
	 }
	 else {
		 
	 }*/
	 
	 
//	 private Likes mappingLikes (LikesRequest likeRequest, Post post) {
//		 return Likes
//	 }
	 
     }
    
	}

	

