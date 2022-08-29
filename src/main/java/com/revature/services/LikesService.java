package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.exceptions.LSystemTalkException;
import com.revature.exceptions.NoPostException;
import com.revature.models.Likes;
import com.revature.models.Post;
import com.revature.models.User;
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
	
	
	//Method: Add likes
	public Likes addLikes(Likes likes) throws Exception {
	//Step 3: Create/delete a Like	

//	Optional<Likes> likeByPostAndUser = likeR.findByUserAndPost(likes.getUser(),likes.getPost());
		Post post = postR.findById(likes.getPost().getId()).orElseThrow(() -> new Exception(""));
		User user =	userR.findById(likes.getUser().getId()).orElseThrow(() -> new Exception(""));	
	Likes likesPU = new Likes(post,user); 
		
		return likeR.save(likesPU);
		
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