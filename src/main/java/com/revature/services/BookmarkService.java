package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Bookmark;
import com.revature.models.User;
import com.revature.repositories.BookmarkRepository;
import com.revature.repositories.UserRepository;

@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;
	
    public BookmarkService(BookmarkRepository bookmarkRepository, UserRepository userRepository) {
		super();
		this.bookmarkRepository = bookmarkRepository;
		this.userRepository = userRepository;
	}

	public List<Bookmark> retrieveBookmarks(User user){
    	return bookmarkRepository.findByUser(user);
    }
    
    public Bookmark bookmarkPost(Bookmark bookmark) {
    	return bookmarkRepository.save(bookmark);
    }
    
    public void removeBookmark(Bookmark bookmark) {
    	List<Bookmark> bookmarksToDelete=bookmarkRepository.findAllByUserAndPost(bookmark.getUser(), bookmark.getPost());
    	for(Bookmark bookmarkDelete:bookmarksToDelete) {
    	bookmarkRepository.delete(bookmarkDelete);
    	}
    }
}
