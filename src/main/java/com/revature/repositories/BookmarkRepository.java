package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Bookmark;
import com.revature.models.Post;
import com.revature.models.User;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

	public List<Bookmark> findByUser(User user);

	public Bookmark findByUserAndPost(User user, Post post);
	
}
