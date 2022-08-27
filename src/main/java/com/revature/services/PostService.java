package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.FollowerRepository;
import com.revature.repositories.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	private FollowerService followerService;
	
	public PostService(PostRepository postRepository, FollowerService followerService) {
		this.postRepository = postRepository;
		this.followerService = followerService;
	}

	public List<Post> getAll() {
		return this.postRepository.findAll();
	}
	
	public List<Post> getFollowedPosts(User currUser){
		List<User> followList = followerService.findByUser(currUser);
		List<Post> allPosts = postRepository.findAll();
		List<Post> followedPosts = new ArrayList<Post>();
		for (Post post:allPosts) {
			if (followList.contains(post.getAuthor())) {
				followedPosts.add(post);
			}
		}
		return followedPosts;
	}

	public Post upsert(Post post) {
		return this.postRepository.save(post);
	}
	
	 public Optional<Post> findById(Integer id){
	    	return postRepository.findById(id);
	    }
}
