package com.revature.services;

import com.revature.models.Bookmark;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.BookmarkRepository;
import com.revature.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BookmarkRepository bookmarkRepository;
    
    @Autowired
    public UserService(UserRepository userRepository, BookmarkRepository bookmarkRepository) {
        this.userRepository = userRepository;
        this.bookmarkRepository =bookmarkRepository;
    }
    
    public Optional<User> findById(Integer id){
    	return userRepository.findById(id);
    }

    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers(){ 
    	return this.userRepository.findAll();
    }
    
    public List<Bookmark> retrieveBookmarks(User user){
    	return bookmarkRepository.findByUser(user);
    }
    
    public Bookmark bookmarkPost(Bookmark bookmark) {
//    	Bookmark bookmark= new Bookmark(post, user);
    	return bookmarkRepository.save(bookmark);
    }
    
    public void removeBookmark(Bookmark bookmark) {
    	Bookmark bookmarkToDelete=bookmarkRepository.findByUserAndPost(bookmark.getUser(), bookmark.getPost());
    	bookmarkRepository.delete(bookmarkToDelete);
    	//TODO add delete confirmation 

    }
}
