package com.revature.services;

import java.util.ArrayList;
import java.util.Collections;
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
		List<Post> allPosts = this.postRepository.findAll();
		List<Post> comments = new ArrayList<Post>();
		List<Post> allPostsWOC = new ArrayList<Post>();
		for (Post p:allPosts) {
			if (!p.getComments().isEmpty())
				comments.addAll(p.getComments());
		}
		for (Post p:allPosts) {
			if (!comments.contains(p))
				allPostsWOC.add(p);
		}
		Collections.sort(allPostsWOC, Collections.reverseOrder());
		return allPostsWOC;
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
		Collections.sort(followedPosts, Collections.reverseOrder());
		return followedPosts;
	}

	public Post upsert(Post post) {
		return this.postRepository.save(post);
	}
	
	 public Optional<Post> findById(Integer id){
	    	return postRepository.findById(id);
	    }
}
