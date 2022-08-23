package com.revature.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Authorized;
import com.revature.models.Post;
import com.revature.services.PostService;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/post")
@CrossOrigin(origins = {"http://localhost:4200","http://aamfront-enddeploy.s3-website-us-east-1.amazonaws.com/"}, allowCredentials = "true")
public class PostController {

	private final PostService postService;
    private final HttpServletRequest req;

    public PostController(PostService postService, HttpServletRequest req) {
        this.postService = postService;
        this.req = req;
    }
    
    @Authorized
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        HttpSession s = req.getSession();
        log.info(s.getAttribute("user") + "123");
    	return ResponseEntity.ok(this.postService.getAll());
    }
    
    @Authorized
    @PutMapping
    public ResponseEntity<Post> upsertPost(@RequestBody Post post) {
    	return ResponseEntity.ok(this.postService.upsert(post));
    }
    
    
    
}
