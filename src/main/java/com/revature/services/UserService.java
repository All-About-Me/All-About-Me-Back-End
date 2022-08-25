package com.revature.services;

import com.revature.models.Bookmark;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.BookmarkRepository;
import com.revature.repositories.PostRepository;
import com.revature.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    
    @Autowired
    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
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
    

}
