package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Bookmark;
import com.revature.models.User;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

	public List<Bookmark> findByUserId(User user);
	
}
