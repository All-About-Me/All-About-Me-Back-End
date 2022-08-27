package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.exceptions.LSystemTalkException;
import com.revature.exceptions.NoPostException;
import com.revature.models.Likes;
import com.revature.models.Post;
import com.revature.repositories.LikeRepository;
import com.revature.repositories.PostRepository;
import com.revature.repositories.UserRepository;


@Service
public class LikesService {

private LikeRepository likeR;
private PostRepository postR;
private UserRepository userR;


	//Method: Post and like status
	
	public LikesService(LikeRepository likeR, PostRepository postR, UserRepository userR) {
	super();
	this.likeR = likeR;
	this.postR = postR;
	this.userR = userR;
}



	public void likes(Likes likes) {
	//Step 1: Do we have a post? 
		Post post = postR.findById(likes.getPostId())
		.orElseThrow(() -> new NoPostException("401: \n NO POST WITH ID: " + likes.getPostId()));
	
		 
//create new IDCustomer method in authServic
	//Step 2: Did the user like the post ?

		
	Optional<Likes> likeByPostAndUser = likeR.findByUserAndPost(likes.getUser(),post);
	if (likeByPostAndUser.isPresent()) {
		  throw new LSystemTalkException("You have already liked for this post");
		  }}
	
	
	
	//Method: Add likes
	public Likes addLikes(Likes likes) {
	//Step 3: Create/delete a Like	
		return likeR.save(likes);
	}
	
	public void removeLikes(Likes likes) {
	//Step 4: Delete like 	
		List<Likes> likeDelete = likeR.findByPostAndUser(likes.getPost(),likes.getUser());
		for(Likes likesDelete:likeDelete) {
		likeR.delete(likesDelete);	
		}
		
	}
	
	
	public List <Likes> shareAllLikes(Post post) {
	
	//Step 5: Show all likes to post
     
		return likeR.findAllByPost(post);
	}
}